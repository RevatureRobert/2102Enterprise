package dev.enterprise.intro;

import java.io.CharConversionException;
import java.io.IOException;
import java.util.List;

public class Person2 {

    final String s;

    public Person2() {
        s="sakrhg";
    }

    public Person2(String s) {
        this.s = s;
    }

    protected void talk(Person p){
        System.out.println("im here to talk");
        p.talk();
    }

    public void talk(String s){
        System.out.println(s);
    }

    public void talk(String s, Person p){
        System.out.println(s);
        p.talk();
    }

    public void talk(Person p, String s){
        p.talk();
        System.out.println(s);
    }

    public void talk(){
        System.out.println("nobody here, but im going to say what I want to say");
    }
    
    public String talk(int ikusfdhg){
        return "";
    }

    public void talk(String[] args){
        for(String s : args){
            System.out.println(s);
        }
    }

    protected List<? extends Person2> something() throws IOException{
        throw new CharConversionException();
    }


    public static void main(String... args) throws Exception{
        Person2 p = new Person2();
        p.talk(new Person());
        p.talk(new String[]{"this is the first","this is the second","omg does it stop","im controlling the person",
                "bwahahaahahahaahaha"});
        
        p.talk(54);
        
    }

}
