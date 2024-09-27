import java.io.*;
import java.net.*;

public class A17_Server2 {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5152);  // Server listens on port 5152
        System.out.println("Server Started...");

        Socket s = ss.accept();  // Server accepts a connection from the client

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        String cnm = dis.readUTF();     // Reads client name
        String str = "Welcome " + cnm;
        dos.writeUTF(str);

        // Thread to send messages to the client
        while (true) {
            str = dis.readUTF();  // Reads message sent by client
            System.err.println("From " + cnm + " : " + str);

            if (str.equals("Bye"))  // Check for 'Bye' to terminate the loop
                break;

            System.out.println("Message to " + cnm);
            str = br.readLine();

            dos.writeUTF(str);
            if (str.equals("Bye"))  // Check for 'Bye' to terminate the loop
                break;
        }

        dos.close();
        dis.close();
        s.close();
    }
}
