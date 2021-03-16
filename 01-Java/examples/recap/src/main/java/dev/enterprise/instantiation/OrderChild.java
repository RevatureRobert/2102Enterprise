package dev.enterprise.instantiation;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class OrderChild extends OrderParent{

    {
        System.out.println("in the child init block");
    }

    static {
        System.out.println("in the child static init block");
    }

    String saying = "say something";
    static String s = "something class bound";

    public OrderChild() {
        this("In the child");
        System.out.println(s);
        System.out.println("In the child");
    }

    public OrderChild(String s){
        super();
        System.out.println(s);
    }

    public void print(){
        System.out.println(this.s);
        System.out.println(this.saying);

    }

    public static void call(){
        System.out.println(s);
//        System.out.println(saying);
    }

}
