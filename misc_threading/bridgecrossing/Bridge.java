package bridgecrossing;


import java.util.ArrayList;
import java.util.List;
public class Bridge {
    private boolean onBridge = false; //checks for a woolie on the bridge
    private List<Woolie> woolieList;
    public Bridge() {woolieList = new ArrayList<>();}
public List<Woolie> getWoolieList() {
    return woolieList;
}
public void setOnBridge(boolean onBridge) {
    this.onBridge = onBridge;
}
public boolean getOnBridge(){return onBridge;}
public void enterBridge(Woolie w){woolieList.add(w);}
public void leaveBridge(Woolie w){onBridge = false;woolieList.remove(w);}
public void begin(){
    System.out.println("Bridge crossing is starting...");
    for(Woolie w:woolieList){w.run();;;}
}
public static void main(String[] args) {
    Bridge bridge = new Bridge();
    Woolie falco = new Woolie ("Falco", 4, "Merctran",bridge);
Woolie marly = new Woolie ("Marly", 3, "Sicstine",bridge);
Woolie deirdre = new Woolie ("Deirdre", 5,   "Merctran",bridge);
//bridge.enterBridge(falco);bridge.enterBridge(marly);bridge.enterBridge(deirdre);
bridge.begin();

}
}
