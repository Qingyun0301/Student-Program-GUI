package studentdatabase;

public class Result {
    String studentID;
    String topic;
    String grade;
    String mark;

    public String getStudentID() {
        return studentID;
    }
    public String getTopic() {
        return topic;
    }

    public String getGrade() {
        return grade;
    }

    public String getMark() {
        return mark;
    }

    public Result(String studentID, String topic, String grade, String mark) {
        this.studentID = studentID;
        this.topic = topic;
        this.grade = grade;
        this.mark = mark;
    }

    public String printResults() {
        return topic + " " + grade + " " + mark;
    }
}
