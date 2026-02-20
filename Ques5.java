class Ques5{
    static class Printer{
     boolean even = true;
   synchronized void printNotPrime(){
      try{
        while(!even){
            wait();
        }
        System.out.println(Thread.currentThread().getName() + ":" + "Not Prime");
        even = false;
        notify();
     }catch(Exception e){
        
     }
   }

     synchronized void printPrime(){
      try{
        while(even){
            wait();
        }
        System.out.println(Thread.currentThread().getName() + ":" + "Prime");
        even = true;
        notify();
     }catch(Exception e){
        
     }
   }
      
    }

    static class NonPrimeThread extends Thread{
        private Printer p ;

        public NonPrimeThread(Printer p) {
            this.p = p;
        }
        public void run(){
             for(int i=2; i<=100; i+=2){
            boolean flag = true;
            int n = i;
             for (int j = 2; j * j <= n; j++) {
             if (n % j == 0) {
                flag = false;
                break;
             }
        }
          flag =  true;
          if(flag){
            p.printNotPrime();
          }
        }
        }
        
    }

     static class PrimeThread extends Thread{
        private  Printer p;

        public PrimeThread(Printer p) {
            this.p = p;
        }

        public void run(){
             for(int i=1; i<=100; i+=2){
            boolean flag = true;
            int n = i;
             for (int j = 2; j * j <= n; j++) {
             if (n % j == 0) {
                flag = false;
                break;
             }
        }
          flag =  true;
          if(flag){
            p.printPrime();
          }
        }
        }
    }

    public static void main(String[] args) {
        Printer p = new Printer();
        NonPrimeThread even = new NonPrimeThread(p);
        PrimeThread odd = new PrimeThread(p);
        even.setName(("Thread1"));
        odd.setName(("Thread2"));
        even.start();
        odd.start();

    }
}