FROM alpine:latest
COPY ./out/production/actividad3 /usr/src/
WORKDIR /usr/src/
RUN apk --update add openjdk8-jre
CMD ["java", "edu.unicesar.path.to.Main"]
