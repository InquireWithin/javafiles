package duplexer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Duplexer {
    private Socket sock;
    private Scanner in;
    private PrintWriter out;
    
    public Duplexer (Socket socket)  throws IOException {
        sock = socket;
        in = new Scanner (socket.getInputStream ());
        out = new PrintWriter (socket.getOutputStream ());
    }

    public void close() throws IOException {
        sock.close ();
        out.close ();
        in.close ();
    }

    public void send (String message) {
        out.println (message);
        out.flush ();
    }

    public String read () {
        return in.nextLine ();
    }

}
