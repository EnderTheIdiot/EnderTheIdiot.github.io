// Colored Buttons Program
// Made by: Henry Smith
// Started: 10/6/2025
// Finished: 10/7/2025

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JFrame {

    private int currentB1ColorI = 0;
    private int currentB2ColorI = 0;
    private int currentB3ColorI = 0;
    private int currentB4ColorI = 0;
    private final int totalColors = 8;

    public Buttons() {
        setTitle("THE BUTTONS");
        setSize(720, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 4));

        JButton button1 = new JButton("Color 1");
        button1.setBackground(Color.WHITE);
        button1.setOpaque(true);
        button1.setBorderPainted(false);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentB1ColorI = (currentB1ColorI + 1) % totalColors; 
                switch (currentB1ColorI) {
                    case 0:
                        button1.setBackground(Color.YELLOW);
                        break;
                    case 1:
                        button1.setBackground(Color.RED);
                        break;
                    case 2:
                        button1.setBackground(Color.GREEN);
                        break;
                    case 3:
                        button1.setBackground(Color.YELLOW);
                        break;
                    case 4:
                        button1.setBackground(Color.WHITE);
                        break;
                    case 5:
                        button1.setBackground(Color.PINK);
                        break;
                    case 6:
                        button1.setBackground(Color.CYAN);
                        break;
                    case 7:
                        button1.setBackground(Color.ORANGE);
                        break;
                }
            }
        });

        JButton button2 = new JButton("Color 2");
        button2.setBackground(Color.WHITE);
        button2.setOpaque(true);
        button2.setBorderPainted(false);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentB2ColorI = (currentB2ColorI + 1) % totalColors; 
                switch (currentB2ColorI) {
                    case 0:
                        button2.setBackground(Color.YELLOW);
                        break;
                    case 1:
                        button2.setBackground(Color.RED);
                        break;
                    case 2:
                        button2.setBackground(Color.GREEN);
                        break;
                    case 3:
                        button2.setBackground(Color.YELLOW);
                        break;
                    case 4:
                        button2.setBackground(Color.WHITE);
                        break;
                    case 5:
                        button2.setBackground(Color.PINK);
                        break;
                    case 6:
                        button2.setBackground(Color.CYAN);
                        break;
                    case 7:
                        button2.setBackground(Color.ORANGE);
                        break;
                }
            }
        });

        JButton button3 = new JButton("Color 3");
        button3.setBackground(Color.WHITE);
        button3.setOpaque(true);
        button3.setBorderPainted(false);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentB3ColorI = (currentB3ColorI + 1) % totalColors; 
                switch (currentB3ColorI) {
                    case 0:
                        button3.setBackground(Color.YELLOW);
                        break;
                    case 1:
                        button3.setBackground(Color.RED);
                        break;
                    case 2:
                        button3.setBackground(Color.GREEN);
                        break;
                    case 3:
                        button3.setBackground(Color.YELLOW);
                        break;
                    case 4:
                        button3.setBackground(Color.WHITE);
                        break;
                    case 5:
                        button3.setBackground(Color.PINK);
                        break;
                    case 6:
                        button3.setBackground(Color.CYAN);
                        break;
                    case 7:
                        button3.setBackground(Color.ORANGE);
                        break;
                }
            }
        });

        JButton button4 = new JButton("Color 4");
        button4.setBackground(Color.WHITE);
        button4.setOpaque(true);
        button4.setBorderPainted(false);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentB4ColorI = (currentB4ColorI + 1) % totalColors; 
                currentB2ColorI = (currentB2ColorI + 1) % totalColors; 
                switch (currentB2ColorI) {
                    case 0:
                        button4.setBackground(Color.YELLOW);
                        break;
                    case 1:
                        button4.setBackground(Color.RED);
                        break;
                    case 2:
                        button4.setBackground(Color.GREEN);
                        break;
                    case 3:
                        button4.setBackground(Color.YELLOW);
                        break;
                    case 4:
                        button4.setBackground(Color.WHITE);
                        break;
                    case 5:
                        button4.setBackground(Color.PINK);
                        break;
                    case 6:
                        button4.setBackground(Color.CYAN);
                        break;
                    case 7:
                        button4.setBackground(Color.ORANGE);
                        break;
                }
            }
        });
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Buttons::new);
    }
}

// NOTE: Sorry if this program takes a long time to load. It takes a long time to finish for me, but it could just be my computer lagging, I don't know.