package timeserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Date;
import java.io.PrintWriter;
public class TimeServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(13000);
        
            //accept message from client
            
            Socket client  = server.accept();
            Scanner in = new Scanner(client.getInputStream());
            String message = in.nextLine();
            System.out.println(message);
            PrintWriter pw = new PrintWriter(client.getOutputStream());
            if(message.equalsIgnoreCase("time")){
            //send the time to the client
            long currentTimeMillis = System.currentTimeMillis();
            String timeString = new Date(currentTimeMillis).toString();
            pw.println(timeString);
            pw.flush();
            server.close();
            }
            //in.close();client.close();
            else{pw.println("request unknown: "+message );pw.flush();server.close();}
        }
    }


