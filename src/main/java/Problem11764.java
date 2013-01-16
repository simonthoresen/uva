import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Problem11764 {

    public Problem11764(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; ++t) {
            int N = scanner.nextInt();
            int prev = scanner.nextInt();
            int numHigh = 0, numLow = 0;
            for (int n = 1; n < N; ++n) {
                int next = scanner.nextInt();
                if (prev < next) {
                    ++numHigh;
                } else if (prev > next) {
                    ++numLow;
                }
                prev = next;
            }
            out.println("Case " + t + ": " + numHigh + " " + numLow);
        }
    }

    public static void main(String[] args) {
        new Problem11764(System.in, System.out);
    }

    public static class TestCase {

        @org.junit.Test
        public void requireThatOutputMatches() throws Exception {
            Main.assertOutput(Problem11764.class,
                              "3\n" +
                              "8\n" +
                              "1 4 2 2 3 5 3 4\n" +
                              "1\n" +
                              "9\n" +
                              "5\n" +
                              "1 2 3 4 5",
                              "Case 1: 4 2\n" +
                              "Case 2: 0 0\n" +
                              "Case 3: 4 0\n");
        }
    }
}
