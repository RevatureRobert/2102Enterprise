package ninjaexams;

import ninja.ChakraNature;
import ninja.models.Ninja;
import static org.junit.Assert.*;

import ninja.tools.Shuriken;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.Mock;
import org.mockito.Mockito;


public class NinjaExamsTest {


    // multiple asserts can sometimes be necessary
    // its called a code-test-smell when you have too many asserts

    @Test
    public void getHealthTest() {
        Ninja ninja = new Ninja(100);
        assertEquals(ninja.getHealth(), 100);
    }

    @Test
    public void getHealthTestIncorrect() {
        Ninja ninja = new Ninja(100);
        assertNotEquals(80, ninja.getHealth());
    }

    @Test
    public void setHealthTest() {
        Ninja ninja = new Ninja(10);
        ninja.setHealth(100);
        assertEquals(ninja.getHealth(), 100);
    }

    @Test
    public void canIYeetItTest(){
        Shuriken shurikenMock = Mockito.mock(Shuriken.class);
        Mockito.when(shurikenMock.yeet()).thenReturn("Mockyeeto");
        Ninja ninja = new Ninja(shurikenMock);
        assertEquals(ninja.attack(), "Mockyeeto");
    }
}
