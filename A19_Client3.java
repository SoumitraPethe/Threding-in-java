import java.net.*;
import java.io.*;

public class A19_Client3 {
    public static void main(String [] args) throws Exception
    {
       Socket s = new Socket("Localhost",8081);   //---- port no 1
       
       DataInputStream dis = new DataInputStream(s.getInputStream());
       DataOutputStream dos = new DataOutputStream(s.getOutputStream());

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter Source File Name:");
    
        String source = br.readLine();
        dos.writeUTF(source);        // sends file name to server
        boolean result = dis.readBoolean();
        if(result == false)
            System.out.println("Invalid File name.....");
        
        else{
            System.out.println("Enter Destination file name");
            String destination = br.readLine();
            int val=0;
            FileOutputStream fos = new FileOutputStream(destination);
        
            while(true)
            {
                val = dis.read();
                if(val==-1)      // due to end of file
                    break;
                
                fos.write(val);    
            }
            fos.close();

        }
        dis.close();
        dos.close();
        s.close();
    }
}
