import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem305 {

    private static int[] M = { 0, 2, 7, 5, 30, 169, 441, 1872, 7632, 1740, 93313, 459901, 1358657, 2504881 };

    public Problem305(InputStream ins, PrintStream out) {
        Scanner in = new Scanner(ins);
        while (true) {
            int k = in.nextInt();
            if (k == 0) {
                break;
            }
            out.println(M[k]);
        }
    }

    public static void main(String[] args) {
        new Main(System.in, System.out);
    }

    private static class PreCalc {

        public static void main(String[] args) {
            StringBuilder out = new StringBuilder();
            for (int k = 1; k < 14; ++k) {
                List<Boolean> guys = new ArrayList<Boolean>();
                for (int i = 0; i < k; ++i) {
                    guys.add(true);
                }
                for (int i = 0; i < k; ++i) {
                    guys.add(false);
                }
                for (int m = k + 1; m < Integer.MAX_VALUE; ++m) {
                    List<Boolean> alive = new ArrayList<Boolean>(guys);
                    int numBad = k;
                    int i = m - 1;
                    while (true) {
                        i = i % alive.size();
                        boolean guy = alive.remove(i);
                        if (guy) {
                            break;
                        }
                        --numBad;
                        i = i - 1 + m;
                    }
                    if (numBad == 0) {
                        out.append(m).append(", ");
                        break;
                    }
                }
            }
            System.err.println(out);
        }
    }

    public static class TestCase {

        @org.junit.Test
        public void requireThatOutputMatches() throws Exception {
            Main.assertOutput("3\n" +
                              "4\n" +
                              "0",
                              "5\n" +
                              "30\n");
        }
    }
}
