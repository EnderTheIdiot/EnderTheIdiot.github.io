// End-User Interface (Part of 3.3 Serializable Project)
// Made by: Henry Smith
// Started: 11/9/2025
// Finished: 11/14/2025

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class EndUserInterface extends JFrame implements ActionListener {

        private JButton viewDataB;
        private JFrame window1;
        private JFrame window4;
        private JFrame window5;
        private JButton back1B; 
        private JButton back2B; 
        private JButton studentSB; 
        private File sDirect;
        private List<JButton> studentListB;
        private List<JLabel> studentListL;
        private List<Student> students;
        private int indexA;
        private int totalStudents;
        private JLabel targetLabel;
        private JLabel studentCount;
    
        public EndUserInterface() {
    
            // The main directory for the program
            sDirect = new File("student.info");

            // Counts the total number of students
            totalStudents = 0;

            // Creates the first window for the main menu
            window1 = new JFrame("End User Interface - Menu");
            window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window1.setSize(300, 120);
            window1.setBackground(Color.WHITE);
            window1.setLayout(new FlowLayout());
            window1.setLocationRelativeTo(window1);
    
            // Creates the second window for selecting a student (for Viewing Data)
            window4 = new JFrame("View Data - Student Selection");
            window4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window4.setSize(335, 260);
            window4.setBackground(Color.WHITE);
            window4.setLayout(new FlowLayout());
            window4.setLocationRelativeTo(window4);
    
            // Creates the third window for viewing the selected data
            window5 = new JFrame("View Data - Student Viewer");
            window5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window5.setSize(420, 350);
            window5.setBackground(Color.WHITE);
            window5.setLayout(new FlowLayout());
            window5.setLocationRelativeTo(window5);
    
            // All the other buttons in the interface
            viewDataB = new JButton("View student data");
            viewDataB.addActionListener(this);
            back1B = new JButton("Back to Menu");
            back1B.addActionListener(this);
            back2B = new JButton("Back to Menu");
            back2B.addActionListener(this);
    
            // Checks to see if there is info in the "student.info" file
            if (sDirect.length() > 0 ) {
    
                // Adds lists for previously entered student names and information to be viewed and changed
                studentListB = new ArrayList<>();
                studentListL = new ArrayList<>();
                students = new ArrayList<>();
    
                // Reads the "student.info" file, and inputs the data as JLabels and JButtons for viewing and changing the data
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sDirect))) {
                    while (true) {
                        try {
                            Object obj = ois.readObject();
                            if (obj instanceof Student) {
                                final Student s = (Student) obj;
                                students.add(s);
                                JLabel studentInfo = new JLabel(s.toString());
                                studentSB = new JButton("- " + s.getName());
                                studentInfo.setName(s.getName());
                                studentListB.add(studentSB);
                                studentListL.add(studentInfo);
                                window5.add(studentInfo);
                                studentInfo.setVisible(false);
                                window4.add(studentSB);
                                totalStudents += 1;
                            } else {
                                System.out.println("Unsupported Object " + obj.getClass().getName());
                            }
                        } catch (EOFException e) {
                            break;
                        }
                    }
                } catch (IOException | ClassNotFoundException e4) {
                    e4.printStackTrace();
                }
            } else {
                JLabel studentInfoEmpty = new JLabel("There are no recorded student entries at this time!");
                window4.add(studentInfoEmpty);
            }

            // Shows the total student count
            studentCount = new JLabel("Total Students: " + totalStudents);
    
            // Adds ActionCommands as identifiers for the different students (window 2E)
            if (studentListB != null) {
                int i1 = 0;
                for (JButton infoButton : studentListB) {
                    infoButton.addActionListener(this);
                    infoButton.setActionCommand(i1+"");
                    i1+=1;
                }
            }
    
            // Adds the buttons to the main interface (window 1), a back button for the viewing (window 4) and data change (window 3), and an info label for the data entry inteface (window 2) interfaces, 
            window1.add(viewDataB);
            window1.setVisible(true);
            window4.add(studentCount);
            window4.add(back1B);
            window5.add(back2B);
        }

            
        @Override
        public void actionPerformed(ActionEvent e) {
    
            // The back button for data viewing selection
            if (e.getSource() == back1B){
                if (window4.isVisible() == true) {
                    window4.setVisible(false);
                    window1.setVisible(true);
                }
            }

            // The back button for data view
            if (e.getSource() == back2B){
                if (window5.isVisible() == true) {
                    window5.setVisible(false);
                    window1.setVisible(true);
                }
                if (window4.isVisible() == true) {
                    window4.setVisible(false);
                }
            }
    
            // Opens the window for selecting the data to view
            if (e.getSource() == viewDataB){
                window4.setVisible(true);
            }
    
            // Selection for viewing students
            if (studentListB != null) {
                if (studentListB.contains((JButton)e.getSource()) == true) {
                    try {
                        indexA = Integer.parseInt(e.getActionCommand());
                    } catch (NumberFormatException e6) {
                        e6.printStackTrace();
                    }
                    if (indexA != -1 && indexA < studentListL.size()){
                        targetLabel = studentListL.get(indexA);
                        targetLabel.setVisible(true);
                    }
                    window5.setVisible(true);
                }
            }
        }
            
        public static void main(String[] args) {
            SwingUtilities.invokeLater(EndUserInterface::new);
        }
    }
