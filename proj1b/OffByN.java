public class OffByN implements CharacterComparator {
    private int OffBy;

    public  OffByN(int N) {
        OffBy = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == OffBy;
    }
}
