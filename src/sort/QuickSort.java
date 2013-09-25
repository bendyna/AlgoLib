package sort;/*
 * Date: 06.09.13 16:47
 * Author: ivan.bendyna
 */

import java.util.Random;

public class QuickSort extends BaseSort {

    private final Random rand = new Random();
    private final boolean isStable;

    public QuickSort(boolean isStable){
        this.isStable = isStable;
    }

    private void swap(long[] array, int[] order, int i, int j){
        if(i == j){
            return;
        }
        long t = array[i];
        array[i] = array[j];
        array[j] = t;
        if(order != null){
            int p = order[i];
            order[i] = order[j];
            order[j] = p;
        }
    }

    private void swap(Object[] array, int[] order, int i, int j){
        if(i == j){
            return;
        }
        Object t = array[i];
        array[i] = array[j];
        array[j] = t;
        if(order != null){
            int p = order[i];
            order[i] = order[j];
            order[j] = p;
        }
    }

    private int compare(long[] array, int[] order, int i, int j){
        if(array[i] < array[j]) {
            return -1;
        }
        if(array[i] > array[j]) {
            return 1;
        }
        if(order != null){
            if(order[i] < order[j]) {
                return -2;
            }
            if(order[i] > order[j]) {
                return 2;
            }
        }
        return 0;
    }

    @SuppressWarnings("unchecked")
    private int compare(Object[] array, int[] order, int i, int j){
        int c = ((Comparable)array[i]).compareTo(array[j]);
        if(c < 0) {
            return -1;
        }
        if(c > 0) {
            return 1;
        }
        if(order != null){
            if(order[i] < order[j]) {
                return -2;
            }
            if(order[i] > order[j]) {
                return 2;
            }
        }
        return 0;
    }

    @Override
    public void sort(long[] array, boolean ascending, int from, int to) {
        if(isStable){
            int[] order = new int[array.length];
            for(int i = 0; i < order.length; i++){
                order[i] = i;
            }
            sort(array, order, ascending, from, to);
        }
        else{
            sort(array, null, ascending, from, to);
        }
    }

    private void sort(long[] array, int[] order, boolean ascending, int from, int to){
        if(to < from){
            throw new IllegalArgumentException();
        }
        int len = to - from + 1;
        while(len >= 2)
        {
            swap(array, order, from, from + rand.nextInt(len));
            int lt = from;
            int i = from + 1;
            int gt = to;
            while (i <= gt) {
                int c = compare(array, order, i, lt);
                if(c == 0){
                    i++;
                } else if((c == -2)|| (c == -1 && ascending) || (c == 1 && !ascending)){
                    swap(array, order, i, lt);
                    i++;
                    lt++;
                }
                else{
                    swap(array, order, i, gt);
                    gt--;
                }
            }
            int lengthLeft = lt - from;
            int lengthRight = to - gt;
            if(lengthLeft > lengthRight){
                if(gt < to){
                    sort(array, order, ascending, gt + 1, to);
                }
                to = lt - 1;
            }
            else{
                if(lt > from){
                    sort(array, order, ascending, from, lt - 1);
                }
                from = gt + 1;
            }
            len = to - from + 1;
        }
    }

    @Override

    public void sort(Object[] array, boolean ascending, int from, int to) {
        if(isStable){
            int[] order = new int[array.length];
            for(int i = 0; i < order.length; i++){
                order[i] = i;
            }
            sort(array, order, ascending, from, to);
        }
        else{
            sort(array, null, ascending, from, to);
        }
    }

    private void sort(Object[] array, int[] order, boolean ascending, int from, int to){
        if(to < from){
            throw new IllegalArgumentException();
        }
        int len = to - from + 1;
        while(len >= 2)
        {
            swap(array, order, from, from + rand.nextInt(len));
            int lt = from;
            int i = from + 1;
            int gt = to;
            while (i <= gt) {
                int c = compare(array, order, i, lt);
                if(c == 0){
                    i++;
                } else if((c == -2)|| (c == -1 && ascending) || (c == 1 && !ascending)){
                    swap(array, order, i, lt);
                    i++;
                    lt++;
                }
                else{
                    swap(array, order, i, gt);
                    gt--;
                }
            }
            int lengthLeft = lt - from;
            int lengthRight = to - gt;
            if(lengthLeft > lengthRight){
                if(gt < to){
                    sort(array, order, ascending, gt + 1, to);
                }
                to = lt - 1;
            }
            else{
                if(lt > from){
                    sort(array, order, ascending, from, lt - 1);
                }
                from = gt + 1;
            }
            len = to - from + 1;
        }
    }

    @Override
    public boolean isNlgN() {
        return true;
    }

    @Override
    public boolean isStable(){
        return isStable;
    }
}
