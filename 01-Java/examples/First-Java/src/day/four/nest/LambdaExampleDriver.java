package day.four.nest;

public class LambdaExampleDriver {
    public static void main(String[] args) {
        Words w = new Words();

        // Method scoped class declaration, can also do local
        class Brains implements Scrambalable {

            @Override
            public void fightBack() {

            }
        }
        // instantiate the new class
        Brains b = new Brains();

        // instantiate a local anonymous class that implements an interface, can also do Abstract class, but
        //      only one or the other
        Scrambalable s = new Scrambalable(){

            @Override
            public void fightBack() {

            }
        };

        // If you only need an implementation of a interface, not an abstract class, that only has one
        //      method, and you dont need it again. This is right up your alley
        Scrambalable s2 = () -> {
            System.out.println("hey");
        };

        // Inline implementation of a single method in an interface
        Scrambalable s3 = () -> System.out.println("one liner");


        ScrambleStore ss2 = new ScrambleStore(b);
        ScrambleStore ss = new ScrambleStore(w);

        // lambda inside method arguments
        FryingPan f = new FryingPan();
        f.scramble(() -> System.out.println("heeeeeeyyyyyyyyaaaaaaaaa"));

        f.FryMargarita((str -> str.length()>5), "asfljkhgsajhsdf fgjlkasv lasdf lh");

        f.BaconateIt(str -> System.out.println(str), "everything not only goes good with bacon...it is bacon!!!duh duh duh!!!!!");

        Inception i = scram -> scram.fightBack();
        i.what(() -> System.out.println("scrambale"));

        // Method Reference
        Baconable bacon1 = System.out::println;




    }
}
