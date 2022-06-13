package cat;

import java.util.Collections;

public class Cat implements Comparable<Cat>{
    private String name;private String furColor;private int evil;
    public Cat(String name, String furColor, int evil){
        this.name=name;this.furColor = furColor;this.evil=evil;
    }
    @Override
    public int compareTo(Cat o) {
        return name.compareTo(o.name);
    }
    public static void main(String[] args) {
        List    <Cat> myCats;
        Collections.sort(myCats);
    }
}
