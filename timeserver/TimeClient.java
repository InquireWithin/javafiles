package timeserver; 

import java.io.IOException;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.Socket;
import java.io.PrintWriter;
public class TimeClient {
    public TimeClient() throws IOException {
        Scanner scan = new Scanner(System.in);
        //System.out.println("Enter command: ");
        //String cmd = scan.nextLine();
        String cmd = "time";
        //if(cmd.equalsIgnoreCase("time")){
            Socket server = new Socket(InetAddress.getLocalHost(), 13000);
            PrintWriter out = new PrintWriter(server.getOutputStream());
            out.println(cmd);out.flush();
            // Scanner console = new Scanner(System.in);
            // String message = console.nextLine();
            // while(!message.equals("")){
            // out.println(message);out.flush();
            // server.close();;
            //print server's response
            Scanner in = new Scanner(server.getInputStream());
            String response = in.nextLine();
            System.out.println(response);
            
            //message = console.nextLine();
            //console.close();;
            
        //}
    //}
        
        //else{
            //System.out.println("Did not understand request "+cmd);
        //}
        scan.close();
        
        
    }
    public static void main(String[] args) throws IOException {
        new TimeClient();
    }
}

