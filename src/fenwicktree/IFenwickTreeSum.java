package fenwicktree;

public interface IFenwickTreeSum {
    void add(int index, int value);
    int sum(int left, int right);
}
