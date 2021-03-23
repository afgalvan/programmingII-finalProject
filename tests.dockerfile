FROM zenika/kotlin:1.4.10-jdk12-alpine
COPY ./out/production/final_project /usr/test/
COPY ./lib /usr/lib
WORKDIR /usr/
CMD ["java", "-cp", "test/:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar", "org.junit.runner.JUnitCore", "test.main.MainTest"]
