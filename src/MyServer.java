
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.File;

public class MyServer {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    /*PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());*/
                	
                	DataInputStream dIn = new DataInputStream(socket.getInputStream());
                	int length = dIn.readInt();                    // read length of incoming message
                	if(length>0) {
                	    byte[] msg = new byte[length];
                	    dIn.readFully(msg, 0, msg.length); // read the message
                	   
                	    String str = new String(msg);
                	    System.out.println(str);
                	}
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
}