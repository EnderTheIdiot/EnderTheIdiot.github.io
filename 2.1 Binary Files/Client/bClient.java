package Client;
// 2.1 File Sender Client
// Program Author: Henry Smith
// Started: 9/15/2025
// Finished: 9/20/2025

import java.io.*;
import java.net.*;

public class bClient {
    // User Note: Insert the data for each variable!
    private static final String SERVER_ADDRESS = "localhost";
    private static final String FILE_PATH= "/Users/amysmith/Desktop/2.1 Binary Files/Client/thisisafile.bin";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            // Connects with server
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println(" ");
            System.out.println("Successfully connected with server!");

            // Creates the input and output streams necessary to send the file
            System.out.println(" ");
            System.out.println("Establishing stream connections...");
            File FTS = new File(FILE_PATH);
            FileInputStream rawInStream = new FileInputStream(FTS);
            BufferedInputStream inStream = new BufferedInputStream(rawInStream);
            OutputStream rawOutStream = socket.getOutputStream();
            BufferedOutputStream outStream = new BufferedOutputStream(rawOutStream);
            
            // Reads the information from the file, and sends it to the server
            System.out.println(" ");
            System.out.println("Reading File...");
            System.out.println(" ");
            System.out.println("Sending...");
            byte[] buffer = new byte[4096];
            int receivedBytes;
            while ((receivedBytes = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, receivedBytes);
            }
            outStream.flush();

            // Closes all streams and disconnects from the server
            System.out.println(" ");
            System.out.println("File Sent Successfully!");
            System.out.println("Closing all elements...");
            rawInStream.close();
            inStream.close();
            rawOutStream.close();
            outStream.close();
            socket.close();

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            System.out.println(" ");
            System.out.println("Program Finished");
        }
    }
}

// Note: Also, there was an issue with the ports, where having two different ports would 
// cause the program to disconnect, and I couldn't seem to find a way around using the same one.
// Not sure why this happened, but it seems setting the server and the client to the same port worked just fine
