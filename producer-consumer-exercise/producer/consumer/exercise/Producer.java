package producer.consumer.exercise;


public class Producer implements Runnable {

    private Monitor monitor;

    public Producer(Monitor monitor) {
        this.monitor = monitor;
    }

    private synchronized void produce() throws InterruptedException {
        while (true) {
            this.monitor.write(Math.random());
        }
    }

    @Override
    public void run() {
        try {
            produce();
        } catch (InterruptedException e) {
            System.out.println("Producer exception : " + e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
    
}
