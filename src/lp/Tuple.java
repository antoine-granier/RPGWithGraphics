package lp;

public record Tuple(int i, int j) {
    public Tuple moveTo(int x, int y) {
        return new Tuple(x, y);
    }
}
