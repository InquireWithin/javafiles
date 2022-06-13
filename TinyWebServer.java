
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TinyWebServer {
    private ServerSocket s;
    private Socket client;
    private TinyWebServer(ServerSocket s){
        this.s=s;
    }
    public class handleClient implements Runnable{
        Socket sc;
        public handleClient(Socket sc) {
            this.sc=sc;
        }

        @Override
        public void run() {
            try {
                Scanner in = new Scanner(sc.getInputStream());
                String line = "";
                if(in.nextLine() != null){
                line = in.nextLine();
                }
                else{return;}
                while(line == in.nextLine()){
                    String toWrite = 
                    "HTTP/1.1 200 OK\r\n"
                    + "Content-Length: 12\r\n"
                    + "Content-Type: text/plain; charset=utf-8\r\n\r\n"
                    + "Hello World!\r\n";
                    sc.getOutputStream().write(toWrite.getBytes());
                    //!
                    break;
                    //!
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            

        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(8080);
        List<Thread> clients = new ArrayList<>();
        while(true){

        Socket client = s.accept();
        Thread t = new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    Scanner in = new Scanner(client.getInputStream());
                    String line = "";
                    if(in.nextLine() != null){
                    line = in.nextLine();
                    }
                    else{return;}
                    while(line == in.nextLine()){
                        String toWrite = 
                        "HTTP/1.1 200 OK\r\n"
                        + "Content-Length: 12\r\n"
                        + "Content-Type: text/plain; charset=utf-8\r\n\r\n"
                        + "Hello World!\r\n";
                        client.getOutputStream().write(toWrite.getBytes());
                        //!
                    
                        client.close();;
                        break;
                        //!
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
    
            }
            }
            
        );
        clients.add(t);
        t.start();
        
        

        /*Scanner in = new Scanner(client.getInputStream());
        String message = in.nextLine();
        System.out.println(message);
        if(in.nextLine()!=null){

        }*/
    }
        //PrintWriter pw = new PrintWriter(client.getOutputStream());
        //pw.println(message);
        //pw.flush();
    }
}
