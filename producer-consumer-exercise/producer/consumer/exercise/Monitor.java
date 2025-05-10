package producer.consumer.exercise;

public class Monitor {

    private Double value = null;


    public Monitor() {

    }

    public synchronized void write(Double value) throws InterruptedException {
        if (this.value != null) {
            System.out.println(" ==============> Monitor: value is not null and has value" + value + ", waiting consumer to read");
            this.wait();
        }
        Thread.sleep(8000); // wait 3 seconds
        this.value = value;
        System.out.println(" ==============> Monitor: generated value: "+ this.value + ", notifying consumer to read");
        this.notify();
    }

    public synchronized void read() throws InterruptedException {
        if (value == null) {
            System.out.println(" <====== Monitor: value is null , waiting producer to write");
            this.wait();
        }
        System.out.println(" <====== Monitor: read value: "+ value + ", notifying producer to write");
        Thread.sleep(3000); // wait 3 seconds
        value = null;
        this.notify();
    }
}
