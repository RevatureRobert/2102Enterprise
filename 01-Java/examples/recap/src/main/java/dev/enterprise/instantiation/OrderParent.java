package dev.enterprise.instantiation;

public class OrderParent extends Object {

    {
//        System.out.println(parentString);
        System.out.println("this is an instance init block");
         parentString = "something with the parent instance";
//        System.out.println(parentString);
    }

    static {
        System.out.println("This is a static init block");
    }

    String parentString;
    static String parentClassString = "something with the parent class";

    public void somethingInstance(){
        System.out.println("in the parent instance");
    }

    public static void something(){
        System.out.println("something");
    }
    public OrderParent() {
        super();
        System.out.println("In the parent");
    }


}
