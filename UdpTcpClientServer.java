/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package udptcpclientserver;
import java.io.*;
import java.util.Date;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class UdpTcpClientServer {
        // String portNum = "55555";
    /**
     * @param args the command line arguments
     */
    static final String endMessage = ".";
    public static void main(String[] args) {
        // TODO code application logic here        
        UserInterface form = new UserInterface();
        form.setVisible(false);
        
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        try{
         System.out.println("welcome to the Echo client.\n" + "what is the name of the server host?");
         String hostName = br.readLine();
         if (hostName.length() == 0)
             hostName = "172.30.129.107";
         System.out.println("Enter the port number of the server host.");
         String portNum = br.readLine();
         if (portNum.length() == 0)
             portNum = "23456";
         EchoClientHelper1 helper = new EchoClientHelper1(hostName, portNum);
         boolean done = false;
         String message, echo="";
         while(!done){
             System.out.println("Enter a line to receive an echo back from the server, " + "or a single dot to quit.");
             message = br.readLine();
             byte[] base64Byte = null;
       
     
             base64Byte = Base64.encodeBase64(message.getBytes("utf-8"));
             message = new String(base64Byte);
             //message = DigestUtils.md5Hex(message);
             System.out.println( message);
             //byte[] base64ByteBack =null;
             //String base64StrBack = "";         
            //base64ByteBack = Base64.decodeBase64(message.getBytes("utf-8"));
            //base64StrBack = new String(base64ByteBack);
            //System.out.print(base64StrBack);             
             if ((message.trim()).equals (endMessage)){
                 done = true;
                 //helper.done();
             }
             else if(message.trim().equals("done")){
                done = true;
                echo = helper.getEcho(message);
                System.out.println(echo);
         }
             else{
                 echo = helper.getEcho(message);
       
                byte[] base64ByteBack =null;
                String base64StrBack = "";         
                 base64ByteBack = Base64.decodeBase64(echo.getBytes("utf-8"));
                 base64StrBack = new String(base64ByteBack);
                 System.out.println(base64StrBack);
             }
             // 'Unpack' the message into character string and print it out to verify for correctness and close the socket //
              String mpackage = echo;

              String[] info = new String[5];
              info = mpackage.split(" ");
              //info array store the target infomation
              
           //  TCP--------------------------------------------------
           /*
               while(!done){ 
                      
        try {
            UserInterface.TrackerName = info[0];
            UserInterface.IpAddress = info[1].substring(1);
            System.out.println("Welcome to the Echo client.\n" + "What is the name of the server host?");
            String hostName2 = br.readLine();
            if(hostName2.length() == 0)//if user did not enter a name
                hostName2 = info[1].substring(1);// use the default host name
            System.out.println("what is the port number of the server host?");
            String portNum2 = br.readLine();
            if(portNum2.length() == 0)
                portNum2 = info[2];//default port number
            EchoClientHelper2 helper2 = new EchoClientHelper2(hostName2, portNum2);
            //boolean done2 = false;
            String message2, echo2;
            while(!done){
                System.out.println("Enter a line to receive an echo back from the server," + "or a single period to quit.");
                message2 = UserInterface.input;
                System.out.println(message2);
                if((message2.trim()).equals(".")){
                    done = true;
                    helper2.done();
                }
                else{
                    echo2 = helper2.getEcho(message2);
                    UserInterface.output = echo2;
                    System.out.println(echo2);                    
                }
                Thread.sleep(2000);
            }//end while
        }//end try
        catch(Exception ex){
            ex.printStackTrace();
        }
                    }//end while
               */
             
         }//end check SERVER
         System.out.println("Thank you for using the system, Bye!");
         
        }// end try1
        catch(Exception ex){
            ex.printStackTrace( );
        }
    }// end main
}
