package sort;/*
 * Date: 06.09.13 14:08
 * Author: ivan.bendyna
 */

public abstract class BaseSort implements Sort {

    @Override
    public void sort(long[] array) {
        if(array.length > 0) {
            sort(array, true, 0, array.length - 1);
        }
    }

    @Override
    public void sort(long[] array, int from, int to) {
        if(array.length > 0) {
            sort(array, true, from, to);
        }
    }

    @Override
    public void sort(long[] array, boolean ascending) {
        if(array.length > 0) {
            sort(array, ascending, 0, array.length - 1);
        }
    }

    @Override
    public void sort(Object[] array) {
        if(array.length > 0) {
            sort(array, true, 0, array.length - 1);
        }
    }

    @Override
    public void sort(Object[] array, int from, int to) {
        if(array.length > 0) {
            sort(array, true, from, to);
        }
    }

    @Override
    public void sort(Object[] array, boolean ascending) {
        if(array.length > 0) {
            sort(array, ascending, 0, array.length - 1);
        }
    }
}
