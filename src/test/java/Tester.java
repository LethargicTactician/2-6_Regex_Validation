import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tester {
    private Controller input;
    String fakeHtml = "<html><p>test</p>\n<p>hello</p>\n<p>word</p>\n<p>welcome</p>\n<p>something</p>\n<p>another thing</p>\n</html>";
    String html = "<a href=\"site1.com\"></a>";
    String RepHtml = "<a href=\"site2.com\"></a>";

    @BeforeEach
    public void testSetup(){
        input = new Controller();



    }

    @Test
    public void test1(){
        assertTrue(input.isValidHumanName("Rosy"));
    }

    @Test
    public void test2() {
    assertTrue(input.isValidEmailAddress("hello@gmail.com"));
    }

        @Test
        public void test3 () {
        assertTrue(input.isValidPhoneNumber("442-258-7220"));

        }
        @Test
        public void test4 () {
        assertTrue(input.isValidSSN("123-45-6789"));

        }
        @Test
        public void test5 () {
        assertTrue(input.validatePasswordComplexity("Hell0wq$234&neum0nt",5,1,1,2,1));

        }

        @Test
        public void test6 () {
            assertFalse(input.isValidHumanName("R2-D2"));

        }

        @Test
        public void test7 () {
            assertFalse(input.isValidEmailAddress("ms.cardenasemail@email.com"));

        }

        @Test
        public void testhtml () {
           String[] expected = {"test", "hello", "word", "welcome", "something", "another thing"};
           assertArrayEquals(expected, input.getHTMLTagsContents(fakeHtml, "p"));

        }

        @Test
        public void testhtml2 () {

            String[] expected = {"site1.com"};
            assertArrayEquals(expected, input.getHTMLLinkURL(html));

        }

    @Test
    public void finalHtmltest () {

        String[] expected = {"site2.com"};
        assertArrayEquals(expected, input.getHTMLLinkURL(RepHtml));

    }

}
