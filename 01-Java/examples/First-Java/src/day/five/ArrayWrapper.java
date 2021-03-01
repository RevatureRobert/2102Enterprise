package day.five;

import java.util.Arrays;

public class ArrayWrapper {

    Object[] objList;
    private int currentIndex = 0;

    public ArrayWrapper(Object[] objList) {
        this.objList = objList;
    }

    public void add(Object o){
        this.objList[currentIndex++] = o;
    }

    public Object get(int index){
        currentIndex--;
        return this.objList[index];
    }

    public static void main(String[] args) {
        ArrayWrapper aw = new ArrayWrapper(new Object[10]);

        aw.add("this is a string");
        aw.add(new Integer(7));
        aw.add(new Exception());

//        Integer i = (Integer) aw.get(2);
        for(Object o: aw.objList){
            if(o instanceof Integer){
                Integer i = (Integer) o;
                i = i +5;
                System.out.println(i);
            }
        }
    }
}
