mkdir -p out/production/final_project
javac -encoding utf8 ( Get-ChildItem -Recurse -Path ./ -Include '*.java' -Name ) -d out/production/final_project -cp lib/junit-4.12.jar:lib/lombok.jar:lib/jackson-anotations-2.12.2.jar:lib/jackson-core-2.12.2.jar:lib/jackson-databind-2.12.2.jar:lib/sqlite-jdbc-3.32.3.2.jar
