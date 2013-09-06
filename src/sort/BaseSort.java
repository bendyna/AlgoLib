package sort;/*
 * Date: 06.09.13 14:08
 * Author: ivan.bendyna
 */

public abstract class BaseSort implements Sort {

    @Override
    public void sort(long[] array) {
        sort(array, true, 0, array.length - 1);
    }

    @Override
    public void sort(long[] array, int from, int to) {
        sort(array, true, from, to);
    }

    @Override
    public void sort(long[] array, boolean ascending) {
        sort(array, ascending, 0, array.length - 1);
    }

    @Override
    public void sort(int[] array) {
        sort(array, true, 0, array.length - 1);
    }

    @Override
    public void sort(int[] array, int from, int to) {
        sort(array, true, from, to);
    }

    @Override
    public void sort(int[] array, boolean ascending) {
        sort(array, ascending, 0, array.length - 1);
    }

    @Override
    public void sort(char[] array) {
        sort(array, true, 0, array.length - 1);
    }

    @Override
    public void sort(char[] array, int from, int to) {
        sort(array, true, from, to);
    }

    @Override
    public void sort(char[] array, boolean ascending) {
        sort(array, ascending, 0, array.length - 1);
    }

    @Override
    public void sort(short[] array) {
        sort(array, true, 0, array.length - 1);
    }

    @Override
    public void sort(short[] array, int from, int to) {
        sort(array, true, from, to);
    }

    @Override
    public void sort(short[] array, boolean ascending) {
        sort(array, ascending, 0, array.length - 1);
    }

    @Override
    public void sort(byte[] array) {
        sort(array, true, 0, array.length - 1);
    }

    @Override
    public void sort(byte[] array, int from, int to) {
        sort(array, true, from, to);
    }

    @Override
    public void sort(byte[] array, boolean ascending) {
        sort(array, ascending, 0, array.length - 1);
    }

    @Override
    public void sort(double[] array) {
        sort(array, true, 0, array.length - 1);
    }

    @Override
    public void sort(double[] array, int from, int to) {
        sort(array, true, from, to);
    }

    @Override
    public void sort(double[] array, boolean ascending) {
        sort(array, ascending, 0, array.length - 1);
    }

    @Override
    public void sort(float[] array) {
        sort(array, true, 0, array.length - 1);
    }

    @Override
    public void sort(float[] array, int from, int to) {
        sort(array, true, from, to);
    }

    @Override
    public void sort(float[] array, boolean ascending) {
        sort(array, ascending, 0, array.length - 1);
    }

    @Override
    public void sort(Object[] array) {
        sort(array, true, 0, array.length - 1);
    }

    @Override
    public void sort(Object[] array, int from, int to) {
        sort(array, true, from, to);
    }

    @Override
    public void sort(Object[] array, boolean ascending) {
        sort(array, ascending, 0, array.length - 1);
    }
}
