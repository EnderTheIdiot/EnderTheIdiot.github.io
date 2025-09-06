// 1.3 Network Chat Client / Client
// Original Program Author: GeeksforGeeks Staff
// Edited Program Author: Henry Smith
// Edited Program Date: 9/5/2025

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    // Adds the server address and server ports as variables
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            // Connects with server
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println(" ");
            System.out.println("Successfully connected with server!");

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
            String userInput;
            while (true) {
                userInput = scanner.nextLine();
                out.println(userInput);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Note: It was really hard for me to vary the code of this program from the original, so I put the author of the program I referenced above (GeeksforGeeks).
//       just so I didn't feel like i just was cheating :) (btw, I didn't copy & paste program, instead I just wrote the whole thing by hand and added and changed some things.)
