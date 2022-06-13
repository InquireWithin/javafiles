package concurrency;



public class AnonymousCounters extends Thread{
    static void counter(String name) {
        for(int i =0;i<101;i++){
            System.out.println(name + " "+i);
        }
    }
        public static void main(String[] args) {
            Thread a = new Thread(()->counter("Counter 1"));
            a.start();
            //a.run();

            
        }

    }

