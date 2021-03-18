FROM alpine:3.13.2
COPY ./out/production/final_project/ /usr/out/
WORKDIR /usr/out/
RUN apk --no-cache add openjdk8-jre
CMD ["java", "edu.unicesar.programming2.group01.classroom.project.main.Main"]