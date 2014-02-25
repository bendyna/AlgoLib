package fenwicktree;

public class FenwickTreeSumNaiveImpl implements IFenwickTreeSum {

    private final int[] array;

    public FenwickTreeSumNaiveImpl(int n) {
        array = new int[n];
    }

    @Override
    public void add(int index, int value) {
        array[index] += value;
    }

    @Override
    public int sum(int left, int right) {
        int res = 0;
        for(int i = left; i <= right; i++) {
            res += array[i];
        }
        return res;
    }
}
