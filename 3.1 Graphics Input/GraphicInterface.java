// Graphic Input and Action Listener test
// Made by: Henry Smith
// Started: 10/24/2025
// Finished: 10/27/2025

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class GraphicInterface {
    public static void main(String[] args) {

        // Creates the first window
        JFrame panel1 = new JFrame("User-Login Page");
        panel1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.setSize(280, 250);
        panel1.setBackground(Color.WHITE);
        panel1.setLayout(new FlowLayout());
        panel1.setLocationRelativeTo(panel1);

        // Adds the name and address inputs
        JLabel nameText = new JLabel("Enter Name: ");
        JTextField nameI = new JTextField(20);
        JLabel addressText = new JLabel("Enter Address: ");
        JTextArea addressI = new JTextArea("INSERT ADDRESS HERE");
        //addressI.setBounds(0,0,40,15);

        // Adds the gender inputs
        JRadioButton option1 = new JRadioButton("Male");
        option1.setLocation(20, 140);
        JRadioButton option2 = new JRadioButton("Female");
        option2.setLocation(20, 160);
        JRadioButton option3 = new JRadioButton("Rather not say");
        option3.setLocation(20, 180);
        ButtonGroup genderOptions = new ButtonGroup();
        genderOptions.add(option1);
        genderOptions.add(option2);
        genderOptions.add(option3);

        // Creates a second window to use for confirmation (appears AFTER the submit button is pressed)
        JFrame panel2 = new JFrame("User-Login Confirm");
        panel2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel2.setSize(240, 160);
        panel2.setLayout(new FlowLayout());
        panel2.setLocationRelativeTo(panel1);
        JButton confirmed = new JButton("(Confirm)");
        JButton denied = new JButton("(Cancel)");


        // Adds a submit button to add the given info to uthe file "userData.txt" (REQUIRES CONFIRMATION BEFORE SAVED)
        JButton submitB1 = new JButton("Submit Info");
        submitB1.addActionListener(e -> {
            String name = nameI.getText();
            String address = addressI.getText();
            String gender;
            if (option1.isSelected()) {
                gender = "Male";
            } else if (option2.isSelected()){
                gender = "Female";
            } else if (option3.isSelected()){
                gender = "Rather not say";
            } else {
                gender = "Unknown";
            }

            // Adds a display for given infoformation
            JLabel cName = new JLabel("User Name: " + name);
            JLabel cAddress = new JLabel("User Address: " + address);
            JLabel cGender = new JLabel("User Gender: " + gender);

            // Sets the confirmation window to "visible" once the submit button is pressed
            panel1.setVisible(false);
            panel2.add(cName);
            panel2.add(cAddress);
            panel2.add(cGender);
            panel2.add(confirmed);
            panel2.add(denied);
            panel2.setVisible(true);

            // Saves the data in a txt file
            confirmed.addActionListener(a -> {
                try (FileOutputStream userFile = new FileOutputStream("userData.txt", true)) {
                    String startLine = "\n";
                    String Line1 = "User Name: " + name;
                    String Line2 = " / User Address: " + address;
                    String Line3 = " / User Gender: " + gender;
                    byte[] Data1 = Line1.getBytes();
                    byte[] Data2 = Line2.getBytes();
                    byte[] Data3 = Line3.getBytes();
                    byte[] Data0 = startLine.getBytes();
                    userFile.write(Data0);
                    userFile.write(Data1);
                    userFile.write(Data2);
                    userFile.write(Data3);
                }   catch (IOException b) {
                    System.err.println("Error: " + b.getMessage());
                }
                panel2.setVisible(false);
                System.exit(0);
            });

            // Brings back the original window to be modified
            denied.addActionListener(c -> {
                panel2.getContentPane().removeAll();
                panel2.setVisible(false);
                panel1.setVisible(true);
            });
        });

        // Adds the GUI components to the original window
        panel1.add(nameText);
        panel1.add(nameI);
        panel1.add(addressText);
        panel1.add(addressI);
        panel1.add(option1);
        panel1.add(option2);
        panel1.add(option3);
        panel1.add(submitB1, BorderLayout.SOUTH);
        panel1.setVisible(true);
    }
}