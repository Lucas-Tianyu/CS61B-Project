public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque<>();

        int len = word.length();
        for (int i = 0; i < len; i++) {
            result.addLast(word.charAt(i));
        }

        return result;
    }

    public boolean isPalindrome(String word) {
        int len = word.length();
        StringBuilder compare = new StringBuilder();
        Deque<Character> copy = wordToDeque(word);

        for (int i = 0; i < len; i++) {
            compare.append(copy.removeLast());
        }
        return compare.toString().equals(word);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int i=0;
        boolean result=true;
        int len=word.length();
        Deque<Character> copy = wordToDeque(word);

        while(i<len/2&& result){
            result=cc.equalChars(word.charAt(i),copy.removeLast());
            i++;
        }
        return result;

    }


}
