import java.io.*;
import java.net.*;
import java.util.Scanner;

public class A16_Client2 {
    public static void main(String[] args) throws Exception {


        if (args.length!=1)
        {
            System.out.println("Invalid argument");
            return ;
        }

        Socket s = new Socket("localhost", 5152); // Connect to server on port 2021

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dos.writeUTF(args[0]);   //sends client name to servwer 


        

        String str=dis.readUTF();   //reads response from server

        System.out.println("From Server "+str);

        // Thread to send messages to the server
        
        while(true) {
                
            System.out.println("Message to Server...");
            str=br.readLine();
            dos.writeUTF(str);        //sends message to server
            if(str.equals("Bye"))
                break;
            
            str=dis.readUTF();    //reads message send by server
            System.out.println("From Server" + str);
            
            if(str.equals("Bye "))
                break;

        }
                
        dis.close();
        dos.close();
        s.close();        
    }
}
