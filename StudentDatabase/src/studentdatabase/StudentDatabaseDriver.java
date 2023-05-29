package studentdatabase;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StudentDatabaseDriver {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a file name to process: "); //StudentDB/StudentDatabase/data/testFile.txt
        String fileName = scan.nextLine().trim();
        Scanner fileReader = new Scanner(new File(fileName));

        String s;
        int prizeCount = 0;
        StudentDatabase studentDB = new StudentDatabase();
        Prize[] prizeList = new Prize[10];
        while (fileReader.hasNextLine()) {
            s = fileReader.nextLine();
            if (s.length() > 0)
                switch (s.charAt(0)) { //
                    case 'A', 'M', 'S' -> studentDB.addStudent(s);

                    case 'R' -> studentDB.addResult(s);

                    case 'P' -> prizeList[prizeCount++] = new Prize(s);

                    default -> {
                    }
                }
        }
//        for (int i = 0; i < prizeCount; i++)
//            prizeList[i].awardPrize(studentDB);


        studentDB.printRecords();

    }
}
