public class Ques3 {

    static class MyThread extends Thread {

        public void run() {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Processing...");
                    Thread.sleep(1000); 
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        MyThread th = new MyThread();
        th.start();
    }
}