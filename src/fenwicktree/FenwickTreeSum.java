package fenwicktree;

public class FenwickTreeSum implements IFenwickTreeSum {

    private final int[] array;

    public FenwickTreeSum(int n) {
        array = new int[n];
    }

    @Override
    public void add(int index, int value) {
        for (int i = index; i < array.length; i = (i | (i+1))) {
            array[i] += value;
        }
    }

    @Override
    public int sum(int left, int right) {
        return sum(right) - sum(left - 1);
    }

    private int sum(int right) {
        int res = 0;
        for(int i = right; i >= 0; i = (i & (i+1)) - 1) {
            res += array[i];
        }
        return res;
    }
}
