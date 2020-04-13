FROM alpine:latest
ADD GUI.class GUI.class
RUN apk --update add openjdk8-jre
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "GUI"]