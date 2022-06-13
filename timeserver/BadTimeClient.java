package timeserver;
import jdk.net.Sockets;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class BadTimeClient {
    public BadTimeClient() throws UnknownHostException, IOException {
    String cmd = "literallyanythingbuttime"
    ;
            Socket server = new Socket(InetAddress.getLocalHost(),13000);
            PrintWriter out = new PrintWriter(server.getOutputStream());
            out.println(cmd);out.flush();
            Scanner console = new Scanner(System.in);
            //print server's response
            Scanner in = new Scanner(server.getInputStream());
            String response = in.nextLine();
            System.out.println(response);
            
        }
    
        
    
    public static void main(String[] args) {
        try {
            new BadTimeClient();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
