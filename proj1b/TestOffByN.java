
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offByN = new OffByN(5);
    @Test
    public  void TestOffByNMethod(){
       assertTrue(offByN.equalChars('a','f'));
        assertTrue(offByN.equalChars('g','b'));
        assertFalse(offByN.equalChars('f','h'));

    }
}
