// Data Entry Class (Part of [3.3 Serializable Program])
// Made by: Henry Smith
// Started: 11/7/2025
// Finished: 11/14/2025

// PURPOSE: When opened, this program provides a GUI menu in which you can choose to do one of the following: 1. Add a new student, 2. Makes changes

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;
import java.lang.NumberFormatException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

public class DataEntry extends JFrame implements ActionListener {

    private Student newStudent;
    private JTextField studentNamei;
    private JTextField studentIdi;
    private JTextField studentBirthDatei;
    private JTextField studentGradei;
    private JRadioButton extraInfo;
    private JRadioButton showEDUID;
    private JTextField studentGenderi;
    private JTextField studentHobbiesi;
    private JTextField studentFavColori;
    private JTextField parentName1i;
    private JTextField parentName2i;
    private JTextField parentEmaili;
    private JTextField parentPhonei;
    private String studentECDi;
    private JLabel studentNamee;
    private JLabel studentIde;
    private JLabel studentEduide;
    private JLabel studentBirthDatee;
    private JLabel studentGradee;
    private JLabel studentGendere;
    private JLabel studentHobbiese;
    private JLabel studentFavColore;
    private JLabel parentName1e;
    private JLabel parentName2e;
    private JLabel parentEmaile;
    private JLabel parentPhonee;
    private String studentEduidi;
    private Random EDUIDRandomizer;
    private JButton changeDataB;
    private JButton viewDataB;
    private JButton addStudentB;
    private JLabel info1;
    private JLabel errorLabel;
    private JFrame window1;
    private JFrame window2;
    private JFrame window4;
    private JFrame window5;
    private JFrame window3;
    private JButton submitChangesB;
    private JButton submitB; 
    private JButton back1B; 
    private JButton back2B; 
    private JButton studentSB; 
    private JButton studentSB2; 
    private File sDirect;
    private long EDUID;
    private boolean gradeExists = true;
    private int studentGradei2;
    private List<JButton> studentListB;
    private List<JButton> studentListB2;
    private List<JLabel> studentListL;
    private DateTimeFormatter formatTime;
    private LocalDate replaceECD;
    private List<Student> students;
    private int indexA;
    private int indexB;
    private JLabel targetLabel;
    private List<Student> students2;
    private Student studentToEdit;

    public DataEntry() {

        // The main directory for the program
        sDirect = new File("student.info");

        // Formats the current date for when this program is used
        formatTime = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        replaceECD = LocalDate.now();

        // Creates the first window for the main menu
        window1 = new JFrame("Data Entry Interface - Menu");
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window1.setSize(300, 120);
        window1.setBackground(Color.WHITE);
        window1.setLayout(new FlowLayout());
        window1.setLocationRelativeTo(window1);

        // Creates the second window for entering new data
        window2 = new JFrame("New Student - Student Info Entry");
        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window2.setSize(280, 680);
        window2.setBackground(Color.WHITE);
        window2.setLayout(new FlowLayout());
        window2.setLocationRelativeTo(window2);

        // Creates the third window for selecting a student (for Changing Data)
        window3 = new JFrame("Change Data - Student Selection");
        window3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window3.setSize(280, 680);
        window3.setBackground(Color.WHITE);
        window3.setLayout(new FlowLayout());
        window3.setLocationRelativeTo(window3);

        // Creates the fourth window for selecting a student (for Viewing Data)
        window4 = new JFrame("View Data - Student Selection");
        window4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window4.setSize(335, 260);
        window4.setBackground(Color.WHITE);
        window4.setLayout(new FlowLayout());
        window4.setLocationRelativeTo(window4);

        // Creates the fifth window for viewing the selected data
        window5 = new JFrame("View Data - Student Viewer");
        window5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window5.setSize(420, 350);
        window5.setBackground(Color.WHITE);
        window5.setLayout(new FlowLayout());
        window5.setLocationRelativeTo(window5);

        // Randomizes the EDUID for the next student to be added
        EDUIDRandomizer = new Random();
        long minEDUID = 100_000_000L;
        long maxEDUID = 999_999_999L;
        EDUID = EDUIDRandomizer.nextLong(maxEDUID - minEDUID + 1);
       
        // Creates the text fields for receving student inputs
        studentNamei = new JTextField(20);
        studentIdi = new JTextField(20);
        studentBirthDatei = new JTextField(20);
        studentGradei = new JTextField(20);
        studentGenderi = new JTextField(20);
        studentHobbiesi = new JTextField(20);
        studentFavColori = new JTextField(20);
        parentName1i = new JTextField(20);
        parentName2i = new JTextField(20);
        parentEmaili = new JTextField(20);
        parentPhonei = new JTextField(20);

        // Adds labels that explain each info required for student info entry
        info1 = new JLabel("[- - - Student Entry Form - - -]");
        errorLabel = new JLabel(" ");
        studentNamee = new JLabel("Student name: ");
        studentIde = new JLabel("Student ID: ");
        studentEduide = new JLabel("Student EDUID: " + String.valueOf(EDUID));
        studentBirthDatee = new JLabel("Student Birthday: ");
        studentGradee = new JLabel("Student Grade (13 = Graduated)");
        parentName1e = new JLabel("Parent/Guardian Name (1): ");
        parentName2e = new JLabel("Parent/Guardian Name (2): ");
        parentEmaile = new JLabel("Parent/Guardian Email: ");
        parentPhonee = new JLabel("Parent/Gaurdian Phone Number:");

        // Extra information that the student can enter
        studentGendere = new JLabel("Student Gender: ");
        studentHobbiese = new JLabel("Hobbies: ");
        studentFavColore = new JLabel("Favorite Color: ");

        // All the other buttons in the interface
        extraInfo = new JRadioButton("Add Extra Info - ");
        extraInfo.addActionListener(this);
        showEDUID = new JRadioButton("Show EDUID -");
        showEDUID.addActionListener(this);
        changeDataB = new JButton("Change Student Data");
        changeDataB.addActionListener(this);
        viewDataB = new JButton("View student data");
        viewDataB.addActionListener(this);
        addStudentB = new JButton("New Entry");
        addStudentB.addActionListener(this);
        back1B = new JButton("Back to Menu");
        back1B.addActionListener(this);
        back2B = new JButton("Back to Menu");
        back2B.addActionListener(this);
        submitB = new JButton("Submit Entry");
        submitB.addActionListener(this);
        submitChangesB = new JButton("Submit Changes");
        submitChangesB.addActionListener(this);

        // Checks to see if there is info in the "student.info" file
        if (sDirect.length() > 0 ) {

            // Adds lists for previously entered student names and information to be viewed and changed
            studentListB = new ArrayList<>();
            studentListB2 = new ArrayList<>();
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
                            studentSB2 = new JButton("- " + s.getName());
                            studentInfo.setName(s.getName());
                            if (s.getWithdrawn() == false) {
                                studentListB.add(studentSB);
                                studentListB2.add(studentSB2);
                                studentListL.add(studentInfo);
                                window5.add(studentInfo);
                                window4.add(studentSB);
                                window3.add(studentSB2);
                            }
                            studentInfo.setVisible(false);
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

        // Adds ActionCommands as identifiers for the different students (window 2E)
        if (studentListB != null) {
            int i1 = 0;
            for (JButton infoButton : studentListB) {
                infoButton.addActionListener(this);
                infoButton.setActionCommand(i1+"");
                i1+=1;
            }
        }

        // Adds ActionCommands as identifiers for the different students (window 2E)
        if (studentListB2 != null) {
            int i2 = 0;
            for (JButton studentCButton : studentListB2) {
                studentCButton.addActionListener(this);
                studentCButton.setActionCommand(i2+"");
                i2+=1;
            }
        }

        // Adds the buttons to the main interface (window 1), a back button for the viewing (window 4) and data change (window 3), and an info label for the data entry inteface (window 2) interfaces, 
        window1.add(changeDataB);
        window1.add(viewDataB);
        window1.add(addStudentB);
        window1.setVisible(true);
        window2.add(info1);
        window4.add(back1B);
        window5.add(back2B);
    }

    // The method for getting the account age of the student (current date of entry)
    public String getAge() {
        String newECD = replaceECD.format(formatTime);
        return newECD.toString();
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {

        // The button for starting the data entry process
        if (e.getSource() == addStudentB){
            window2.add(info1);
            window2.add(studentNamee);
            window2.add(studentNamei);
            window2.add(studentIde);
            window2.add(studentIdi);
            window2.add(studentBirthDatee);
            window2.add(studentBirthDatei);
            window2.add(studentGradee);
            window2.add(studentGradei);
            window2.add(studentGendere);
            window2.add(studentGenderi);
            window2.add(studentHobbiese);
            window2.add(studentHobbiesi);
            window2.add(studentFavColore);
            window2.add(studentFavColori);
            window2.add(parentName1e);
            window2.add(parentName1i);
            window2.add(parentName2e);
            window2.add(parentName2i);
            window2.add(parentEmaile);
            window2.add(parentEmaili);
            window2.add(parentPhonee);
            window2.add(parentPhonei);
            window2.add(errorLabel);
            window2.add(submitB);
            window2.setVisible(true);
            window1.setVisible(false);
        }

        // The back button for data viewing selection
        if (e.getSource() == back1B){
            if (window4.isVisible() == true) {
                window4.setVisible(false);
                window1.setVisible(true);
            }
        }

        // The back button for viewing data
        if (e.getSource() == back2B){
            if (window5.isVisible() == true) {
                indexB = 0;
                window5.setVisible(false);
                try {
                    targetLabel.setVisible(false);
                } catch (NullPointerException e7) {
                    e7.printStackTrace();
                }
            }
        }

        // The button for starting the data changing process
        if (e.getSource() == changeDataB){
            if (sDirect.length() > 0) {
                students2 = new ArrayList<>();
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sDirect))) {
                    while (true) {
                        Object obj;
                        try {
                            obj = ois.readObject();
                            if (obj instanceof Student) {
                                students2.add((Student) obj);
                            }
                        } catch (EOFException e9) {
                            break;
                        }
                    }
                } catch (IOException | ClassNotFoundException e10) {
                    e10.printStackTrace();
                }
            }
            if (students == null) {
                students2 = new ArrayList<>();
                changeDataB.setText("No Students!");
            } else {
                window3.setVisible(true);
                window1.setVisible(false);
            }
        }

        // Opens the window for selecting the data to view
        if (e.getSource() == viewDataB){
            window4.setVisible(true);
        }


        // The button that allows the EDUID to be viewable
        if (e.getSource() == showEDUID){
            if (showEDUID.isSelected() == true) {
                studentEduide.setVisible(true);
            }
            if (showEDUID.isSelected() == false) {
                studentEduide.setVisible(false);
            }
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
                    targetLabel = studentListL.get(indexB);
                    targetLabel.setVisible(true);
                }
                window5.setVisible(true);
            }
        }


        // Selection for changing student data
        if (studentListB != null) {
            if (studentListB2.contains((JButton)e.getSource()) == true) {
                try {
                    indexB = Integer.parseInt(e.getActionCommand());
                } catch (NumberFormatException e6) {
                    e6.printStackTrace();
                }
                if (indexB >= 0 && indexB < students2.size()){
                    studentToEdit = students2.get(indexB);
                    studentNamei.setText(studentToEdit.getName());
                    studentIdi.setText(studentToEdit.getID());
                    studentBirthDatei.setText(studentToEdit.getBirthday());
                    studentGradei.setText(""+studentToEdit.getGrade());
                    studentGenderi.setText(studentToEdit.getGender());
                    studentHobbiesi.setText(studentToEdit.getHobbies());
                    studentFavColori.setText(studentToEdit.getFavColor());
                    parentName1i.setText(studentToEdit.getParName1());
                    parentName2i.setText(studentToEdit.getParName2());
                    parentEmaili.setText(studentToEdit.getParEmail());
                    parentPhonei.setText(studentToEdit.getParPhone());
                    window2.add(info1);
                    window2.add(studentNamee);
                    window2.add(studentNamei);
                    window2.add(studentIde);
                    window2.add(studentIdi);
                    window2.add(studentBirthDatee);
                    window2.add(studentBirthDatei);
                    window2.add(studentGradee);
                    window2.add(studentGradei);
                    window2.add(studentGendere);
                    window2.add(studentGenderi);
                    window2.add(studentHobbiese);
                    window2.add(studentHobbiesi);
                    window2.add(studentFavColore);
                    window2.add(studentFavColori);
                    window2.add(parentName1e);
                    window2.add(parentName1i);
                    window2.add(parentName2e);
                    window2.add(parentName2i);
                    window2.add(parentEmaile);
                    window2.add(parentEmaili);
                    window2.add(parentPhonee);
                    window2.add(parentPhonei);
                    window2.add(errorLabel);
                    window2.add(submitChangesB);
                }
                window2.setVisible(true);
                window3.setVisible(false);
            }
        }
        
        // Inserts the info from the data entry window into a newly made file
        if (e.getSource() == submitB) {
            try {
                studentGradei2 = Integer.parseInt(studentGradei.getText());
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                gradeExists = false;
            }
            errorLabel.setVisible(true);
            if (studentNamei.getText().isEmpty() == true) {
                errorLabel.setText("Entry Error: Missing Name");
            } else if (studentIdi.getText().isEmpty() == true) {
                errorLabel.setText("Entry Error: Missing ID");
            } else if (studentBirthDatei.getText().isEmpty() == true) {
                errorLabel.setText("Entry Error: Missing Date of Birth");
            } else if (gradeExists == false) {
                errorLabel.setText("Entry Error: Missing Grade (Number Only)");
                gradeExists = true;
            } else if (studentGradei2 >= 14) {
                errorLabel.setText("Entry Error: Incorrect Grade");
            } else if (parentName1i.getText().isEmpty() == true) {
                errorLabel.setText("Entry Error: Missing Parent Name");
            } else if (parentEmaili.getText().isEmpty() == true) {
                errorLabel.setText("Entry Error: Missing Email");
            } else if (parentPhonei.getText().isEmpty() == true) {
                errorLabel.setText("Entry Error: Missing Phone");
            } else {
                if (studentGenderi.getText().isEmpty() == true) {
                    studentGenderi.setText("Rather not say");
                }
                if (studentHobbiesi.getText().isEmpty() == true) {
                    studentHobbiesi.setText("None");
                }
                if (studentFavColori.getText().isEmpty() == true) {
                    studentFavColori.setText("None");
                }
                if (parentName2i.getText().isEmpty() == true) {
                    studentHobbiesi.setText("None");
                }
                boolean isStudentGraduate;
                if (studentGradei2 >= 13) {
                    isStudentGraduate = true;
                } else {
                    isStudentGraduate = false;
                }
                studentEduidi = String.valueOf(EDUID);
                studentECDi = getAge();
                newStudent = new Student(studentNamei.getText(), studentEduidi, studentIdi.getText(), studentBirthDatei.getText(), studentGradei2, studentGenderi.getText(), studentHobbiesi.getText(), studentFavColori.getText(), parentName1i.getText(), parentName2i.getText(), parentEmaili.getText(), parentPhonei.getText(), false, studentECDi, isStudentGraduate);
                if (sDirect.exists() && sDirect.length() <= 1 ) {
                    try (FileOutputStream userFile = new FileOutputStream(sDirect, true);
                         ObjectOutputStream objOut = new ObjectOutputStream(userFile)) {
                        objOut.writeObject(newStudent);
                    } catch (IOException b) {
                        System.err.println("Error: " + b.getMessage());
                    }
                } else {
                        try (FileOutputStream userFile = new FileOutputStream(sDirect, true);
                            AppendingObjectOutputStream objOut = new AppendingObjectOutputStream(userFile)) {
                                objOut.writeObject(newStudent);
                        } catch (IOException b) {
                            System.err.println("Error: " + b.getMessage());
                        }

                }
                System.exit(0);
            } 
        }

        // Inserts the newly changed info from the data change window into an existing file
        if (e.getSource() == submitChangesB) {
            try {
                studentGradei2 = Integer.parseInt(studentGradei.getText());
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                gradeExists = false;
            }
            errorLabel.setVisible(true);
            if (studentNamei.getText().isEmpty() == true) {
                errorLabel.setText("Entry Error: Missing Name");
            } else if (studentIdi.getText().isEmpty() == true) {
                errorLabel.setText("Entry Error: Missing ID");
            } else if (studentBirthDatei.getText().isEmpty() == true) {
                errorLabel.setText("Entry Error: Missing Date of Birth");
            } else if (gradeExists == false) {
                errorLabel.setText("Entry Error: Missing Grade (Number Only)");
                gradeExists = true;
            } else if (studentGradei2 >= 13) {
                errorLabel.setText("Entry Error: Incorrect Grade");
            } else if (parentName1i.getText().isEmpty() == true) {
                errorLabel.setText("Entry Error: Missing Parent Name");
            } else if (parentEmaili.getText().isEmpty() == true) {
                errorLabel.setText("Entry Error: Missing Email");
            } else if (parentPhonei.getText().isEmpty() == true) {
                errorLabel.setText("Entry Error: Missing Phone");
            } else {
                if (studentGenderi.getText().isEmpty() == true) {
                    studentGenderi.setText("Rather not say");
                }
                if (studentHobbiesi.getText().isEmpty() == true) {
                    studentHobbiesi.setText("None");
                }
                if (studentFavColori.getText().isEmpty() == true) {
                    studentFavColori.setText("None");
                }
                if (parentName2i.getText().isEmpty() == true) {
                    studentHobbiesi.setText("None");
                }
            studentToEdit.setName(studentNamei.getText());
            studentToEdit.setID(studentIdi.getText());
            studentToEdit.setBirthday(studentBirthDatei.getText());
            studentToEdit.setGrade(Integer.parseInt(studentGradei.getText()));
            studentToEdit.setGender(studentGenderi.getText());
            studentToEdit.setHobbies(studentHobbiesi.getText());
            studentToEdit.setFavColor(studentFavColori.getText());
            studentToEdit.setParName1(parentName1i.getText());
            studentToEdit.setParName2(parentName2i.getText());
            studentToEdit.setParEmail(parentEmaili.getText());
            studentToEdit.setParPhone(parentPhonei.getText());
            students2.remove(indexB);
            students2.add(studentToEdit);
            try {
                PrintWriter studentFileRefresher = new PrintWriter(new FileWriter(sDirect, false));
                studentFileRefresher.print("");
                studentFileRefresher.close();
            } catch (IOException e11){
                e11.printStackTrace();
            }
            if (sDirect.exists() && sDirect.length() > 0 ) {
                try (FileOutputStream userFile = new FileOutputStream(sDirect, true);
                    AppendingObjectOutputStream objOut = new AppendingObjectOutputStream(userFile)) {
                   for (Student cStudent : students2) {
                        objOut.writeObject((Student) cStudent);
                    }
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            } else {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(sDirect, true))) {
                   for (Student cStudent : students2) {
                        oos.writeObject((Student) cStudent);
                    }
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            System.exit(0);
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DataEntry::new);
    }
}

// [NOTE]: Sorry this program took so long to make. It was really hard to the get this program fullt debugged, so it is a bit messy, but everything should work as intended