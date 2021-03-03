package day.extra;

public class PassByValue {

    static Object o;

    public int something(int i){
        i = i + 1;
        return i;
    }

    public Object somethingWithObj(Object o){
        o = new Object();
        return o;
    }

    public A somethingWithA(A a){
        a.i++;
        return a;
    }

    public static void main(String[] args) {
        int i = 1;
        Object obj = new Object();
        PassByValue p = new PassByValue();

        i = p.something(i);

        System.out.println(i);

        int hash1 = obj.hashCode();
        p.somethingWithObj(obj);

        System.out.println(hash1 == obj.hashCode());

        A a = new A();
        a.i = 6;

        p.somethingWithA(a);
        System.out.println(a.i);
    }
}

class A  {
    int i;
}