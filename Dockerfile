FROM maven:3.9.0

RUN mkdir -p /home/user/mobile_tests

WORKDIR /home/user/mobile_tests

COPY . /home/user/mobile_tests

ENTRYPOINT ["/bin/bash", "entrypoint.sh"]
