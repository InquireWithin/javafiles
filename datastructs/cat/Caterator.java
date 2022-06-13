package cat; 

import java.util.Iterator;
import java.util.List;

public class Caterator<E> implements Iterator<E> {
    private List <E> list;
    private Integer index;
    public Caterator(List<E> list){this.list = list;index=0;}
    @Override
    public boolean hasNext() {
       return index < list.size();
    }

    @Override
    public E next() {
       E value = list.get(index);index++;
       return value;
    }
    
}
