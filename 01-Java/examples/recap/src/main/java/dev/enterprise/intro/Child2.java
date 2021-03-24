package dev.enterprise.intro;

import java.io.CharConversionException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.List;

public class Child2 extends Person2 {

    //    String s = "child s";
    @Override
    public void talk(Person p) {
        System.out.println("in the child");
    }

    public Child2(String s) {
        super();
    }

    //can be less restrictive but not more
    //throws declaration, can be less number of exceptions or subtypes
    // can return subtypes of the parent's return type, but not a super class (covariant return types)
    @Override
    public List<Child2> something() throws CharConversionException {
        return null;
    }

    public static void main(String[] args) {
        Person2 p = new Child2("sdklfjfg");

        //upcasting
        p.talk(new Person());

        System.out.println(p.s);
        System.out.println(((Child2) p).s);

//
//        List<String> list = p.something();



    }


}
