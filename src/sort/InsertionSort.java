package sort;/*
 * Date: 23.09.13 12:44
 * Author: ivan.bendyna
 */

public class InsertionSort extends BaseSort {

    @Override
    public void sort(long[] array, boolean ascending, int from, int to) {
        for(int i = from + 1; i <= to; i++){
            long v = array[i];
            int j = i;
            while(j > from && ((ascending && v < array[j - 1]) || (!ascending && v > array[j - 1]))){
                array[j] = array[j - 1];
                j--;
            }
            array[j] = v;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort(Object[] array, boolean ascending, int from, int to) {
        for(int i = from + 1; i <= to; i++){
            Object v = array[i];
            int j = i;
            while(j > from && ((ascending && ((Comparable)v).compareTo(array[j - 1]) < 0) || (!ascending && ((Comparable)v).compareTo(array[j - 1]) > 0))){
                array[j] = array[j - 1];
                j--;
            }
            array[j] = v;
        }
    }

    @Override
    public boolean isNlgN() {
        return false;
    }

    @Override
    public boolean isStable(){
        return true;
    }
}
