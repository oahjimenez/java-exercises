package producer.consumer.exercise;

public class Main {

    public static void main(String[] args) {

        System.out.println("Main: Single producer/consumer program. Configuring producer and consumer.");

        Monitor monitor = new Monitor();
        Consumer consumer = new Consumer(monitor);
        Producer producer = new Producer(monitor);

        System.out.println("Main: running producer and consumer.");

        try {
            Thread consumerThread = new Thread(consumer);
            Thread producerThread = new Thread(producer);
            consumerThread.start();
            producerThread.start();
            consumerThread.join();
            producerThread.join();
            while (true) {
                Thread.sleep(3000);
                System.out.println("Main: busy waiting");
            }
        } catch (Exception e) {
            System.out.println("Main exception : " + e.getMessage());
        }
        System.out.println("Main: end or program");

    }
}
