package concurrency;

public class CountRunnable implements Runnable {
    String name;
    public CountRunnable(String name){this.name =name;}
        @Override
        public void run() {
            for(int i=1;i<101;i++){System.out.println("Counter "+name+":"+i);}
            System.out.println("Counter "+name+" done!");
        }
        public static void main(String[] args) {
            Runnable counter = new CountThread("1");
            Thread counterThread = new Thread(counter);
            while(counterThread.isAlive()){
            }
            for(char ch = 'A';ch<='Z';ch++){
                System.out.println(ch + " ");
            }
            System.out.println();
        }
    }
    
    

