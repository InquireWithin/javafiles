//make a deadlock
package misc_threading;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Deadlocker extends Thread{
    //private Queue<String> worker;
    private int count = 0;
    private static Queue<String> coworker;
    private static Queue<String> worker;
    public Deadlocker(Queue<String> worker, Queue<String> coworker){
        //worker = new LinkedList<>();
        //coworker = new LinkedList<>();
        this.worker = worker;
        this.coworker=coworker;
        
        Random r = new Random();
        worker.add("part" + r.nextInt(5));
    }
    private void coworker() {
        synchronized(coworker){
            synchronized(worker){
                if(coworker.size() > 0){
                    String item = coworker.remove();
                    worker.add(item);
                    count+=1;
                    System.out.println(count);
                }
            }
        }
    }
    private void worker() {
        synchronized(worker){
            synchronized(coworker){
                if(worker.size() > 0){
                    String item = worker.remove();
                    coworker.add(item);
                    count+=1;System.out.println(count);
                }
            }
        }
    }
    @Override
    public void run() {
        for(;;){
            worker();
            coworker();
        }
    }

    public static void main(String[] args) {
        //Thread t = new Thread(new Deadlocker());
        //t.start();;
    coworker = new LinkedList<>();
     worker = new LinkedList<>();
        
    new Deadlocker(worker, coworker).start();
    new Deadlocker(coworker, worker);
    }
}
