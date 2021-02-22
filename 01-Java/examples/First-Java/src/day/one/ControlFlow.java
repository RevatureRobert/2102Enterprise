package day.one;

public class ControlFlow {

    public static void main(String[] args){


        boolean b = true;

        // for loop
//        for(int i  = 0, j = 1; i<10; ++i){
//            System.out.println(++j);
//        }

//        while(b){
//            System.out.println("it is true");
//            b = false;
//        }
//
//        do {
//            System.out.println("its false but whatever");
//        } while(b);
//


//        b = false;
//        if(b) {
//            System.out.println("its true");
//        }
//        else if(!b){
//            System.out.println("it isnt b");
//        } else {
//            System.out.println("its false");
//        }

        int x = 7;
        switch (x) {
            case 1:
                System.out.println("it is 1, dude");
                break;
            case 2:
                System.out.println("it is 2, i dont know");
                break;
            case 3:
                System.out.println("this is 3");
                break;
            default:
                System.out.println("it is defaulted because we dont know what it could be");
                break;
        }


    }
}
