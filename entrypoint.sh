#!/bin/bash

mvn test -Dremote.url=$REMOTE_URL -Dapk.path=$APK_PATH -Dplatform.name=$PLATFORM_NAME -Dplatform.version=$PLATFORM_VERSION -Davd=$AVD