package bridgecrossing 


/**
 * Class outlining all the details and actions of an individual Woolie.
 * To see them crossing the bridge:
 * @see Bridge
 * 
 */
public class Woolie implements Runnable{
        private Thread thread;
        private String name;
        private int crossingTime;
        private String destination;
        private Bridge bridge;
        public Woolie (String name, int crossingTime, String destination, Bridge bridge){
        this.name = name    ;
        this.crossingTime = crossingTime;
        this.destination = destination;
        this.bridge=bridge;bridge.enterBridge(this);
        thread = new Thread(new Runnable() {
            @Override
            public void run(){
                //!Print bridge crossing has started in Bridge.java
            System.out.println(name + " has started to cross.");
            //crossing in progress
            for (int i = 0; i <crossingTime ;i++) {
                if(i==0){System.out.println("Time is 0.");}
                else {
                    try {
                        Thread.sleep(1000);
                        System.out.println("\t"+name +" " + i +" Seconds");
                    }
                    catch (InterruptedException ie) {}
                
                }
            }
                //they exit the bridge when the loop breaks
    System.out.println(name + " leaves at "+destination);
        }
    });
        }
public Thread getThread() {
    return thread;
}
public int getCrossingTime() {
    return crossingTime;
}
public String getDestination() {
    return destination;
}
public String getName() {
    return name;
}
@Override
public void run () {
    if(bridge.getOnBridge()){thread.interrupt();}
System.out.println(name + " has started crossing the bridge.");

//crossing in progress
for (int i = 0; i <this.crossingTime ;i++) {
    if(i==0){System.out.println("Time is 0.");}
    else {

    try {
        Thread.sleep(1000);
        System.out.println("\t"+name +" " + i +" Seconds");
    }
    catch (InterruptedException ie) {System.out.println("Thread interrupt thrown due to max bridge capacity.");;}
        
}
}
    //they exit the bridge when the loop breaks
    try{
    Thread.sleep(1000);}catch(InterruptedException newintex){};
    System.out.println(this.name + " leaves at "+this.destination);

    }
}
    


