# Spring boot -cucumber - BDD
Cucumber is one of the tools written in ruby to do business-driven development. From my point of view, BDD is almost similar to TDD and it is on top TDD with an extra step that has the feature file where you write the different business scenarios in plain English, which is understandable by business people.

Against these feature files, you will have the step-definition classes where each scenario will present into multiple-step method to write the logic inside that. The step definition class will be similar to your traditional JUNIT test class at TDD development.

How to integrate cucumber into Spring boot?
To integrate cucumber into spring boot we need 3 maven dependency to be added to your pom.xml
cucumber-java
cucumber-junit
cucumber-spring
You can find the latest version of these dependence from here https://mvnrepository.com/artifact/io.cucumber
You can find the latest version of these dependence from here https://mvnrepository.com/artifact/io.cucumber

Create a new spring boot project using spring initializer from https://start.spring.io/ and add you're relevant dependency. In this example, I will add only the spring-boot-starter-web dependency.
Now add cucumber-java, cucumber-junit and cucumber-sprint dependency to pom.xml. Once you add the above dependency your pom file should look similar to below.

In the pom.xml file if you noticed we have commented the exclusion of comment the exclusion of junit-vintage-engine, as cucumber is not supported Junit 5 yet more here (https://github.com/cucumber/cucumber-jvm/issues/1149) and spring boot 2.2 comes with Junit 5
so we need the  junit-vintage-engine to run the Junit 4 test cases.

Wrtie the feature file
Create a source folder like src/test/resources and add the feature file like below.

You can generate the step definition step method by running the feature file as a cucumber feature and copy the method signature from the console output
