class Ques4{
    static class Printer{
     boolean even = true;
   synchronized void printEven(){
      try{
        while(!even){
            wait();
        }
        System.out.println(Thread.currentThread().getName() + ":" + "even");
        even = false;
        notify();
     }catch(Exception e){
        
     }
   }

     synchronized void printOdd(){
      try{
        while(even){
            wait();
        }
        System.out.println(Thread.currentThread().getName() + ":" + "odd");
        even = true;
        notify();
     }catch(Exception e){
        
     }
   }
      
    }

    static class EvenThread extends Thread{
        private Printer p ;

        public EvenThread(Printer p) {
            this.p = p;
        }
        public void run(){
            for(int i=2; i<=100; i=i+2){
                p.printEven();
            }
        }
        
    }
     static class OddThread extends Thread{
        private  Printer p;

        public OddThread(Printer p) {
            this.p = p;
        }
        public void run(){
            for(int i=1; i<=100; i=i+2){
                p.printOdd();
            }
        }
        
    }
    public static void main(String[] args) {
        Printer p = new Printer();
        EvenThread even = new EvenThread(p);
        OddThread odd = new OddThread(p);
        even.setName(("Thread1"));
        odd.setName(("Thread2"));
        even.start();
        odd.start();

    }
}