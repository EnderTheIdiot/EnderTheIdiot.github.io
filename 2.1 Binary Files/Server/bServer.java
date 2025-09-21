// 2.1 File Receiving Server
// Program Author: Henry Smith
// Started: 9/15/2025
// Finished: 9/20/2025

import java.io.*;
import java.net.*;

public class bServer {
    // User Note: Insert the data for each variable!
    private static final String FILE_SAVE_PATH = "/Users/amysmith/Desktop/2.1 Binary Files/Server/serverStorage.txt";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {

        // Creates a file directory
        File fDirectory = new File(FILE_SAVE_PATH);
        
        // Checks to make sure the directory exists
        if (!fDirectory.exists()) {
            fDirectory.mkdirs();
        }

        // Creates a socket that a client can connect from
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println(" ");
            System.out.println("Server is online and open to client connection!");

            while (true) {

                // Accepts inncoming clients trying to connect
                try (Socket clientSocket = serverSocket.accept();
                    DataInputStream dataInStream1 = new DataInputStream(clientSocket.getInputStream())) {
                    System.out.println(" ");
                    System.out.println("A Client has Successfully Connected with this Server!");
                    System.out.println(" ");
                    System.out.println("Receiving file from "+clientSocket.getInetAddress()+" !");

                    // Finds the size of the received file
                    long fileByteSize = dataInStream1.readLong();
                    
                    // Attempts to read and save the file
                    System.out.println(" ");
                    System.out.println("Reading and Saving received file... ");
                    File saveFile = new File(FILE_SAVE_PATH);
                    try (FileOutputStream outStream1 = new FileOutputStream(saveFile)) {
                        byte[] buffer = new byte[4096];
                        int receivedBytes;
                        long totalBytesRead = 0;
                        while (totalBytesRead < fileByteSize && (receivedBytes = dataInStream1.read(buffer, 0, (int) Math.min(buffer.length, fileByteSize - totalBytesRead))) != -1) {
                            outStream1.write(buffer, 0, receivedBytes);
                            totalBytesRead += receivedBytes;
                        }
                        System.out.println(" ");
                        System.out.println("File Saved! Path: ["+FILE_SAVE_PATH+"]");
                    } catch (EOFException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();     
        } finally {
            System.out.println(" ");
            System.out.println("Server Closed");
        }
    }
}

// Note: For some reason, 5 of the characters from the thisisafile.bin got deleted when I created it, and I am unsure as to why
//       if you find out the reason, do let me know! - Henry Smith :)