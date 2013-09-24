package sort;/*
 * Date: 20.09.13 11:22
 * Author: ivan.bendyna
 */

public class HeapSort extends BaseSort{

    @Override
    public void sort(long[] array, boolean ascending, int from, int to) {
        if(to < from){
            throw new IllegalArgumentException();
        }
        heapify(array, !ascending, from, to);
        for(int i = to; i >= from + 1; i--){
            array[i] = extractPrioritized(array, !ascending, from, i);
        }
    }

    private void heapify(long[] array, boolean isMinHeap, int from, int to){
        if(to < from){
            throw new IllegalArgumentException();
        }
        for(int i = from + (to - from + 1)/2 - 1; i >= from; i--){
            sink(array, isMinHeap, from, to, i);
        }
    }

    private void sink(long[] array, boolean isMinHeap, int from, int to, int n){
        if(to < from || n < from || n > to){
            throw new IllegalArgumentException();
        }
        while(true){
            int left = child(from, to, n, true);
            int right = child(from, to, n, false);
            int prioritizedIndex = n;
            long prioritized = array[n];
            if(left >= 0 && ((isMinHeap && array[left] < prioritized) || (!isMinHeap && array[left] > prioritized))){
                prioritized = array[left];
                prioritizedIndex = left;
            }
            if(right >= 0 && ((isMinHeap && array[right] < prioritized) || (!isMinHeap && array[right] > prioritized))){
                prioritizedIndex = right;
            }
            if(prioritizedIndex != n){
                long t = array[n];
                array[n] = array[prioritizedIndex];
                array[prioritizedIndex] = t;
                n = prioritizedIndex;
            }
            else{
                break;
            }
        }
    }

    private long extractPrioritized(long[] array, boolean isMinHeap, int from, int to){
        if(to < from){
            throw new IllegalArgumentException();
        }
        long prioritized = array[from];
        array[from] = array[to];
        if(to > from){
            sink(array, isMinHeap, from, to - 1, from);
        }
        return prioritized;
    }

    private int child(int from, int to, int n, boolean isLeft){
        if(to < from || n < from || n > to){
            throw new IllegalArgumentException();
        }
        n = n - from + 1;
        n = 2 * n;
        if(!isLeft){
            n++;
        }
        n = n + from - 1;
        if(n > to){
            return -1;
        }
        else{
            return n;
        }
    }

    @Override
    public void sort(Object[] array, boolean ascending, int from, int to) {
        if(to < from){
            throw new IllegalArgumentException();
        }
        heapify(array, !ascending, from, to);
        for(int i = to; i >= from + 1; i--){
            array[i] = extractPrioritized(array, !ascending, from, i);
        }
    }

    private Object extractPrioritized(Object[] array, boolean isMinHeap, int from, int to){
        if(to < from){
            throw new IllegalArgumentException();
        }
        Object prioritized = array[from];
        array[from] = array[to];
        if(to > from){
            sink(array, isMinHeap, from, to - 1, from);
        }
        return prioritized;
    }

    @SuppressWarnings("unchecked")
    private void sink(Object[] array, boolean isMinHeap, int from, int to, int n){
        if(to < from || n < from || n > to){
            throw new IllegalArgumentException();
        }
        while(true){
            int left = child(from, to, n, true);
            int right = child(from, to, n, false);
            int prioritizedIndex = n;
            Object prioritized = array[n];
            if(left >= 0 && ((isMinHeap && ((Comparable)array[left]).compareTo(prioritized) < 0) || (!isMinHeap && ((Comparable)array[left]).compareTo(prioritized) > 0))){
                prioritized = array[left];
                prioritizedIndex = left;
            }
            if(right >= 0 && ((isMinHeap && ((Comparable)array[right]).compareTo(prioritized) < 0) || (!isMinHeap && ((Comparable)array[right]).compareTo(prioritized) > 0))){
                prioritizedIndex = right;
            }
            if(prioritizedIndex != n){
                Object t = array[n];
                array[n] = array[prioritizedIndex];
                array[prioritizedIndex] = t;
                n = prioritizedIndex;
            }
            else{
                break;
            }
        }
    }

    private void heapify(Object[] array, boolean isMinHeap, int from, int to){
        if(to < from){
            throw new IllegalArgumentException();
        }
        for(int i = from + (to - from + 1)/2 - 1; i >= from; i--){
            sink(array, isMinHeap, from, to, i);
        }
    }

    @Override
    public boolean isNlgN() {
        return true;
    }

    @Override
    public boolean isStable(){
        return false;
    }
}
