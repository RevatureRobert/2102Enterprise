package day.five;

public class GenericArray<T> {

    T[] objList;
    private int currentIndex = 0;

    public GenericArray(T[] objList) {
        this.objList = objList;
    }

    public void add(T o){
        this.objList[currentIndex++] = o;
    }

    public T get(int index){
        currentIndex--;
        return this.objList[index];
    }

    public void wildcard(GenericArray<?> arr){

    }

    public void superArray(GenericArray<? super Integer> arr){
    }

    public void SubArray(GenericArray<? extends Integer> arr){

    }
    public static void main(String[] args) {
        GenericArray<Integer> intArr = new GenericArray<>(new Integer[10]);

        intArr.add(7);
        intArr.add(new Object());
//        intArr.add("this is a string");  //compiler error
        Object i = intArr.get(1);

    }
}
