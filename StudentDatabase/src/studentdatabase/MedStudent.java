package studentdatabase;

import java.util.ArrayList;

public class MedStudent extends Student {
    protected String prize;

    public String getPrize() {
        return prize;
    }

    public MedStudent(String studentID, String familyName, String givenNames) {
        super(studentID, familyName, givenNames);
        degree = "Medicine";
    }
    public MedStudent(String studentID, String familyName, String givenNames, String medPrize) {
        super(studentID, familyName, givenNames);
        degree = "Medicine";
        prize = medPrize;
    }

    public double calculateAverageMark(ArrayList<String> matchingTopics, StudentDatabase sdb) {
        int totalMarks = 0;
        int count = 0;

        for (Result result : sdb.topicResults) {
            if (matchingTopics.contains(result.getTopic()) && result.getStudentID().equals(getStudentID())) {
                totalMarks += Integer.parseInt(result.getMark());
                count++;
            }
        }
        if (count > 0) {
            return (double) totalMarks / count;
        } else {
            return 0.0;
        }
    }


    //override the printResults from its parent Student
    @Override
    public String printResults() {
        return super.printResults() + "Prize: " + prize + "\n";
    }
}
