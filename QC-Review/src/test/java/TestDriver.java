import ninja.models.Ninja;
import ninja.tools.Shuriken;
import org.mockito.Mockito;

public class TestDriver {
    public static void main(String[] args) {
        Shuriken shuriken = Mockito.mock(Shuriken.class);

        System.out.println(shuriken);
    }
}
