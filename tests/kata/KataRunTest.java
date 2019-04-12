package kata;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kata.KataRun;

public class KataRunTest {

    protected KataRun kr;

    @Before
    public void setUp() throws Exception {
        kr = new KataRun();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void browseNumber() {
        // Retrieve outputStream
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        kr.browseNumber();

        // Tokens, missing apache.commons libs
        String[] tokens = os.toString().split(System.getProperty("line.separator"));
        // Is length ok ?
        assertEquals(100, tokens.length);
        // Given examples
        givenExample(tokens);
        // Updated rules
        updatedRules(tokens);

        // Restore normal output
        PrintStream originalOut = System.out;
        System.setOut(originalOut);
    }

    private void updatedRules(String[] tokens) {
        assertEquals("FooBar", tokens[50]);
        assertEquals("BarFoo", tokens[52]);
        assertEquals("FooQix", tokens[20]);
        assertEquals("Foo", tokens[12]);
        assertEquals("FooBarBar", tokens[14]);
        assertEquals("FooFooFoo", tokens[32]);
    }

    private void givenExample(String[] tokens) {
        assertEquals("1", tokens[0]);
        assertEquals("2", tokens[1]);
        assertEquals("FooFoo", tokens[2]);
        assertEquals("4", tokens[3]);
        assertEquals("BarBar", tokens[4]);
        assertEquals("Foo", tokens[5]);
        assertEquals("QixQix", tokens[6]);
        assertEquals("8", tokens[7]);
        assertEquals("Foo", tokens[8]);
        assertEquals("Bar", tokens[9]);
        // 99 and 100
        assertEquals("Foo", tokens[98]);
        assertEquals("Bar", tokens[99]);
    }
}
