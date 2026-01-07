// Poker Game Program (AKA Analog Poker)
// By: Henry Smith
// Started: May 6, 2025
// Finished: May 12, 2025


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.stream.Collectors;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.net.UnknownHostException;


public class GameClient {

    public static final String serverAddress = "localhost";
    public static final int serverPort = 12314;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            int handSize = 7;
            int cardSize = 15;
            int playerCardSum = 0;
            int handsLeft = 3;
            int pSel1 = 0, pSel2 = 0, pSel3 = 0, pSel4 = 0, pSel5 = 0;
            int currentScore = 0;
            int totalScore = 0;
            int equalValAmn;
            
                JFrame clientWindow1 = new JFrame("Client - Connection Menu");
                clientWindow1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                clientWindow1.setSize(500, 500);
                clientWindow1.setLocationRelativeTo(null);
                clientWindow1.setResizable(false);
                JPanel clientDisplayWindow1 = new JPanel();
                clientDisplayWindow1.setLayout(null);
            
                JLabel clientInfo1 = new JLabel("-= Click to Connect! =-");
                clientInfo1.setBounds(50, 100,400,25);
                clientInfo1.setSize(400, 24);
                clientInfo1.setHorizontalAlignment(SwingConstants.CENTER);
                clientDisplayWindow1.add(clientInfo1);

                JFrame clientWindow2 = new JFrame("Client - Game");
                clientWindow2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                clientWindow2.setSize(900, 600);
                clientWindow2.setLocationRelativeTo(null);
                clientWindow2.setResizable(false);
                JPanel clientDisplayWindow2 = new JPanel();
                clientDisplayWindow2.setLayout(null);
            
                JLabel clientGInfo1 = new JLabel("");
                clientGInfo1.setBounds(0, 200,900,500);
                clientGInfo1.setSize(900, 500);
                clientGInfo1.setHorizontalAlignment(SwingConstants.CENTER);
                clientDisplayWindow2.add(clientGInfo1);

                JButton clientPlayHand = new JButton("Play Hand");
                clientPlayHand.setBounds(10, 480,50,25);
                clientPlayHand.setSize(400, 24);
                clientPlayHand.setHorizontalAlignment(SwingConstants.CENTER);
                clientDisplayWindow2.add(clientPlayHand);
                clientPlayHand.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try (Socket serverSocket = new Socket(serverAddress, serverPort);
                        DataOutputStream clientOut = new DataOutputStream(serverSocket.getOutputStream())) {
                        clientOut.writeInt(1);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        clientOut.writeInt(-1);
                        clientOut.flush();
                        } catch (UnknownHostException e2) {
                            e2.printStackTrace();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                });
            
                JButton clientConnectConfirm = new JButton("Connect");
                clientConnectConfirm.setBounds(50, 280,200,25);
                clientConnectConfirm.setSize(400, 24);
                clientConnectConfirm.setHorizontalAlignment(SwingConstants.CENTER);
                clientDisplayWindow1.add(clientConnectConfirm);
                clientConnectConfirm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try (Socket serverSocket = new Socket(serverAddress, serverPort);
                            DataOutputStream clientOut = new DataOutputStream(serverSocket.getOutputStream())) {
                            clientOut.writeInt(0);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                            clientOut.writeInt(-1);
                            clientOut.flush();
                            clientWindow1.setVisible(false);
                            clientWindow2.setContentPane(clientDisplayWindow2);
                            clientWindow2.setVisible(true);
                            while (true) {
                                try (BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()))) {
                                    new Thread(() -> {
                                        try {
                                            String serverResponse;
                                            while ((serverResponse = in.readLine()) != null) {
                                                try {
                                                    Thread.sleep(1000);
                                                } catch (InterruptedException e1) {
                                                    e1.printStackTrace();
                                                }
                                                clientGInfo1.setText(serverResponse);
                                            }
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                }).start(); 
                            }
                        }
                        } catch (UnknownHostException e2) {
                            e2.printStackTrace();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                });
            clientWindow1.setContentPane(clientDisplayWindow1);
            clientWindow1.setVisible(true);
        });
    }
}