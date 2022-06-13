package misc_threading;
import java.util.ArrayList;
import java.util.List;

public class Incrementor implements Runnable{
    private static int count;

    public Incrementor(){count = 0;}

    public synchronized static void increment() {
        count+=1;
    }
    public synchronized static int getCount() {
        return count;
    }
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for(int a=0;a<10;a++){
            new Thread(new Runnable(){
                    @Override
                    public void run() {
                        for(int count =0;count<100000;count++){
                            Incrementor.increment();
                        }
                    }
            }).start();
        }
        System.out.println(count);
    }
    @Override
    public void run() {
        for(int i =0;i<100000;i++){
            count+=1;
        }
        
    }
}
