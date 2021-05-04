Set up the project structure.  
1. Project SDK should be 11.0.5
2. Project language level should be 11
3. Choose pom.xml to be the module file
4. Set src/main/java to be the Source Folders
5. Set src/test/java to be the Test Source Folders
6. Set src/main/resources to be the Resource Folders
7. Notice that if you pull this project from version control (Gitlab), the above steps should work. However, if you download the project through a browser, there might be a problem with paths. You need to set up every path to be the absolute path on your computer, including each path of pictures in each java file. For example, /Users/pro/Documents/gitlab/src/main/resources/image/door.png
8. Set your output paths, if they are not automatically generated. For example, /Users/pro/Documents/gitlab/target/classes for output path, /Users/pro/Documents/gitlab/target/test-classes for test output path.

Secondly: Run:  
1. Use your IDE to build and run this game: go to src/main/java/core/Launcher.java, run this file.
2. Or, use command line through your terminal: use "javac filename.java" to compile, and "java filename" to run.

Thirdly: Test:  
1. Do similar steps to all test.java files.
2. You may modify arguments for Assert.assertEquals() in order to do more test cases. The first argument is the value you expected, while the second value is the actual value you got.
3. You could also try running tests with coverage to see how many codes are covered in test.

Fourthly: Artifacts:  
1. By doing "install", all java files and javadocs are packaged in to a JAR file.
2. Use your IDE to build and run artifacts: go to maven tool options, find out "install", run "install". It should generate a JAR file under src directory, run this file.
3. Or, use command line through your terminal: use "mvn install" to compile the POM file. Then use "java -jar Virus2020-4.0.jar" to excute.