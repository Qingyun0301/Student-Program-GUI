package studentdatabase;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDatabase {

    //create two arraylists to store students and topicResults
    public ArrayList<Student> studentDatabase;
    public ArrayList<Result> topicResults;

    public StudentDatabase() {
        studentDatabase = new ArrayList<>();
        topicResults = new ArrayList<>();
    }

    public Student findStudent(String studentID) {
        for (Student s : studentDatabase) {
            if (studentID.equals(s.getStudentID())) {
                return s;
            }
        }
        return null;
    }

    public Result findResult(String studentID, String topicCode) {
        //R,9821012,BIOL1000,HD,89
        for (Result r : topicResults) {
            if (studentID.equals(r.getStudentID())) {
                if (topicCode.equals(r.getTopic())) {
                    return r;
                }
            }
        }
        return null;
    }

    public void addStudent(String s) {
        Scanner vars = new Scanner(s);
        vars.useDelimiter(",");
        String studentType = vars.next();
        String studentID = vars.next();

        /*add student information into studentDatabase<> based on their type
         * A->Arts student
         * M->Med student
         * S->Science student
         */
        switch (studentType) {
            case "A":
                String aFamilyName = vars.next();
                String aGivenNames = vars.next();
                String artMajor = vars.next();
                String artMinor = vars.next();
                studentDatabase.add(new ArtsStudent(studentID, aFamilyName, aGivenNames, artMajor, artMinor));
                break;
            case "M":
                String mFamilyName = vars.next();
                String mGivenNames = vars.next();
                if (vars.hasNext()) {
                    String medPrize = vars.next();
                    studentDatabase.add(new MedStudent(studentID, mFamilyName, mGivenNames, medPrize));
                } else {
                    studentDatabase.add(new MedStudent(studentID, mFamilyName, mGivenNames));
                }


                break;
            case "S":
                String sFamilyName = vars.next();
                String sGivenNames = vars.next();
                studentDatabase.add(new Student(studentID, sFamilyName, sGivenNames));
                break;
            case "P":
                break;
            default:
        }
    }

    //add topic information into topicResults<>
    public void addResult(String s) {
        Scanner vars = new Scanner(s);
        vars.useDelimiter(",");
        vars.next();

        switch (s.charAt(0)) {
            case 'R' -> {
                String studentID = vars.next();
                String topic = vars.next();
                String grade = vars.next();
                String mark = "";
                if (vars.hasNext()) {
                    mark = vars.next();
                }
                topicResults.add(new Result(studentID, topic, grade, mark));
            }
        }
    }


    //use nested for loop, only print out the topic results when studentID matched
    public void printRecords() {
        for (Student s : studentDatabase) {
            System.out.print(s.printResults());
            for (Result r : topicResults) {
                if (s.getStudentID().equals(r.getStudentID())) {
                    System.out.println(r.printResults());
                }
            }
            System.out.print("\n");
        }

        //store the results to the record.txt and print them out
        String txt = "";
        for (Student s : studentDatabase) {
            txt += s.printResults();
            for (Result r : topicResults) {
                if (s.getStudentID().equals(r.getStudentID())) {
                    txt += r.printResults();
                }
            }
            txt += "\n";
        }

        try {
            FileWriter fw = new FileWriter("record.txt");
            fw.write(txt);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearRecords() {
        studentDatabase.clear();
        topicResults.clear();
    }
}
