import org.junit.After;
import org.junit.Test;
import org.sberatart.cities.utils.MyParser;

import static org.junit.Assert.assertEquals;

public class MyParserTest {
    @After
    public void testCompleted () {
        System.out.println("Test completed");
    }
    @Test
    public void testIntParsing () {
        assertEquals(MyParser.tryParseInt("292351"), 292351);
        assertEquals(MyParser.tryParseInt("152h322"), 152322);
        assertEquals(MyParser.tryParseInt("      555     asdb"), 555);
        assertEquals(MyParser.tryParseInt("999999999999999999"), 0);
    }
}
