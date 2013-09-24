package sort;/*
 * Date: 20.09.13 18:04
 * Author: ivan.bendyna
 */

import java.util.Arrays;

public class BubbleSort extends BaseSort {

    @Override
    public void sort(long[] array, boolean ascending, int from, int to) {
        for(int i = from; i < to; i++){
            for(int j = from; j < to - (i - from); j++){
                if((ascending && array[j] > array[j + 1]) || (!ascending && array[j] < array[j + 1])){
                    long t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort(Object[] array, boolean ascending, int from, int to) {
        for(int i = from; i < to; i++){
            for(int j = from; j < to - (i - from); j++){
                if((ascending && ((Comparable)array[j]).compareTo(array[j + 1]) > 0) || (!ascending && ((Comparable)array[j]).compareTo(array[j + 1]) < 0)){
                    Object t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
    }

    @Override
    public boolean isNlgN() {
        return false;
    }
}
