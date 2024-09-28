import java.net.*;

import javax.imageio.stream.FileImageInputStream;

import java.io.*;

public class A18_Server3{
    public static void main(String [] args) throws Exception
    {
       ServerSocket ss = new ServerSocket(8081);   //---- port no 1
       System.out.println("......Server Started.....");
       Socket s = ss.accept();

       DataInputStream dis = new DataInputStream(s.getInputStream());
       DataOutputStream dos = new DataOutputStream(s.getOutputStream());
 
       String source = dis.readUTF();         // reads source file name sent by client
       boolean result = (new File (source)).exists();
       
       dos.writeBoolean(result);        // sends true if file found else false

       if(result==false)
       {
            dos.close();
            dis.close();
            s.close();
            return;
       }
       
       FileInputStream fis= new FileInputStream(source);
       int val =(byte)0;
       while(true)
       {
            val=fis.read();
            if(val==-1)
                break;
            dos.write(val);    
       }
       fis.close();
       dos.close();
       dis.close();
       s.close();
 
    }
     
 }