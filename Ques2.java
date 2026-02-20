

class Ques2{
    static class MyThread extends Thread {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    }

}
    public static void main(String[] args) throws Exception {
        System.out.println("Main thread started");
        MyThread t = new MyThread();
        t.start();

        t.join(); 

        System.out.println("Main thread finished");
    }
}