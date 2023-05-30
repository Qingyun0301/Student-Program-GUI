package studentdatabase;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class to create a Prize and the means to award it.
 */
public class Prize {
    public String prize;
    public String topic;
    public String minTopics;

    public Prize(String s) {
        Scanner vars = new Scanner(s);
        vars.useDelimiter(",");
        vars.next();

        if (s.charAt(0) == 'P') {
            this.prize = vars.next();
            this.topic = vars.next();
            this.minTopics = vars.next();
        }
    }


    public void awardPrize(StudentDatabase sdb) {
        ArrayList<String> matchingTopics = new ArrayList<>();
        for (Result result : sdb.topicResults) {
            if (result.getTopic().startsWith(topic)) {
                matchingTopics.add(result.getTopic());
            }
        }

        if (matchingTopics.size() >= Integer.parseInt(minTopics)) {
            double highestAverage = 0.0;
            MedStudent prizeWinner = null;

            for (Student student : sdb.studentDatabase) {
                if (student instanceof MedStudent medStudent) {
                    double average = medStudent.calculateAverageMark(matchingTopics, sdb);
                    if (average > highestAverage) {
                        highestAverage = average;
                        prizeWinner = medStudent;
                    }
                }
            }

            if (prizeWinner != null) {
                prizeWinner.addPrize(prize);
            }
        }
    }
}
