FROM zenika/kotlin:1.4.10-jdk12-alpine
COPY ./lib /usr/lib
COPY ./src/ /usr/src
WORKDIR /usr/
RUN javac $(find ./src/app/* | grep .java) -d out/production/final_project -cp lib/junit-4.12.jar
RUN kotlinc ./src/test/**/*.kt ./src/app/**/*.java -d out/production/final_project -cp lib/junit-4.12.jar
CMD ["java", "-cp", "out/production/final_project/:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar", "org.junit.runner.JUnitCore", "test.main.MainTest"]
