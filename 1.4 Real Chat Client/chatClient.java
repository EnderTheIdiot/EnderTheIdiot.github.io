// Simple Network Chat Client (Version 2)
// Made by: Henry Smith
// Started: 10/9/2025
// Finished: 10/12/2025

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class chatClient {

    // Server Info (For DNS, remove the text for SERVER_ADDRESS up to the space behind the equal sign, and set the domain name to the server you are joining)
    private static final String USER_NAME = "EnderTheIdiot";
    private static final String SERVER_ADDRESS = "67.42.72.118";
    private static final int SERVER_PORT = 1234;
    public static void main(String[] args) {      
        int userChoice2 = 0; 
      
        try {
            // Connects with server
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println(" ");
            System.out.println("Successfully connected with server!");
            System.out.println(" ");
            System.out.println("Type your messages below!");
            System.out.println("(NOTE: Type /help for a list of client commands!)");

            // Creates a method of send data between the client and server (input and output streams)
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Creates and starts a thread for accepting responses from the server
            new Thread(() -> {
                try {
                    String serverResponse;
                    while ((serverResponse = in.readLine()) != null) {
                        System.out.println(serverResponse);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Creates a scanner for sending messages to the server
            Scanner scanner = new Scanner(System.in);
            String mFromClient;
            while (true) {
                mFromClient = scanner.nextLine();
                // Allows the user to send messages to the server with your username included
                if (mFromClient.equalsIgnoreCase("/name")) {
                    System.out.println(" ");
                    System.out.println("Command [/name] received!");
                    System.out.println(" ");
                    System.out.println("Your messages will now include your name!");
                    System.out.println(" ");
                    userChoice2 = 1;
                }    
                // Allows the user to view the various commands you can type
                if (mFromClient.equalsIgnoreCase("/help")) {
                    System.out.println(" ");
                    System.out.println("Command [/help] received!");
                    System.out.println(" ");
                    System.out.println("| COMMAND LIST |");
                    System.out.println("[/close] Closes your client");
                    System.out.println("[/fetchdata] Shows you the IP Address and Port Number of the server your are currently connected too");
                    System.out.println("[/name] Adds your given username to your messages (DON'T USE THIS FEATURE IF THE SERVER ALREADY HAS THIS)");
                    System.out.println(" ");
                }   
                // Allows the user to view the IP Address and the Port Number of your currently connected server 
                if (mFromClient.equalsIgnoreCase("/fetchdata")) {
                    System.out.println(" ");
                    System.out.println("Command [/fetchdata] received!");
                    System.out.println(" ");
                    System.out.println("| SERVER INFO |");
                    System.out.println("Server IP: " + SERVER_ADDRESS);
                    System.out.println("Server Port: " + SERVER_PORT);
                    System.out.println(" ");
                } 
                // Allows the user to disconnect the client from the server
                if (mFromClient.equalsIgnoreCase("/close") || mFromClient.equalsIgnoreCase("[" + USER_NAME +"]: /close")) {
                    System.out.println(" ");
                    System.out.println("Command [/close] received!");
                    System.out.println("Terminating Connection...");
                    if (scanner != null) scanner.close();
                    if (in != null) in.close();
                    if (out != null) out.close();
                    if (socket != null) socket.close();    
                    System.out.println(" ");
                    System.out.println("Connection Terminated! Restart the client to join another server!");
                    break;
                }        
                // Allows the user to send messages to the connected server  
                if (userChoice2 == 1) {
                    out.println("[" + USER_NAME +"]: " + mFromClient);
                } else {
                    out.println(mFromClient);
                }
            }     
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("You were disconnected from the server due to the error above. Please restart the program!");
        } finally {
            System.out.println(" ");
            System.out.println("Disconnected.");
        }
    }
}
