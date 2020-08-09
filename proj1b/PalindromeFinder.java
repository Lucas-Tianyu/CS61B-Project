/**
 * This class outputs all palindromes in the words file in the current directory.
 */
public class PalindromeFinder {

    public static void main(String[] args) {
        CharacterComparator offByOne = new OffByOne();
        int minLength = 4;
        In in = new In("words.txt");
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("OffByOne: ");

        In inOffByOne = new In("words.txt");
        while (!inOffByOne.isEmpty()) {
            String wordOffByOne = inOffByOne.readString();
            if (wordOffByOne.length() >= minLength && palindrome.isPalindrome(wordOffByOne, offByOne)) {
                System.out.println(wordOffByOne);
            }

        }


    }
}
