package concurrency;



public class Countdown implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        /*for(int i=10;i>0;i--){
            System.out.println("T-"+i);Thread.sleep(1000);
        }
        System.out.println("Liftoff.");*/
    }

    @Override
    public void run() {
        int count = -10;
        for(;;){
            if(count<0){System.out.println("T"+count);}
        else if(count==0){System.out.println("Completed.");}
        else{System.out.println(count);
            
        }try{Thread.sleep(1000);}
        catch(InterruptedException ie){System.out.println("yeet");}
        count++;
    }
    
}   
}
