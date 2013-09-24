package sort;/*
 * Date: 06.09.13 16:47
 * Author: ivan.bendyna
 */

import java.util.Random;

public class QuickSort extends BaseSort {

    private Random rand = new Random();

    private void swap(long[] array, int i, int j){
        if(i == j){
            return;
        }
        long t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private void swap(Object[] array, int i, int j){
        if(i == j){
            return;
        }
        Object t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    @Override
    public void sort(long[] array, boolean ascending, int from, int to) {
        if(to < from){
            throw new IllegalArgumentException();
        }
        int len = to - from + 1;
        while(len >= 2)
        {
            swap(array, from, from + rand.nextInt(len));
            int lt = from;
            int i = from + 1;
            int gt = to;
            while (i <= gt) {
                if(array[i] == array[lt]){
                    i++;
                } else if((array[i] < array[lt]) ^ !ascending){
                    swap(array, i, lt);
                    i++;
                    lt++;
                }
                else{
                    swap(array, i, gt);
                    gt--;
                }
            }
            int lengthLeft = lt - from;
            int lengthRight = to - gt;
            if(lengthLeft > lengthRight){
                if(gt < to){
                    sort(array, ascending, gt + 1, to);
                }
                to = lt - 1;
            }
            else{
                if(lt > from){
                    sort(array, ascending, from, lt - 1);
                }
                from = gt + 1;
            }
            len = to - from + 1;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort(Object[] array, boolean ascending, int from, int to) {
        if(to < from){
            throw new IllegalArgumentException();
        }
        int len = to - from + 1;
        while(len >= 2)
        {
            swap(array, from, from + rand.nextInt(len));
            int lt = from;
            int i = from + 1;
            int gt = to;
            while (i <= gt) {
                if(array[i] == array[lt]){
                    i++;
                } else if((((Comparable)array[i]).compareTo(array[lt]) < 0) ^ !ascending){
                    swap(array, i, lt);
                    i++;
                    lt++;
                }
                else{
                    swap(array, i, gt);
                    gt--;
                }
            }
            int lengthLeft = lt - from;
            int lengthRight = to - gt;
            if(lengthLeft > lengthRight){
                if(gt < to){
                    sort(array, ascending, gt + 1, to);
                }
                to = lt - 1;
            }
            else{
                if(lt > from){
                    sort(array, ascending, from, lt - 1);
                }
                from = gt + 1;
            }
            len = to - from + 1;
        }
    }
}
