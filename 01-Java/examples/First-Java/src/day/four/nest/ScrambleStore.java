package day.four.nest;

import com.sun.javafx.scene.SceneHelper;

public class ScrambleStore {

    Scrambalable words;

    Scrambalable cakeBatter;

    Scrambalable brains;

    ScrambleStore(Scrambalable words){
        this.words = words;
    }
}


class Words implements Scrambalable {

    @Override
    public void fightBack() {

    }
}