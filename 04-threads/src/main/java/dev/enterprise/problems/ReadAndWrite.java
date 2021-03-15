package dev.enterprise.problems;

public class ReadAndWrite {

    Object keyReadX = new Object();
    Object keyReadY = new Object();
    Object keyWriteX = new Object();
    Object keyWriteY = new Object();


    int x = 5;
    int y = 0;

    public void setX(int x) {
        synchronized (keyWriteX) {
            this.x = x;
        }
    }

    public int getX() {
        synchronized (keyReadX) {
            return x;
        }
    }

    public int getY() {
        synchronized (keyReadY) {
            return y;
        }
    }

    public void setY(int y) {
        synchronized (keyWriteY) {
            this.y = y;
        }
    }
}
