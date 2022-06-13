package cat;
import java.util.Comparator;

public class CatComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.furColor.equals(o2.furColor)){
            return o2.evil - o1.evil;
        }
        else{
            return o1.furColor.compareTo(o2.furColor);
        }
    }
    
}
