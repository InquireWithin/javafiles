package evensodds;

import java.util.Scanner;

public class SequentialCount {
    public static void main(String[] args) throws InterruptedException {
        Scanner n = new Scanner(System.in);
        

        System.out.println("Enter positive n value: ");
        
        String s = n.nextLine();
        Integer a = Integer.valueOf(s);
        System.out.println();System.out.println();
        Thread[] ta = new Thread[a +1];
        for(int i =0;i<=a;i++){
            final int c = i+1;
            Thread t = new Thread(()->System.out.println(c));
            ta[i]=t;
        }
        for(int d =0;d<ta.length-1;d++){
            ta[d].start();
            ta[d].join();
        }
        //for(int e=0;e<ta.length;e++){ta[e].start();}
    }
}
