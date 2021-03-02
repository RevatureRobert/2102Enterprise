package day.five;

import java.util.List;

public class WildcardExample {

    public void wildList(List<?> list, A a, B b, C c){
//       list.add(a);
//       list.add(b);
//       list.add(c);
//       list.add(new Object());
//       a = list.get(1);
//       b = list.get(1);
//       c = list.get(1);
       Object o = list.get(1);
//       for(Object o : list){
//           System.out.println(o);
//       }
    }

    public void superList(List<? super B> list, A a, B b, C c){

//        list.add(a);
//        list.add(b);
//        list.add(c);
//        a = list.get(1);
//        b = list.get(1);
//        c = list.get(1);
    }

    public void subList(List<? extends B> list, A a, B b, C c){
//        list.add(a);
//        list.add(b);
//        list.add(c);
//        a = list.get(1);
//        b = list.get(1);
//        c = list.get(1);
    }
}


class A{}
class B extends A{}
class C extends B{}