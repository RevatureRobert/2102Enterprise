package day.four.nest;

public class FryingPan {


    public void scramble(Scrambalable s){

        System.out.println("trying to scramble but the thing said");
        s.fightBack();
    }

    public void FryMargarita(Margaritable m, String s){
        System.out.println(m.canItMargarita(s)?s+" can be margaritad":s+" cannot be margaritad");
    }

    public void BaconateIt(Baconable b, String s){
        b.makeItBacon(s);

    }

}
