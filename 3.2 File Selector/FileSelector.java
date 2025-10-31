// File Selector Test
// Made by: Henry Smith
// Started: 10/29/2025
// Finished: 10/30/2025

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileSelector extends JFrame implements ActionListener {


    // Makes the variables available to all methods and classes in this program
    private JTextField fact1;
    private JTextField fact2;
    private JTextField fact3;
    private JCheckBox addUsernameOp;
    private JCheckBox replaceOldDataOp;
    private JButton selectFileB;
    private JButton createFileB;
    private JLabel fileNameLabel;
    private JLabel info1;
    private JLabel info2;
    private JLabel info3;
    private JFrame window1;
    private JFrame window2;
    private JButton submitChangesB;
    private JButton submitB; 
    private String fileName;
    private JTextField newFileName;
    private File sDirect;
    private boolean dontReplaceOldData;

    // Your username that can be added to the info you write down. 
    // (Note: I couldn't find the correct way of using an action listener to turn a text field on and off while in a seperate window, so I used this instead)
    private final String username = "<INSERT USERNAME HERE!>";

    public FileSelector() {
        // Creates the starting directory for the file selector (used later in the program)
        sDirect = new File("/Users/amysmith/Desktop/3.2 File Selector");

        // Creates the first window, where you select an existing file, or create a new one
        window1 = new JFrame("File Selecton");
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window1.setSize(280, 80);
        window1.setBackground(Color.WHITE);
        window1.setLayout(new FlowLayout());
        window1.setLocationRelativeTo(window1);

        // Creates a window for the user to insert data
        window2 = new JFrame("Info Manager");
        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window2.setSize(335, 260);
        window2.setBackground(Color.WHITE);
        window2.setLayout(new FlowLayout());
        window2.setLocationRelativeTo(window2);

        // The file name for the newly created file, (If you choose to make one.)
        newFileName = new JTextField(20);

        // Fun facts given by the user
        fact1 = new JTextField(20);
        fact2 = new JTextField(20);
        fact3 = new JTextField(20);

        // Adds the checkboxs for adding your username to the info (LISTED IN THE VARIABLES), and replacing or keeping old data
        addUsernameOp = new JCheckBox("Add Username: ");
        addUsernameOp.addActionListener(this);
        replaceOldDataOp = new JCheckBox("Replace Old Data: ");
        replaceOldDataOp.addActionListener(this);

        // Adds the info submission buttons
        selectFileB = new JButton("Select File");
        createFileB = new JButton("Create New File");
        selectFileB.addActionListener(this);
        createFileB.addActionListener(this);

        // Shows the file name on the first window
        fileNameLabel = new JLabel();
        info1 = new JLabel("- Give 3 Facts about Yourself! -");
        info2 = new JLabel("v Insert New File Name Below v");
        info3 = new JLabel("(ex. MyCoolFile)");
        submitB = new JButton("Submit File");
        submitChangesB = new JButton("Submit Changes");
        submitB.addActionListener(this);
        submitChangesB.addActionListener(this);

        // Adds the elements to the first window
        window1.add(selectFileB);
        window1.add(createFileB);
        window1.setVisible(true);

        // Adds the elements to the second window
        window2.add(info1);
        window2.add(fact1);
        window2.add(fact2);
        window2.add(fact3);
        window2.add(addUsernameOp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Opens the file chooser, and sets the 2nd window to visible
        if (e.getSource() == selectFileB){
            window1.add(fileNameLabel);
            JFileChooser fileMenu = new JFileChooser();
            fileMenu.setCurrentDirectory(sDirect);
            int returnValue = fileMenu.showOpenDialog(FileSelector.this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File chosenFile = fileMenu.getSelectedFile();
                fileNameLabel.setText("File Selected!: " + chosenFile.getAbsolutePath());
                fileName = chosenFile.getName();
                window2.add(replaceOldDataOp);
                window2.add(submitChangesB);
                window1.setVisible(false);
                window2.setVisible(true);
            } else {
                fileNameLabel.setText("Cancelled File Selection!");
            }
        }

        // Sets the 2nd window to visible, and adds a text field for setting the name of the new file
        if (e.getSource() == createFileB){
            window2.add(info2);
            window2.add(newFileName);
            window2.add(info3);
            window2.add(submitB);
            window2.setVisible(true);
        }

        // Inserts the info into a newly made file
        if (e.getSource() == submitB) {
            String fact1I = fact1.getText();
            String fact2I = fact2.getText();
            String fact3I = fact3.getText();
            try (FileOutputStream userFile = new FileOutputStream(newFileName.getText() + ".txt", true)) {
                if (addUsernameOp.isSelected()) {
                    String usernameI = username;
                    String extraSpace = "\n";
                    String Line0 = "Name: " + usernameI;
                    byte[] DataE = extraSpace.getBytes();
                    byte[] Data0 = Line0.getBytes();
                    userFile.write(DataE);
                    userFile.write(Data0);
                }
                String Line1 = "\n"+"Fact 1: " + fact1I;
                String Line2 = "\n"+"Fact 2: " + fact2I;
                String Line3 = "\n"+"Fact 3: " + fact3I;
                byte[] Data1 = Line1.getBytes();
                byte[] Data2 = Line2.getBytes();
                byte[] Data3 = Line3.getBytes();
                userFile.write(Data1);
                userFile.write(Data2);
                userFile.write(Data3);
            }   catch (IOException b) {
                System.err.println("Error: " + b.getMessage());
            }
            System.exit(0);
        }

        // Inserts the new info into an existing file
        if (e.getSource() == submitChangesB) {
            String fact1I = fact1.getText();
            String fact2I = fact2.getText();
            String fact3I = fact3.getText();
            if (replaceOldDataOp.isSelected()) {
                dontReplaceOldData = true;
            }
            try (FileOutputStream userFile = new FileOutputStream(fileName, dontReplaceOldData)) {
                if (addUsernameOp.isSelected()) {
                    String usernameI = username;
                    String extraSpace = "\n";
                    String Line0 = "Name: " + usernameI;
                    byte[] DataE = extraSpace.getBytes();
                    byte[] Data0 = Line0.getBytes();
                    userFile.write(DataE);
                    userFile.write(Data0);
                }
                String Line1 = "\n"+"Fact 1: " + fact1I;
                String Line2 = "\n"+"Fact 2: " + fact2I;
                String Line3 = "\n"+"Fact 3: " + fact3I;
                byte[] Data1 = Line1.getBytes();
                byte[] Data2 = Line2.getBytes();
                byte[] Data3 = Line3.getBytes();
                userFile.write(Data1);
                userFile.write(Data2);
                userFile.write(Data3);
            }   catch (IOException b) {
                System.err.println("Error: " + b.getMessage());
            }
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(FileSelector::new);
    }
}




