package dev.enterprise.designs;

/**
 * Dependency Injection
 *      purpose: Abstract away implementations and only worry about the functionality avaliable to us.
 *          It further abstracts away the creation of these implementations and injects the actual
 *          instances into our instances.
 */
public class DependencyInjection {


    public static void main(String[] args) {
        Injector i = new Injector();
        SomethingNeedingToBeInjectedInto s = i.getDi();
        s.run();
    }
}

// functionality provider (api)
interface A {
    void save(Object o);
}

// implementations of the api
class AImplA implements A {

    @Override
    public void save(Object o) {
        System.out.println("the A impl's class");
    }
}

class B implements A{
    @Override
    public void save(Object o) {
        System.out.println("in the B impl's class");
    }
}

// The injector that needs to be configured, but will be the class injecting values into the classes
//      and maintaining the instances that need to be injected
class Injector{

    // This is usually done with outside configuration, either through code or config files
    SomethingNeedingToBeInjectedInto di;
    A a;

    public Injector(){
        a = new B();
        // This is usually done with reflection...
        di = new SomethingNeedingToBeInjectedInto(a);
    }

    public SomethingNeedingToBeInjectedInto getDi(){
        return di;
    }

}

//Something that needs something injected into it. This is using constructor injection,
//      but we could have used setter injection or uti
class SomethingNeedingToBeInjectedInto {

    A a;


    public void run(){
        a.save(new Object());
    }


    // pretend there is an annotation here, @Inject even
    SomethingNeedingToBeInjectedInto(A a){
        this.a = a;
    }

}