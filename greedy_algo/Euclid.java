package greedy_algo;

public class Euclid {
    public static int algorithm(int a, int b) {
        //finding greatest common denom
        while(a != b) {
            if(a>b) {
                a = a-b;
            }
            else{
                b = b-a;
            }
        }
        return a;
    }
}
