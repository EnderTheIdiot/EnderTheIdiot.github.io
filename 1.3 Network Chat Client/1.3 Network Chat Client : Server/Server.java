// 1.3 Network Chat Client / Server
// Original Program Author: GeeksforGeeks Staff
// Edited Program Author: Henry Smith
// Edited Program Date: 9/5/2025

import java.io.*;
import java.net.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Scanner;

public class Server {
    private static final int PORT = 12345;
    private static CopyOnWriteArrayList<ClientHandler> clients = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        try { 
            // Starts up the server
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("The server is running!");

            // Creates a scanner for sending messages to all users on the server
            new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                while(true) {
                    String serverMessage = scanner.nextLine();
                    broadcast("[Server]: " + serverMessage, null);
                }

            }).start();

            // Allows for connections between clients and this server
            while(true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connection established: " + clientSocket);


               ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Accepts incoming messages from clients
    public static void broadcast(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }  
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private String username;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;

            // Creates a method of send data between the client and server (input and output streams) 
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Prints out the message for clients joining the server
        @Override
        public void run() {
            try {
                out.println("> Enter your username ");
                username = in.readLine();
                System.out.println("User " + username + " is now connected!");
                out.println(" ");
                out.println("Welcome " + username + "!");
                out.println("You can now send messages to the server!");
                out.println(" ");
                out.println("CHAT ONLINE");
                out.println("----------------------------------");

                String inputLine;
                while ((inputLine =in.readLine()) != null) {
                    System.out.println("[" + username + "]: " + inputLine);
                    broadcast("[" + username + "]: " + inputLine, this);
                }

                // Shows when clients disconnect from the server
                clients.remove(this);
                System.out.println("User " + username + " disconnected.");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    out.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }
}

// Note: It was really hard for me to vary the code of this program from the original, so I put the author of the program I referenced above (GeeksforGeeks).
//       just so I didn't feel like i just was cheating :) (btw, I didn't copy & paste program, instead I just wrote the whole thing by hand and added and changed some things.)
