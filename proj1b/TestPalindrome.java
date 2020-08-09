import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        assertFalse(palindrome.isPalindrome("nothing"));
        assertTrue(palindrome.isPalindrome("ababa"));
    }
    @Test
    public void testIsPalindrome2(){
        assertFalse(palindrome.isPalindrome("nothing",offByOne));
        assertFalse(palindrome.isPalindrome("ababa",offByOne));
        assertTrue(palindrome.isPalindrome("flake",offByOne));
    }
}
