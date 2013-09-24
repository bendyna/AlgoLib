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

    public void sort(Object[] array);
    public void sort(Object[] array, int from, int to);
    public void sort(Object[] array, boolean ascending);
    public void sort(Object[] array, boolean ascending, int from, int to);

    public boolean isNlgN();
}
