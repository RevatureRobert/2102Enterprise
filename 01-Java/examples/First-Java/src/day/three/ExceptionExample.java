package day.three;


import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.sql.SQLException;

/**
 *                          Throwable
            Exception (checked)         Error (unchecked)
 *          RuntimeException (unchecked)
 */
public class ExceptionExample {

    public static void main(String[] args) {
//        Exception e = new Exception("this is a message");
////        System.out.println(e.getMessage());
//        throw e;

        //examples of checked exceptions
//        FileNotFoundException
//        IOException
//        SQLException
        //examples of unchecked exceptions
//        NullPointerException
//        ClassCastException
//        IndexOutOfBoundsException
        //Errors
//        OutOfMemoryError
//        StackOverflowError
//        NoClassDefFoundError

        try {
            add(1, 2);
        } catch (IOException e){
            e.printStackTrace();
        }

    }



    static int add(int a, int b) throws IOException {
        throw new IOException();
    }
}
