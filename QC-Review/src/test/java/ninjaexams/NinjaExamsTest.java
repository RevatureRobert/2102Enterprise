package ninjaexams;

import ninja.ChakraNature;
import ninja.models.Ninja;
import static org.junit.Assert.*;
import org.junit.Test;


public class NinjaExamsTest {

    @Test
    public void getHealthTest() {
        Ninja ninja = new Ninja(100);
        assertEquals(ninja.getHealth(), 100);
        assertNotEquals(80, ninja.getHealth());
    }

    @Test
    public void setHealthTest() {
        Ninja ninja = new Ninja(10);
        ninja.setHealth(100);
        assertEquals(ninja.getHealth(), 100);
    }
}
