FROM zenika/kotlin:1.2.71-jdk8-slim
COPY ./lib /usr/lib
COPY ./src/ /usr/src
WORKDIR /usr/
RUN mkdir -p out/production/final_project
RUN javac $(find ./src/app/* | grep .java) -d out/production/final_project -cp lib/junit-4.12.jar
RUN kotlinc ./src/test/**/*.kt ./src/app/**/*.java -d out/production/final_project -cp lib/junit-4.12.jar
CMD ["java", "-cp", "out/production/final_project/:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar", "org.junit.runner.JUnitCore", "test.main.MainTest"]
