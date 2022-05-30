package set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class Seterator<E> implements Iterator<E>{
    private HashSet<E> set;
    private Integer index;
    public Seterator(HashSet<E> set) {
        this.set = set;
        index = 0;
    }
    @Override
    public boolean hasNext() {
       return index<set.size();
    }

    @Override
    public E next() {
        
        List<E> values = new ArrayList<>();
        
        //Spliterator<E> s = new Spliterator<E>(){
            
        //};
        set.iterator().forEachRemaining((E e)->values.add(e));
        System.out.println("next value: "+ values.get(0));
        return values.get(0);
        
    }
    
}
