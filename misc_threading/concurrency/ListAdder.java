package concurrency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListAdder implements Runnable{
    List<Integer> sharedList;
    int num;
    public ListAdder(List<Integer> sharedList,int num){
        this.num = num;
        this.sharedList = sharedList;

    }
    @Override
    public void run() {
        for(int i =0;i<num;i++){sharedList.add(i);}
        
    }
    public static void main(String[] args) {
        List<Integer> sharedList = new ArrayList<>();
        int num_threads = 100;
        Thread[] threads = new Thread[num_threads];
        for(int i=0;i<num_threads;i++){
          
        
         threads[i] =new Thread(new ListAdder(sharedList, 50));
            threads[i].start();
        }
        for(int i=0;i<num_threads;i++){try{threads[i].join();}catch(InterruptedException ie){}}
        System.out.println(sharedList);System.out.println("List has "+sharedList.size()+" entries.");
    }
}
