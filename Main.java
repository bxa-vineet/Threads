import java.util.*;
import java.util.concurrent.*;

class Main {

    static BlockingQueue<Example> queue = new LinkedBlockingQueue<>(5);

    static Map<String, List<String>> map = new TreeMap<>();

    static final int LIMIT = 5;

    public static void main(String[] args) {

        new Producer().start();
        new Consumer().start();
    }
}


class Producer extends Thread {

    Random random = new Random();

    public void run() {
        for (int i = 0; i < Main.LIMIT; i++) {
            try {
                String id = "EMP-" + (random.nextInt(3) + 1);
                String uuid = UUID.randomUUID().toString();

                Example emp = new Example(id, uuid);

                Main.queue.put(emp); // waits if full
                System.out.println("Produced: " + emp);

                Thread.sleep(500);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


class Consumer extends Thread {

    public void run() {
        for (int i = 0; i < Main.LIMIT; i++) {
            try {
                Example emp = Main.queue.take();

                synchronized (Main.map) {
                    Main.map
                            .computeIfAbsent(emp.id, k -> new ArrayList<>())
                            .add(emp.uniqueId);
                }

                System.out.println("Consumed: " + emp);
                System.out.println("Map: " + Main.map);

                Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


class Example {
    String uniqueId;
    String id;

    public Example(String id, String uniqueId) {
        this.id = id;
        this.uniqueId = uniqueId;
    }

    public String toString() {
        return "Example{id='" + id + "', uuid='" + uniqueId + "'}";
    }
}