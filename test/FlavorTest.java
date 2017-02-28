import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FlavorTest {
    private FlavorWheelParser parser;

    @Before
    public void initialize()  throws Exception {
        parser = new FlavorWheelParser();
        parser.parseWheelInput();
    }

    @Test
    public void simpleTest(){
        List<List<String>> result = Flavor.parseTastingNote("bitter");
        assertEquals(1, result.size());
        List<String> stringList = result.get(0);
        assertEquals(3, stringList.size());
        assertEquals("Bitter", stringList.get(0));
        assertEquals("Chemical", stringList.get(1));
        assertEquals("Other", stringList.get(2));
    }

    @Test
    public void compositeTest(){
        List<List<String>> result = Flavor.parseTastingNote("dark chocolate");
        assertEquals(1, result.size());
        List<String> stringList = result.get(0);
        assertEquals(3, stringList.size());
        assertEquals("Dark Chocolate", stringList.get(0));
        assertEquals("Cocoa", stringList.get(1));
        assertEquals("Nutty/Cocoa", stringList.get(2));
    }

    @Test
    public void noMatchTest(){
        List<List<String>> result = Flavor.parseTastingNote("nothing here");
        assertEquals(0, result.size());
    }

    @Test
    public void exampleTest(){
        List<List<String>> result = Flavor.parseTastingNote("An excellent cup of coffee. Notes of stone fruit, cherry and plum. Long finish with hints of milk chocolate and brown sugar");
        assertEquals(3, result.size());
        List<String> stringList = result.get(0);
        assertEquals(3, stringList.size());
        assertEquals("Cherry", stringList.get(0));
        assertEquals("Other Fruit", stringList.get(1));
        assertEquals("Fruity", stringList.get(2));
        stringList = result.get(1);
        assertEquals(3, stringList.size());
        assertEquals("Chocolate", stringList.get(0));
        assertEquals("Cocoa", stringList.get(1));
        assertEquals("Nutty/Cocoa", stringList.get(2));
        stringList = result.get(2);
        assertEquals(2, stringList.size());
        assertEquals("Brown Sugar", stringList.get(0));
        assertEquals("Sweet", stringList.get(1));
    }

}
