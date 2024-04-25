timeout(10) {
    node("maven") {

        wrap([$class: 'BuildUser']) {
            currentBuild.description = """
                build user : $BUILD_USER
                branch : $BRANCH
            """

            params = readYaml text: env.YAML_CONFIG ?: null
            if (params != null) {
                for (param in params.entrySet()) {
                    env.setProperty(param.getKey(), param.getValue())
                }
            }
        }

        stage("Checkout") {
            checkout scm
        }

        stage("Create configurations") {
            sh "echo REMOTE_URL=${env.getProperty('REMOTE_URL')} > ./.env"
            sh "echo APK_PATH=${env.getProperty('APK_PATH')} >> ./.env"
            sh "echo PLATFORM_NAME=${env.getProperty('PLATFORM_NAME')} >> ./.env"
            sh "echo PLATFORM_VERSION=${env.getProperty('PLATFORM_VERSION')} >> ./.env"
            sh "echo AVD=${env.getProperty('AVD')} >> ./.env"
        }

        stage("Build Docker image") {
            sh "docker build -t mobile_tests:1.0.0 ."
        }

        stage("Run tests") {
            def exitCode = sh(
                    returnStatus: true,
                    script: """
                        docker run --rm \
                        --env-file ./.env \
                        --network=host \
                        -v m2:/root/.m2 \
                        -v ./allure-results:/home/user/mobile_tests/target/allure-results \
                        -t mobile_tests:1.0.0
                    """
            )
            if(exitCode == 1) {
                currentBuild.result = 'UNSTABLE'
            }
        }

        stage("Publish allure results") {
            allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: './allure-results']]
            ])
        }
    }
}