package inner;
import java.lang.Iterable;
import java.util.Iterator;

public class IterableString implements Iterable<Character> {
    
    @Override
    public Iterator<Character> iterator() {
        return new StringIterator(this);
    }
}
