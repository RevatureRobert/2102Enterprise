package day.four.nest;

public  class Chicken {

    private double beakLength;
    private int featherCount;

    public class Egg implements Scrambalable  {

        @Override
        public void fightBack() {
            System.out.println("hiya!!!!!!!!!!");
        }
    }


    public static void main(String[] args) {
        Chicken c = new Chicken();
//        Chicken.Egg e = c.createEgg();
//        e = c.new Egg();  // If Egg is instance scoped
//        e.c = new Chicken();
//        e.c.e = c.new Egg();
//        e.c.e.c = new Chicken();
//        e.c.e.c.e = e.c.e.c.new Egg();    // I got carried away
//        Egg e1 = new Chicken.Egg(); //If Egg was static
    }

}

