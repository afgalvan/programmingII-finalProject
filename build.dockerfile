FROM openjdk:8-jdk-alpine
COPY ./lib /usr/lib
COPY ./src/ /usr/app
WORKDIR /usr/
RUN mkdir -p out/production/final_project
RUN javac $(find ./app/* | grep .java) -d out/production/final_project -cp lib/junit-4.12.jar
CMD ["java", "-cp", "out/production/final_project/:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar", "org.junit.runner.JUnitCore", "test.main.SuiteTest"]
