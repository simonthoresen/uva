import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Problem11650 {

    public Problem11650(InputStream ins, PrintStream out) {
        Scanner in = new Scanner(ins);
        int T = in.nextInt();
        for (int t = 0; t < T; ++t) {
            String str = in.next();
            int hour = Integer.valueOf(str.substring(0, 2));
            if (hour == 12) {
                hour = 0;
            }
            int minute = Integer.valueOf(str.substring(3, 5));

            hour = (12 * 60 - (hour * 60 + minute)) / 60;
            minute = 60 - minute;

            out.format("%02d:%02d\n", hour == 0 ? 12 : hour, minute == 60 ? 0 : minute);
        }
    }

    public static void main(String[] args) {
        new Main(System.in, System.out);
    }

    public static class TestCase {

        @org.junit.Test
        public void requireThatOutputMatches() throws Exception {
            Main.assertOutput("27\n" +
                              "11:59\n" +
                              "06:29\n" +
                              "01:15\n" +
                              "01:00\n" +
                              "02:00\n" +
                              "03:00\n" +
                              "04:00\n" +
                              "05:00\n" +
                              "06:00\n" +
                              "07:00\n" +
                              "08:00\n" +
                              "09:00\n" +
                              "10:00\n" +
                              "11:00\n" +
                              "12:00\n" +
                              "12:05\n" +
                              "12:10\n" +
                              "12:15\n" +
                              "12:20\n" +
                              "12:25\n" +
                              "12:30\n" +
                              "12:35\n" +
                              "12:40\n" +
                              "12:45\n" +
                              "12:50\n" +
                              "12:55\n" +
                              "10:09\n",

                              "10:59\n" +
                              "05:31\n" +
                              "10:45\n" +
                              "11:00\n" +
                              "10:00\n" +
                              "09:00\n" +
                              "08:00\n" +
                              "07:00\n" +
                              "06:00\n" +
                              "05:00\n" +
                              "04:00\n" +
                              "03:00\n" +
                              "02:00\n" +
                              "01:00\n" +
                              "12:00\n" +
                              "11:55\n" +
                              "11:50\n" +
                              "11:45\n" +
                              "11:40\n" +
                              "11:35\n" +
                              "11:30\n" +
                              "11:25\n" +
                              "11:20\n" +
                              "11:15\n" +
                              "11:10\n" +
                              "11:05\n" +
                              "01:51\n");
        }
    }
}
