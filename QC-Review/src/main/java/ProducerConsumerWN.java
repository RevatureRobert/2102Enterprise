import java.util.LinkedList;

public class ProducerConsumerWN {
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 10;


    public void produce() throws InterruptedException{
        int value = 0;
        while(true){
            synchronized (this){
                while(list.size() == capacity)
                    wait();

                System.out.println("Producer produced-" + list.size());

                list.add(list.size());

                notify();

                Thread.sleep(100); // makes the program easier to understand
            }
        }
    }

    public void consume() throws InterruptedException{
        while(true){
            synchronized (this){
                while(list.size() == 0)
                    wait();

                int val = list.removeFirst();

                System.out.println("Consumer consumed-" + list.size());

                notify();

                Thread.sleep(100); // makes the program easier to understand
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerWN pc = new ProducerConsumerWN();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run(){
                try{
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run(){
                try{
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
