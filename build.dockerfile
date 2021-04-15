FROM openjdk:8-jdk-alpine
COPY ./lib /usr/lib
COPY ./src/ /usr/src
COPY .ecrc /usr/
WORKDIR /usr/
RUN mkdir -p out/production/FinalProject
RUN javac $(find ./src/* | grep .java) -d out/production/FinalProject -cp lib/junit-4.12.jar:lib/lombok.jar:lib/jackson-anotations-2.12.2.jar:lib/jackson-core-2.12.2.jar:lib/jackson-databind-2.12.2.jar:lib/sqlite-jdbc-3.32.3.2.jar:lib/RojeruSan.jar:lib/flatlaf-1.1.1.jar
ENTRYPOINT ["java", "-cp", "out/production/FinalProject/:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar:lib/jackson-annotations-2.12.2.jar:lib/jackson-core-2.12.2.jar:lib/jackson-databind-2.12.2.jar:lib/sqlite-jdbc-3.32.3.2.jar:lib/RojeruSan.jar:lib/flatlaf-1.1.1.jar", "org.junit.runner.JUnitCore", "test.TestSuite"]
