package studentdatabase;

public class ArtsStudent extends Student {
    protected String major;
    protected String minor;

    public ArtsStudent(String studentID, String familyName, String givenNames, String artMajor, String artMinor) {
        super(studentID, familyName, givenNames);
        degree = "Arts";
        major = artMajor;
        minor = artMinor;
    }

    //override the printResults from its parent Student
    @Override
    public String printResults() {
        return super.printResults() + "Major: " + major + "\n" + "Minor: " + minor + "\n";
    }
}
