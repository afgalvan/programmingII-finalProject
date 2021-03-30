FROM openjdk:8-jdk-alpine
COPY ./lib /usr/lib
COPY ./src/ /usr/src
COPY .ecrc /usr/
WORKDIR /usr/
RUN mkdir -p out/production/final_project
RUN javac $(find ./src/* | grep .java) -d out/production/final_project -cp lib/junit-4.12.jar:lib/lombok.jar:lib/jackson-anotations-2.12.2.jar:lib/jackson-core-2.12.2.jar:lib/jackson-databind-2.12.2.jar
CMD ["java", "-cp", "out/production/final_project/:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar:lib/jackson-annotations-2.12.2.jar:lib/jackson-core-2.12.2.jar:lib/jackson-databind-2.12.2.jar", "org.junit.runner.JUnitCore", "test.TestSuite"]
