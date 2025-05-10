package producer.consumer.exercise;

public class Consumer implements Runnable {

    private Monitor monitor;

    public Consumer(Monitor monitor) {
        this.monitor = monitor;
    }

    private synchronized void consume() throws InterruptedException {
        while (true) {
            this.monitor.read();
        }
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            System.out.println("Consumer exception : " + e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
