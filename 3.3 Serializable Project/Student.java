// Student Class (Part of [3.3 Serializable Program])
// Made by: Henry Smith
// Started: 11/7/2025
// Finished: 11/14/2025

import java.io.Serializable;

public class Student implements Serializable{
    //private static final long serialVersionUID = 1L;
    String studentName;
    String studentEduid;
    String studentId;
    String studentBirthDate;
    int studentGrade;
    String studentGender;
    String studentHobbies;
    String studentFavColor;
    String parentName1;
    String parentName2;
    String parentEmail;
    String parentPhone;
    boolean studentWithdrawn;
    String studentECD; // Note: ECD for this variable stands for "Entry Creation Date"
    boolean studentGraduate;

    Student(String name, String eduid, String id, String birthDate, int grade, String gender, String hobbies, String favColor, String parName1, String parName2, String parEmail, String parPhone, boolean withdrawn, String age, boolean graduated) {
        this.studentName = name;
        this.studentEduid = eduid;
        this.studentId = id;
        this.studentBirthDate = birthDate;
        this.studentGrade = grade;
        this.studentGender = gender;
        this.studentHobbies = hobbies;
        this.studentFavColor = favColor;
        this.parentName1 = parName1;
        this.parentName2 = parName2;
        this.parentEmail = parEmail;
        this.parentPhone = parPhone;
        this.studentWithdrawn = withdrawn;
        this.studentECD = age;
    }

    // Main getter/setter methods. Can be used by all 3 interfaces
    public String getName() { return studentName; }
    public void setName(String newName) { this.studentName= newName; }
    public String getID() { return studentId; }
    public void setID(String newID) { this.studentId = newID; }
    public String getBirthday() { return studentBirthDate; }
    public void setBirthday(String newBirthday) { this.studentBirthDate = newBirthday; }
    public int getGrade() { return studentGrade; }
    public void setGrade(int newGrade) { this.studentGrade = newGrade; }
    public String getParName1() { return parentName1; }
    public void setParName1(String newParName1) { this.parentName1= newParName1; }
    public String getParName2() { return parentName2; }
    public void setParName2(String newParName2) { this.parentName2= newParName2; }
    public String getParEmail() { return parentEmail; }
    public void setParEmail(String newParEmail) { this.parentEmail= newParEmail; }
    public String getParPhone() { return parentPhone; }
    public void setParPhone(String newParPhone) { this.parentPhone= newParPhone; }
    public String getGender() { return studentGender; }
    public void setGender(String newGender) { this.studentGender = newGender; }
    public String getFavColor() { return studentFavColor; }
    public void setFavColor(String newFavColor) { this.studentFavColor = newFavColor; }
    public String getHobbies() { return studentHobbies; }
    public void setHobbies(String newHobbies) { this.studentHobbies = newHobbies; }
    public String getGraduated() { return studentHobbies; }
    public String getAge() { return studentECD; }
    public String getEDUID() { return studentEduid; }

    // Restricted getter/setter methods. Can only be used by the Admin interface
    public boolean getWithdrawn() { return studentWithdrawn; }
    public void setEDUID(String newEDUID) { this.studentEduid = newEDUID; }
    public void setWithdrawn(boolean newWithdrawnStatus) { this.studentWithdrawn = newWithdrawnStatus; }

    // The toString() that is used by the JLabels that display student info in the three user interfaces
    @Override
    public String toString() {
        return "<html>Student Name: " + studentName + "<br/>Student EDUID: " + studentEduid + "<br/>Student ID: " + studentId + "<br/>Student Birthday: " + studentBirthDate + "<br/>Student Grade:" + studentGrade + "<br/>Student Gender " + studentGender + "<br/>Student Hobbies: " + studentHobbies + "<br/>Student Favorite Color: " + studentFavColor + "<br/>Student Parent Name(s): " + parentName1 + "<br/>Parent Email: " + parentEmail + "<br/>Parent Phone: " + parentPhone + "<br/>Withdrawn: " +studentWithdrawn +"<br/>Account Creation Data: " + studentECD + "<br/>Student Graduated: " + studentGraduate + "<html>";
    }
}
