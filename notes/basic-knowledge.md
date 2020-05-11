## Basic Knowledge of Springboot 

### Things to know about POM.xml
- POM = Project Objest Model 
- Where we can file all of the dependencies in this file
- Transitive Dependency = a dependency needs another framework for it to work. For instance, string boot needs spring to work  so that spring is the transitive dependency 
- <plugin>, spring-boot-maven-plug in helps in easy running springboot application, and help creating jar/war file in the application.
- **External Libraries** is where all of the dependencies are installed 
- We can also find the java version used in the project under `<java.version>14</java.version>`

### Application file (src/main/)
- we can see **@SpringBootApplication**, it is used to initialze spring frame work and it will initializes Spring (Component Scan) and springboot(auto config)
- **SpringApplication.run** launches a Spring Boot Application 

### application.properties file (src/main/resource)
- Application properties file is used as a config file. For instance, if we can config the app to run in  port 9000

## Running the app 
- Running the app in the IDE and the go to port 8080 
- To print first "hello world". To do that we need to **/login** to a java class. We will also be creating a controller and map the value to Controller.
- Since we created the project with Developer tool, the application will pick up the changes whenever we save
-  create a method to return the string and map the method by adding `@RequestMapping`
- To allow stringboot to pick up the class we need to add `@Controller` at the top of class
- To Debug, add the `logging.level.org.springframework.web = DEBUG` to **application.properties** file for logging debug message
- We will realized it will not print the return Error **DispatcherServlet**, it is doing the mapping  but  the controller start looking for a **view**. Since we only want to print just the string we can add `@ResponseBody` to fix it 