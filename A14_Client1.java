
import java.io.*;
import java.net.*;
public class A14_Client1{
   public static void main(String [] args) throws Exception
   {

      Socket s = new Socket("localhost",2021);
     
      DataInputStream dis = new DataInputStream(s.getInputStream());
      DataOutputStream dos = new DataOutputStream(s.getOutputStream());

      dos.writeUTF("Helloo");    //sends message to server

      String str = dis.readUTF();  // reads message sent by server

      System.out.println("From server:"+str);
      
      dos.close();
      dis.close();
      s.close();
      
   }
}
