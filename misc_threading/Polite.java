package misc_threading;
public class Polite extends Thread{
    private String e;
    private  Object lock;
    public Polite(String e, Object lock){
        this.e=e;
        this.lock  = lock;
    }
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Polite polite = new Polite("oui?", lock);
        Polite polite2 = new Polite("what?", lock);
        polite.start();;polite2.start();
        Thread.sleep(10);
        synchronized(lock){
            lock.notify();
        }
        
    }

    @Override
    public void run() {
        for(int i =0;i<10;i++){
            synchronized(lock){
                try{lock.wait();}
                catch(InterruptedException ioe){}
            System.out.println(e);
                lock.notify();
            }
        }
        
    }
}
