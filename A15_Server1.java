
//             Insert     extract
//       |-------------|------------|
//       |                          |
// //    * ------------------------  * 
// //  server                      client
// //     |            |               |
// //     |------------ ----------------|
// //          Extract        insert



import java.io.*;
import java.net.*;
public class A15_Server1{
   public static void main(String [] args) throws Exception
   {
      ServerSocket ss = new ServerSocket(2021);   //---- port no 1
      System.out.println("Server Started....");
      Socket s = ss.accept();
      DataInputStream dis = new DataInputStream(s.getInputStream());
      DataOutputStream dos = new DataOutputStream(s.getOutputStream());

      String str = dis.readUTF();  // reads message sent by client
      System.out.println("From Client:"+str);
      str="Welcomes U";
      dos.writeUTF(str);   //sends message to client
      dos.close();
      dis.close();
      s.close();

   }
    
}