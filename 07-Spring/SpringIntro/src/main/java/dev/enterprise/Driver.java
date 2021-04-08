package dev.enterprise;


import dev.enterprise.service.MockJokesService;
import dev.enterprise.util.MockMelonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring Framework.
 * How does this differ from Hibernate, JUnit, Log4J, or other frameworks that we have worked with
 * Previously?
 * <p>
 * 1. Spring is module based
 * 2. Open source
 * Ok Robert, Richard whoever, What is it that makes spring so good and wonderful to us all???
 * <p>
 * 1. The core of Spring is that it is a Dependency Injection Framework
 * <p>
 * So...What is all this about Spring beans???
 * <p>
 * A class that Spring is going to manage for you.
 * <p>
 * But how do we tell spring what beans to keep track of, or how to wire them together, or other
 * necessary configurations.
 * <p>
 * <p>
 * Glad you asked self...
 * <p>
 * 1. XML
 * 2. Java classes
 * 3. Annotations
 * 4. Groovy
 * <p>
 * This is really cool and all that jazz, but how does it do it???
 * <p>
 * 1. Spring is providing an IOC Container [Inversion of Control]
 * a. names of IOC container: BeanFactory, ApplicationContext
 * 2. Finds the classes to be used for managing
 * a. XML config pointing directly to the class
 * b. Package scanning
 * 3. Injects the custom classes into one another (It sounds violent but don't worry, it is)
 * a. configure constructor injection
 * b. configure Setter injection
 * c. configure Field injection
 */
public class Driver {

    public static void main(String[] args) {

        // Create the IOC container (ApplicationContext) and provide the implementation we are
        //      instantiating with the location of the configuration.
        ApplicationContext context = new ClassPathXmlApplicationContext("anotherBeans.xml");

        MockJokesService service =
//                (MockJokesService) context.getBean("mockWhalburg");
                context.getBean(MockJokesService.class);
        System.out.println(service.getAllJokes());
//        MockMelonService melons = context.getBean(MockMelonService.class);
//        System.out.println(melons);
        context.getBean(MockJokesService.class);
        context.getBean(MockJokesService.class);
        context.getBean(MockJokesService.class);
        context.getBean(MockJokesService.class);
        context.getBean(MockJokesService.class);
        context.getBean(MockJokesService.class);
        context.getBean(MockJokesService.class);
        context.getBean(MockJokesService.class);
        context.getBean(MockJokesService.class);
        context.getBean(MockJokesService.class);
        context.getBean(MockJokesService.class);
        context.getBean(MockJokesService.class);
        context.getBean(MockJokesService.class);
        context.getBean(MockJokesService.class);

    }
}
