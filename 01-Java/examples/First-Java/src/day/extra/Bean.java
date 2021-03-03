package day.extra;

import java.io.Serializable;

/*
        Java Bean
            implement the Serializable interface
            private fields
             public getters and setters
             constructors (no and all arg)
 */
public class Bean implements Serializable {

    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public Bean(int i) {
        this.i = i;
    }

    public Bean() {
    }
}
