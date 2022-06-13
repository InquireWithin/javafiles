package misc_threading;
import java.lang.Thread;
public class Printer extends Thread{
    private String s;
    public Printer(String s){
        this.s=s;
    }
    @Override
    public void run() {
        for(int i = 0;i<s.length();i++){
            System.out.println(s.charAt(i));
        }
    }

    public static void main(String[] args) {
        Thread printer = new Printer("message");
        printer.start();;
    }
}
