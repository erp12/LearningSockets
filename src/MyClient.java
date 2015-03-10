import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

/**
 * Trivial client for the date server.
 */
public class MyClient {

    public static void main(String[] args) throws IOException {
    	String clientName = "Client Test 1";
        String serverAddress = ""; // Address of server here!
        byte[] msg = clientName.getBytes();
        Socket s = new Socket(serverAddress, 9090);
        
        DataOutputStream dOut = new DataOutputStream(s.getOutputStream());

        dOut.writeInt(msg.length); // write length of the message
        dOut.write(msg);           // write the message
        
        System.exit(0);
    }
}