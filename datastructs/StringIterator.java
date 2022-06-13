package inner;

import java.lang.String;
import java.util.Iterator;
public class StringIterator implements Iterator<Character>{
    private String string;
    private int index;
    public StringIterator(String string) {
        this.string = string;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < string.length();
    }


    @Override
    public Character next() {
        Character ch = string.charAt(index);
        index++;
        return ch;
    }
    public static Iterable<Character> iterableString(String string) {
        return new Iterable<Character>(){
            public Iterator<Character> iterator() {
                return new StringIterator(string);
            }
        };
    }
    public static void main(String[] args) {
        for(char ch: iterableString("Hello SWEC")){
            System.out.println(ch);
        }
    }
}

