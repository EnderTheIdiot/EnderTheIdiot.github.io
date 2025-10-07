// Face Maker | Version 2
// Program by Henry Smith
// Started: 9/29/2025
// Finished: 10/6/2025

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FaceMakerJF extends JFrame {

    // Creates the variables for the program
    private FacePanel facePanel;
    private JButton changeFace;
    private final int totalGUI = 9;
    private String[] faceNames = {"THE YELLOW CUBE", "THE RED CUBE", "THE GREEN CUBE"};
    private String[] faceInfos = {"No, this totally NOT a Geometry Dash reference", "Evil cube?", "Oh my... it's GREEN"};
    private String[] factNames = {"FUN FACT 1", "FUN FACT 2", "FUN FACT 3", "FUN FACT 4", "FUN FACT 5", "FUN FACT 6"};
    private String[] factInfos = {"Threads: Individual connections in which tasks can be executed", "JLabels: Graphic implementations of a string", "JButtons: Graphic elements that the user can interact with", "JFrames: Computer windows that can include GUI elements", "GUI: Graphical User Interface", "JPanels: Containers that are used for grouping GUI elements together"};

    public FaceMakerJF() {
        // Creates a JFrame
        setTitle("Face Maker");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        facePanel = new FacePanel();
        add(facePanel, BorderLayout.CENTER);

        // Creates random numbers every time the button is clicked
        Random random = new Random();
        int maxNumberI = 9;

        // Creates the button for cycling between faces and facts
        changeFace = new JButton("THIS IS A BUTTON");
        changeFace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facePanel.setCurrentGUI(random.nextInt(maxNumberI));
            }
        });
        add(changeFace, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FaceMakerJF());
    }

    class FacePanel extends JPanel {
        private int currentGUI = 0 % totalGUI;

        // Refreshes the GUI of the JFrame when the button is pressed
        public void setCurrentGUI(int index) {
            this.currentGUI = index;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Sets the possible faces and facts that can appear when the button is pressed
            switch (currentGUI) {
                case 0:
                    // Adds the drawing name
                    g.setFont(new Font("Arial", Font.BOLD, 18));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(faceNames[0], 100, 80);
                
                    // Adds the little description beneath the drawing
                    g.setFont(new Font("Arial", Font.ITALIC, 12));
                    g.setColor(Color.LIGHT_GRAY);
                    g.drawString(faceInfos[0], 20, 325);

                    // Adds the face
                    g.setColor(Color.YELLOW);
                    g.fillRect(100, 100, 200, 200);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(100, 100, 200, 200);
                    g.setColor(Color.CYAN);
                    g.fillRect(245, 150, 30, 30);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(245, 150, 30, 30);
                    g.setColor(Color.CYAN);
                    g.fillRect(125, 150, 30, 30);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(125, 150, 30, 30);
                    g.setColor(Color.CYAN);
                    g.fillRect(150, 200, 102, 30);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(150, 200, 102, 30);
                    break;
                case 1:
                    // Adds the drawing name
                    g.setFont(new Font("Arial", Font.BOLD, 18));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(faceNames[1], 100, 80);
                
                    // Adds the little description beneath the drawing
                    g.setFont(new Font("Arial", Font.ITALIC, 12));
                    g.setColor(Color.LIGHT_GRAY);
                    g.drawString(faceInfos[1], 20, 325);

                    // Adds the face
                    g.setColor(Color.RED);
                    g.fillRect(100, 100, 200, 200);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(100, 100, 200, 200);
                    g.setColor(Color.WHITE);
                    g.fillRect(245, 150, 30, 30);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(245, 150, 30, 30);
                    g.setColor(Color.WHITE);
                    g.fillRect(125, 150, 30, 30);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(125, 150, 30, 30);
                    g.setColor(Color.WHITE);
                    g.fillRect(150, 200, 102, 30);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(150, 200, 102, 30);
                    break;
                case 2:
                    // Adds the drawing name
                    g.setFont(new Font("Arial", Font.BOLD, 18));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(faceNames[2], 100, 80);
                
                    // Adds the little description beneath the drawing
                    g.setFont(new Font("Arial", Font.ITALIC, 12));
                    g.setColor(Color.LIGHT_GRAY);
                    g.drawString(faceInfos[2], 20, 325);

                    // Adds the face
                    g.setColor(Color.GREEN);
                    g.fillRect(100, 100, 200, 200);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(100, 100, 200, 200);
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(245, 150, 30, 30);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(245, 150, 30, 30);
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(125, 150, 30, 30);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(125, 150, 30, 30);
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(150, 200, 102, 30);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(150, 200, 102, 30);
                    break;
                case 3:
                    // Adds the fun fact number
                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(factNames[0], 5, 355);
                
                    // Adds the fun fact near the bottom of the window
                    g.setFont(new Font("Arial", Font.ITALIC, 12));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(factInfos[0], 10, 370);
                    break;
                case 4:               
                    // Adds the fun fact number
                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(factNames[1], 5, 355);
                
                    // Adds the fun fact near the bottom of the window
                    g.setFont(new Font("Arial", Font.ITALIC, 12));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(factInfos[1], 10, 370);
                    break;
                case 5:
                    // Adds the fun fact number
                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(factNames[2], 5, 355);
                
                    // Adds the fun fact near the bottom of the window
                    g.setFont(new Font("Arial", Font.ITALIC, 12));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(factInfos[2], 10, 370);
                    break;
                case 6:
                    // Adds the fun fact number
                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(factNames[3], 5, 355);
                
                    // Adds the fun fact near the bottom of the window
                    g.setFont(new Font("Arial", Font.ITALIC, 12));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(factInfos[3], 10, 370);
                    break;
                case 7:
                    // Adds the fun fact number
                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(factNames[4], 5, 355);
                
                    // Adds the fun fact near the bottom of the window
                    g.setFont(new Font("Arial", Font.ITALIC, 12));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(factInfos[4], 10, 370);
                    break;
                case 8:
                    // Adds the fun fact number
                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(factNames[5], 5, 355);
                
                    // Adds the fun fact near the bottom of the window
                    g.setFont(new Font("Arial", Font.ITALIC, 12));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(factInfos[5], 10, 370);
                    break;
                case 9:
                    // Adds the fun fact number
                    g.setFont(new Font("Arial", Font.BOLD, 14));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(factNames[6], 5, 355);
                
                    // Adds the fun fact near the bottom of the window
                    g.setFont(new Font("Arial", Font.ITALIC, 12));
                    g.setColor(Color.DARK_GRAY);
                    g.drawString(factInfos[6], 10, 370);
                    break;
            }
        }
    }
}

