package day.two;

public class Driver {

    public static void main(String[] args) {
//        Parent p = new Parent("something");
//        Child p = new Child();
//        Parent p = new Child(); //upcasting
//        child c = (Child)p; //down casting
//        long l = 5L;
//        int x = (int)l;
//        l = x;
//        System.out.println(p.lastname);
//        System.out.println(((Child)p).lastname); //down casting


//        Parent p = new Parent("parent");
//        p.print()     // in the parent
//        Child p = new Child();
//        p.print()     // in the child
//        Parent p = new Child();
//        ((Parent)p).print();        //in the child

        Child c = (Child)new Parent("something");
        c.doSomething();

    }
}
