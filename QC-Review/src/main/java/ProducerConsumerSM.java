import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ProducerConsumerSM {

    public static Semaphore produce = new Semaphore(5);
    public static Semaphore consume = new Semaphore(0);

    List<Integer> stuff = new ArrayList<>();

    public void putItem() {
        try{
            produce.acquire();
            Thread.sleep(50);
            stuff.add(1);
            System.out.println("I added an item");

        } catch (InterruptedException e) {
            System.out.println("Exception in put item");
        }

        consume.release();
    }
    public int getItem(){
        try {
            consume.acquire();
            Thread.sleep(50);

        } catch (InterruptedException e) {
            System.out.println("Exception in get item");
        }

        produce.release();
        return this.stuff.remove(this.stuff.size() - 1);
    }

    public static void main(String[] args) {
        ProducerConsumerSM pc = new ProducerConsumerSM();
        new Producer(pc);
        new Consumer(pc);
    }
}

class Producer implements Runnable{
    ProducerConsumerSM pc;

    public Producer (ProducerConsumerSM pc){
        this.pc = pc;
        new Thread(this).start();
    }

    @Override
    public void run(){
        while (true){
            pc.putItem();
            System.out.println("producer produced");
        }
    }
}

class Consumer implements Runnable{
    ProducerConsumerSM pc;

    public Consumer (ProducerConsumerSM pc){
        this.pc = pc;
        new Thread(this).start();
    }

    @Override
    public void run(){
        while (true){
            System.out.println("Consumer got this -> " + pc.getItem());
        }
    }
}
