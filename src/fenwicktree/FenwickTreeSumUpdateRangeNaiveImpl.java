package fenwicktree;

public class FenwickTreeSumUpdateRangeNaiveImpl implements IFenwickTreeSumUpdateRange {

    private final int[] array;

    public FenwickTreeSumUpdateRangeNaiveImpl(int n) {
        array = new int[n];
    }

    @Override
    public void add(int left, int right, int value) {
        if(right < left) {
            throw new IllegalArgumentException();
        }
        for(int i = left; i <= right; i++) {
            array[i] += value;
        }
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
