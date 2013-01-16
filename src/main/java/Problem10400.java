import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Problem10400 {

    public Problem10400(InputStream ins, PrintStream out) {
        Scanner in = new Scanner(ins);
        int N = in.nextInt();
        for (int n = 0; n < N; ++n) {
            int P = in.nextInt();
            int[] arr = new int[P];
            for (int p = 0; p < P; ++p) {
                arr[p] = in.nextInt();
            }


            out.println("NO EXPRESSION");

        }

    }

    public static void main(String[] args) {
        new Main(System.in, System.out);
    }

    public static class TestCase {

        @org.junit.Test
        public void requireThatOutputMatches() throws Exception {
            Main.assertOutput("3\n" +
                              "3 5 7 4 3\n" +
                              "2 1 1 2000\n" +
                              "5 12 2 5 1 2 4",
                              "5+7/4=3\n" +
                              "NO EXPRESSION\n" +
                              "12-2/5*1*2=4\n");
        }
    }
}
