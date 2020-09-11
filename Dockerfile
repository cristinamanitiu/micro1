FROM amazoncorretto:11

ARG JAR_FILE=target/micro1-*.jar

ENV APP_ID=9988 \
    APP_NAME=test

RUN yum install -y shadow-utils  && \
    groupadd --gid $APP_ID $APP_NAME && \
    useradd --uid $APP_ID --gid $APP_NAME --shell /bin/bash --create-home $APP_NAME && \
    yum clean all

USER $APP_NAME

COPY ${JAR_FILE} /usr/local/bin/micro1.jar

ENTRYPOINT ["java", "-Xms512M", "-jar", "/usr/local/bin/micro1.jar"]