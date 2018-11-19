/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package udptcpserver1;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPTCPRouter1 {
     InetAddress ipmap[];
      String port[];
      String name[];
      
      String portNum = "23456";
      String portNum2 = "23457";
        public UDPTCPRouter1() 
      {
         try 
         {
            //Routing table
            ipmap = new InetAddress [5];
            port = new String [5];
            name = new String [5];
            ipmap[0] = InetAddress.getByName("192.168.1.111");
            port[0] = "35000";
            name[0] = "CLIENT1";
            ipmap[1] = InetAddress.getByName("192.168.1.118");
            port[1] = "65432";
            name[1] = "CLIENT2";
            ipmap[2] = InetAddress.getByName("192.168.1.118");
            port[2] = "65433";
            name[2] = "CLIENT3";
         }
             catch(Exception e){} 
            
            // TODO Auto-generated catch block
         }      
             public void receiveAndsendData() throws Exception 
      {   
          
          int serverPort = Integer.parseInt(portNum);
          int serverPort2 = Integer.parseInt(portNum2);
                  //Integer.parseInt(port[0]);
       
        try{
            boolean done = false;
            while(!done)
            {
                MyServerDatagramSocket mySocket = new MyServerDatagramSocket(serverPort);
                System.out.println("Connection ready.");
            
                //MyServerDatagramSocket mySocket2 = new MyServerDatagramSocket(Integer.parseInt(port[1]));           
                //System.out.print(mySocket2.isConnected());
                
                //System.out.println(mySocket.isConnected());
                //if(mySocket.isConnected()==true)
                //{
                        DatagramMessage request = mySocket.receiveMessageAndSender();
                        System.out.println("Request received");
                        String message = request.getMessage();
                        String a = "";
                        //port[0] = a + request.getPort();
                        System.out.println("message received: " + message);
            //-----------------------------------------------------
             //send to router2  

                System.out.println(mySocket.isConnected());
                if(mySocket.isConnected()==true)
                {            

                        mySocket.sendMessage(ipmap[1], Integer.parseInt(port[1]), message);
                        //receive from router2
                        //MyServerDatagramSocket mySocket2 = new MyServerDatagramSocket(serverPort2);
                        System.out.println("Echo server ready.");
            
                        DatagramMessage request2 = mySocket.receiveMessageAndSender();
                        System.out.println("Request received");
                        String message2 = request2.getMessage();
                        System.out.println("message received: " + message2);
            
                        mySocket.sendMessage(ipmap[0], Integer.parseInt(port[0]), message2);
            
                        if(message2.trim().equals("done"))
                        {
                            done = true;
                        }
                            mySocket.close();
                    }
                else
                {       
                       // System.out.println("chang router" );
                       // DatagramMessage request = mySocket.receiveMessageAndSender();
                        //System.out.println("Request received");
                        //String message = request.getMessage();
                        //String a = "";
                        //port[0] = a + request.getPort();
                        //System.out.println("message received: " + message);
            //-----------------------------------------------------
             //send to router2  
            
                        
                        mySocket.sendMessage(ipmap[2], Integer.parseInt(port[2]), message);
                        //receive from router2
                        //MyServerDatagramSocket mySocket2 = new MyServerDatagramSocket(serverPort2);
                        System.out.println("Echo server ready.");
            
                        DatagramMessage request2 = mySocket.receiveMessageAndSender();
                        System.out.println("Request received");
                        String message2 = request2.getMessage();
                        System.out.println("message received: " + message2);
            
                        mySocket.sendMessage(ipmap[0], Integer.parseInt(port[0]), message2);
            
                        if(message2.trim().equals("done"))
                        {
                            done = true;
                        }
            
                         mySocket.close();   
                }
                    //mySocket.close();
            }
        }
        catch(Exception ex){
             boolean done = false;
            while(!done)
            {
                MyServerDatagramSocket mySocket = new MyServerDatagramSocket(serverPort);
                System.out.println("Connection ready.");
            
                //MyServerDatagramSocket mySocket2 = new MyServerDatagramSocket(Integer.parseInt(port[1]));           
                //System.out.print(mySocket2.isConnected());
                
                //System.out.println(mySocket.isConnected());
                //if(mySocket.isConnected()==true)
                //{
                        DatagramMessage request = mySocket.receiveMessageAndSender();
                        System.out.println("Request received");
                        String message = request.getMessage();
                        String a = "";
                        //port[0] = a + request.getPort();
                        System.out.println("message received: " + message);
            //-----------------------------------------------------
             //send to router2  

                System.out.println(mySocket.isConnected());
                if(mySocket.isConnected()==true)
                {            

                        mySocket.sendMessage(ipmap[1], Integer.parseInt(port[1]), message);
                        //receive from router2
                        //MyServerDatagramSocket mySocket2 = new MyServerDatagramSocket(serverPort2);
                        System.out.println("Echo server ready.");
            
                        DatagramMessage request2 = mySocket.receiveMessageAndSender();
                        System.out.println("Request received");
                        String message2 = request2.getMessage();
                        System.out.println("message received: " + message2);
            
                        mySocket.sendMessage(ipmap[0], Integer.parseInt(port[0]), message2);
            
                        if(message2.trim().equals("done"))
                        {
                            done = true;
                        }
                            mySocket.close();
                    }
                else
                {       
                       // System.out.println("chang router" );
                       // DatagramMessage request = mySocket.receiveMessageAndSender();
                        //System.out.println("Request received");
                        //String message = request.getMessage();
                        //String a = "";
                        //port[0] = a + request.getPort();
                        //System.out.println("message received: " + message);
            //-----------------------------------------------------
             //send to router2  
            
                        
                        mySocket.sendMessage(ipmap[2], Integer.parseInt(port[2]), message);
                        //receive from router2
                        //MyServerDatagramSocket mySocket2 = new MyServerDatagramSocket(serverPort2);
                        System.out.println("Echo server ready.");
            
                        DatagramMessage request2 = mySocket.receiveMessageAndSender();
                        System.out.println("Request received");
                        String message2 = request2.getMessage();
                        System.out.println("message received: " + message2);
            
                        mySocket.sendMessage(ipmap[0], Integer.parseInt(port[0]), message2);
            
                        if(message2.trim().equals("done"))
                        {
                            done = true;
                        }
            
                         mySocket.close();   
                }
                    //mySocket.close();
            }
        }
      }
      
      
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        UDPTCPRouter1 udpRouter1 = new UDPTCPRouter1();
      
         udpRouter1.receiveAndsendData();
        }
    }

