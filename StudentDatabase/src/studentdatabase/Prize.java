package studentdatabase;

import java.util.Scanner;

/**
 * A class to create a Prize and the means to award it.
 */
public class Prize {
    public String prize;
    public String topic;
    public String min;

    public Prize(String s) {
        Scanner vars = new Scanner(s);
        vars.useDelimiter(",");
        vars.next();

        if (s.charAt(0) == 'P') {
            this.prize = vars.next();
            this.topic = vars.next();
            this.min = vars.next();
        }
    }

    public void awardPrize(StudentDatabase sdb) {
        // sdb.awardPrize(prize, template, topicsRequired);
    }

}
