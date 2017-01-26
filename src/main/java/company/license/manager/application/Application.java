package company.license.manager.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// The annotation replaces the following ones:
// @Configuration - tags the class as a source of bean definitions for the application context;
// @EnableAutoConfiguration - tells Spring Boot to start adding beans based on classpath settings,
// other beans, and various property settings;
// @ComponentScan tells Spring to look for other components, configurations 
// and services in the current package, allowing it to find the controllers.
//
// Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically,
// when it sees spring-webmvc on the classpath. This flags the application as a web application
// and activates key behaviors such as setting up a DispatcherServlet.

@SpringBootApplication
public class Application
{
    public static void main(String[] args) throws Throwable
    {
        SpringApplication.run(Application.class, args);
    }
}
