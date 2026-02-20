class MyThread implements Runnable {

    private String msg;

    MyThread(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread("Hello"));
        Thread t2 = new Thread(new MyThread("World"));

        t1.start();
        t2.start();
    }
}