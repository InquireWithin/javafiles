package concurrency;

public class CountThread extends Thread {
    String name;
    public CountThread(String name){this.name = name;}
    @Override
    public void run() {
        for(int i=1;i<101;i++){System.out.println("Counter "+name+":"+i);}
        System.out.println("Counter "+name+"done!");
    }
    public static void main(String[] args) throws InterruptedException{
        Thread counter = new CountThread("1");
        counter.start();
        int i =0;
        while(counter.isAlive()){sleep(50);        }
        for(char ch = 'A';ch<='Z';ch++){
            System.out.println(ch + " ");
        }
        System.out.println();
        //System.out.println("Checked alive "+i+" times");
    }
}
