package set;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.HashSet;
public class ListSet<E> implements Set<E>{
    private int size;;
    private List<E> list = new ArrayList<>();
    /*private AbstractSet set = new AbstractSet<E>(){
        private int size;
        @Override
        public Iterator<E> iterator() {
            return new Seterator<E>((Set<E>) this);
        }

        @Override
        public int size() {
            return size;
        }
        
    };*/
    
    private HashSet<E> set = new HashSet<E>();
    public ListSet(){
        super();
    }
    @Override
    public Iterator<E> iterator() {
        return new Seterator<E>(set);
    }

    @Override
    public void add(E e) {
        if(set.contains(e)){}
        else{
        this.set.add(e);
        System.out.println("Added a value, new set: ");
        System.out.println(this.toString());
        size+=1;
        }
    }

    @Override
    public void remove(E e) {
        this.set.remove(e);
        System.out.println("value removed, new set: ");
        System.out.println(toString());
    }

    @Override
    public boolean contains(E e) {
        return this.set.contains(e);
    }

    @Override
    public int size() {
        return this.size;
    }
    @Override
    public String toString() {
        String s = "<";
        for(E value: set){
            s+=(value +" ");
        }
        return s +=">";
    }
}
