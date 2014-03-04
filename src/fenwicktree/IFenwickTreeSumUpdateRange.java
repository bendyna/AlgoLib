package fenwicktree;

public interface IFenwickTreeSumUpdateRange {
    void add(int left, int right, int value);
    int sum(int left, int right);
}
