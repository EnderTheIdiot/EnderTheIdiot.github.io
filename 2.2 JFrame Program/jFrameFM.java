// JFrame Face Maker
// Program by Henry Smith
// Created: 9/26/2025

import javax.swing.*;
import java.awt.*;

public class jFrameFM extends JFrame {

    public jFrameFM() {
        // Creates the JFrame (window) for the face
        setTitle("Face Maker");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Adds the variable for adding text to the face
        faceDrawing faceText = new faceDrawing();
        faceText.setLayout(null);

        // Creates the text for the name
        JLabel faceName = new JLabel("THE CUBE");
        faceName.setFont(new Font("Arial", Font.BOLD, 30));
        faceName.setForeground(Color.DARK_GRAY);
        faceName.setHorizontalAlignment(SwingConstants.CENTER);
        faceName.setBounds(100, 50, 200, 30);

        // Creates the text for the little note below the face 
        JLabel faceInfo = new JLabel("No, this totally NOT a Geometry Dash reference");
        faceInfo.setFont(new Font("Arial", Font.ITALIC, 12));
        faceInfo.setForeground(Color.LIGHT_GRAY);
        faceInfo.setHorizontalAlignment(SwingConstants.CENTER);
        faceInfo.setBounds(10, 320, 300, 20);

        // Adds the text to the face
        faceText.add(faceName);
        faceText.add(faceInfo);
        add(faceText);
        setVisible(true);
    }

    // The class for the face
    class faceDrawing extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
                // Paints the backround
                g.setColor(Color.YELLOW);
                g.fillRect(100, 100, 200, 200);
                g.setColor(Color.DARK_GRAY);
                g.drawRect(100, 100, 200, 200);

                // Paints the first eye
                g.setColor(Color.CYAN);
                g.fillRect(245, 150, 30, 30);
                g.setColor(Color.DARK_GRAY);
                g.drawRect(245, 150, 30, 30);

                // Paints the second eye
                g.setColor(Color.CYAN);
                g.fillRect(125, 150, 30, 30);
                g.setColor(Color.DARK_GRAY);
                g.drawRect(125, 150, 30, 30);

                // Paints the mouth
                g.setColor(Color.CYAN);
                g.fillRect(150, 200, 102, 30);
                g.setColor(Color.DARK_GRAY);
                g.drawRect(150, 200, 102, 30);
        }
    }

    public static void main(String[] args) {
        // Adds the drawings after the program has started and the face is ready
        SwingUtilities.invokeLater(jFrameFM::new);
    }
}
