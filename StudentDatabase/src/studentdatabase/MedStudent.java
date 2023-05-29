package studentdatabase;

public class MedStudent extends Student {
    protected String prize;

    public MedStudent(String studentID, String familyName, String givenNames, String medPrize) {
        super(studentID, familyName, givenNames);
        degree = "Medicine";
        prize = medPrize;
    }

    //override the printResults from its parent Student
    @Override
    public String printResults() {
        return super.printResults() + "Prize: " + prize + "\n";
    }
}
