import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Problem556 {

    public Problem556(InputStream ins, PrintStream out) {
        Scanner in = new Scanner(ins);

    }

    public static void main(String[] args) {
        new Main(System.in, System.out);
    }

    public static class TestCase {

        @org.junit.Test
        public void requireThatOutputMatches() throws Exception {
            Main.assertOutput("3 5\n" +
                              "01010\n" +
                              "01010\n" +
                              "00000\n" +
                              "0 0",
                              "2  3  5  1  0\n");
        }
    }
}
