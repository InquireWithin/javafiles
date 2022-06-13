package evensodds;

import static java.lang.Thread.sleep;

public class EvensAndOdds {
    public static void main(String[] args) throws InterruptedException {
        for(int i =1;i<101;i+=2){
            final int a = i;
            //thread to print out odds
        Thread t = new Thread(() ->System.out.println(a));
        //events thread
        Thread th =new Thread(()->System.out.println(a+1));
        t.start();
        sleep(1000);
        th.start();
        }
    }
}
