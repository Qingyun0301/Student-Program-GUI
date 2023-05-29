package studentdatabase;

/**
 * A class that represents a Student.
 */
public class Student {
    private String studentID;
    private String familyName;
    private String givenNames;
    protected String degree;



    public Student(String studentID, String familyName, String givenNames) {
        this.studentID = studentID;
        this.familyName = familyName;
        this.givenNames = givenNames;
        degree = "Science";
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

    public String printResults() {
        return "Academic Record for " + givenNames + " " + familyName + " (" + studentID + ")\n"
                + "Degree: " + degree + "\n";
    }
}
