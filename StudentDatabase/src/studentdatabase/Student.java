package studentdatabase;

import java.util.ArrayList;

/**
 * A class that represents a Student.
 */
public class Student {
    private String studentID;
    private String familyName;
    private String givenNames;
    protected String degree;
    private ArrayList<String> prizes;

    public Student(String studentID, String familyName, String givenNames) {
        this.studentID = studentID;
        this.familyName = familyName;
        this.givenNames = givenNames;
        this.degree = "Science";
        this.prizes = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getGivenNames() {
        return givenNames;
    }

    public void addPrize(String prize) {
        prizes.add(prize);
    }

    public String printResults() {
        return "Academic Record for " + givenNames + " " + familyName + " (" + studentID + ")\n"
                + "Degree: " + degree + "\n";
    }

}
