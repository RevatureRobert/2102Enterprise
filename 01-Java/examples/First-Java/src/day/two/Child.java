package day.two;

import javax.swing.*;

public class Child extends Parent{

    String lastname;

    public void print(){
        System.out.println("in the child");
    }

    public void doSomething(){
        System.out.println("do something");
    }

    Child(){
        super("whatever was in it");
        this.lastname = "this class";
    }
}
