
import java.rmi.server.Operation;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public interface Operation{
        double execute(double left, double right);
    }
    public static Operation getOperation(String operator){
        if(operator.equals("+")){
            return new Operation(){

                @Override
                public double execute(double left, double right) {
                    return left+right;
                }
            };}
        else if(operator.equals("-")){
            return (left,right) -> left-right;}
        else if(operator.equals("*")){
            return (left,right) -> left*right;}
        else if(operator.equals("/")){
            return (left,right) -> left/right;}
        else if(operator.equals("^")){
                return (left,right) -> Math.pow(left,right)/*or return Math::pow*/;}
        //Operation subt= left,right -> Operation.execute(left,right);
            //Calculator.Operation::execute(left,right);
        throw new UnsupportedOperationException(operator + " is not supported.");
            

        }
        
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Double left = 0.0; double right=0.0; String op="";
        System.out.println("Welcome to calculator thingy");
        while(true) {
            try{left = s.nextDouble();op=s.next();right=s.nextDouble();
            Operation math = getOperation(op);
            System.out.println(String.format("%d %s %d = %d", left, op, right, math.execute(left, right)));
        }
        catch(InputMismatchException ime) {break;}
    }
        System.out.println("Ending calculator process.");
        //System.out.println("enter a double like so: <double> <operator> <double> ");
        
        

        /*
                   if(op.equals("+")){Operation plus = new Operation(){
                @Override
                public double execute(double left, double right) {return left+right;}};}}*/
                //catch(InputMismatchException ime) {break;}
            
           
        
    }
}
