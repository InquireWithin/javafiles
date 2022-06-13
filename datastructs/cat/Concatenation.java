package cat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Concatenation<E> implements Concatenator<E>, Iterable<E>{
    private List<E> list;
    public Concatenation(){
        list = new ArrayList<>();
    }
    @Override
    public void add(E e) {
        list.add(e);
    }

    @Override
    public void remove(E e) {
        list.remove(e);
        
    }

    @Override
    public String concat() {
        String result = "";
        for(E value:list){
            result += value;
        }
        return result;
    }
    @Override
    public Iterator<E> iterator() {
        return new Caterator<>(list);
    }
    public static void main(String[] args) {
        Concatenation<Integer> cat = new Concatenation<>();
        cat.add(1);cat.add(2);
        cat.add(3);
        for(Integer value:cat){System.out.println(value);}
    }
    
}
