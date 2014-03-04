package fenwicktree;

public class FenwickTreeSumUpdateRange implements IFenwickTreeSumUpdateRange {

    private final int[] array;
    private final int[] add;
    private final int[] sum;

    public FenwickTreeSumUpdateRange(int n) {
        array = new int[n];
        add = new int[n];
        sum = new int[n];
    }

    @Override
    public void add(int left, int right, int value) {
        if(right < left) {
            throw new IllegalArgumentException();
        }
        add(right, value);
        add(left - 1, -value);
    }

    private void add(int right, int value) {
        if(right < 0) {
            return;
        }
        for(int i = right; i >= 0; i = (i & (i + 1)) - 1) {
            add[i] += value;
        }
        for(int i = right | (right + 1); i < array.length; i |= i + 1) {
            sum[i] += value * (right - (i & (i + 1)) + 1);
        }
    }

    @Override
    public int sum(int left, int right) {
        return sum(right) - sum(left - 1);
    }

    private int sum(int right) {
        if(right < 0) {
            return 0;
        }
        int res = 0;
        for(int i = right; i >= 0; i = (i & (i + 1)) - 1) {
            res += sum[i] + add[i] * (i - (i & (i + 1)) + 1);
        }
        for(int i = right | (right + 1); i < array.length; i |= i + 1) {
            res += add[i] * (right - (i & (i + 1)) + 1);
        }
        return res;
    }

}
