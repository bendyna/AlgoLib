package sort;/*
 * Date: 06.09.13 13:19
 * Author: ivan.bendyna
 */

@SuppressWarnings("unused")
public interface Sort {
    public void sort(long[] array);
    public void sort(long[] array, int from, int to);
    public void sort(long[] array, boolean ascending);
    public void sort(long[] array, boolean ascending, int from, int to);

    public void sort(int[] array);
    public void sort(int[] array, int from, int to);
    public void sort(int[] array, boolean ascending);
    public void sort(int[] array, boolean ascending, int from, int to);

    public void sort(char[] array);
    public void sort(char[] array, int from, int to);
    public void sort(char[] array, boolean ascending);
    public void sort(char[] array, boolean ascending, int from, int to);

    public void sort(short[] array);
    public void sort(short[] array, int from, int to);
    public void sort(short[] array, boolean ascending);
    public void sort(short[] array, boolean ascending, int from, int to);

    public void sort(byte[] array);
    public void sort(byte[] array, int from, int to);
    public void sort(byte[] array, boolean ascending);
    public void sort(byte[] array, boolean ascending, int from, int to);

    public void sort(double[] array);
    public void sort(double[] array, int from, int to);
    public void sort(double[] array, boolean ascending);
    public void sort(double[] array, boolean ascending, int from, int to);

    public void sort(float[] array);
    public void sort(float[] array, int from, int to);
    public void sort(float[] array, boolean ascending);
    public void sort(float[] array, boolean ascending, int from, int to);

    public void sort(Object[] array);
    public void sort(Object[] array, int from, int to);
    public void sort(Object[] array, boolean ascending);
    public void sort(Object[] array, boolean ascending, int from, int to);
}
