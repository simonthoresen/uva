import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class Main {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    @SuppressWarnings("UnusedParameters")
    public Main(InputStream in, PrintStream out) {
        throw new UnsupportedOperationException();
    }

    public static void assertOutput(Class problemClass, String input, String expected) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        problemClass.getConstructor(InputStream.class, PrintStream.class)
                    .newInstance(new ByteArrayInputStream(input.getBytes(UTF8)),
                                 new PrintStream(out));
        org.junit.Assert.assertEquals(expected, out.toString());
    }
}
