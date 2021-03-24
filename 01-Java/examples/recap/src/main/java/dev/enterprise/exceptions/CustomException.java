package dev.enterprise.exceptions;

public class CustomException extends Exception {

    public CustomException() {
        super("this is default for the custom exception.");
    }
    public CustomException(String message) {
        super(message);
    }

    public CustomException(Throwable throwable) throws Throwable {
        throw throwable;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {

        try{
//            throw new CustomException(new Exception());

        } finally {
            System.out.println("in the finally ");
//            Object
        }

    }
}
