package sort;/*
 * Date: 06.09.13 13:56
 * Author: ivan.bendyna
 */

public class MergeSort extends BaseSort {

    @Override
    public void sort(long[] array, boolean ascending, int from, int to) {
        if(to < from){
            throw new IllegalArgumentException();
        }
        sortRecursive(array, ascending, from, to, new long[array.length]);
    }

    private void sortRecursive(long[] array, boolean ascending, int from, int to, long[] auxArray){
        int len = to - from + 1;
        if(len < 2){
            return;
        }
        int lastLeft = from + len / 2 - 1;
        sortRecursive(array, ascending, from, lastLeft, auxArray);
        sortRecursive(array, ascending, lastLeft + 1, to, auxArray);
        int L = from;
        int R = lastLeft + 1;
        int i = from;
        while(i <= to){
            if((R > to) ||
                    (( L <= lastLeft) &&
                            (((array[L] <= array[R]) && ascending) || ((array[L] >= array[R]) && !ascending)))){
                auxArray[i] = array[L];
                L++;
            }
            else{
                auxArray[i] = array[R];
                R++;
            }
            i++;
        }
        System.arraycopy(auxArray, from, array, from, len);
    }

    @Override
    public void sort(int[] array, boolean ascending, int from, int to) {
        if(to < from){
            throw new IllegalArgumentException();
        }
        sortRecursive(array, ascending, from, to, new int[array.length]);
    }

    private void sortRecursive(int[] array, boolean ascending, int from, int to, int[] auxArray){
        int len = to - from + 1;
        if(len < 2){
            return;
        }
        int lastLeft = from + len / 2 - 1;
        sortRecursive(array, ascending, from, lastLeft, auxArray);
        sortRecursive(array, ascending, lastLeft + 1, to, auxArray);
        int L = from;
        int R = lastLeft + 1;
        int i = from;
        while(i <= to){
            if((R > to) ||
                    (( L <= lastLeft) &&
                            (((array[L] <= array[R]) && ascending) || ((array[L] >= array[R]) && !ascending)))){
                auxArray[i] = array[L];
                L++;
            }
            else{
                auxArray[i] = array[R];
                R++;
            }
            i++;
        }
        System.arraycopy(auxArray, from, array, from, len);
    }

    @Override
    public void sort(char[] array, boolean ascending, int from, int to) {
        if(to < from){
            throw new IllegalArgumentException();
        }
        sortRecursive(array, ascending, from, to, new char[array.length]);
    }

    private void sortRecursive(char[] array, boolean ascending, int from, int to, char[] auxArray){
        int len = to - from + 1;
        if(len < 2){
            return;
        }
        int lastLeft = from + len / 2 - 1;
        sortRecursive(array, ascending, from, lastLeft, auxArray);
        sortRecursive(array, ascending, lastLeft + 1, to, auxArray);
        int L = from;
        int R = lastLeft + 1;
        int i = from;
        while(i <= to){
            if((R > to) ||
                    (( L <= lastLeft) &&
                            (((array[L] <= array[R]) && ascending) || ((array[L] >= array[R]) && !ascending)))){
                auxArray[i] = array[L];
                L++;
            }
            else{
                auxArray[i] = array[R];
                R++;
            }
            i++;
        }
        System.arraycopy(auxArray, from, array, from, len);
    }
    
    @Override
    public void sort(short[] array, boolean ascending, int from, int to) {
        if(to < from){
            throw new IllegalArgumentException();
        }
        sortRecursive(array, ascending, from, to, new short[array.length]);
    }

    private void sortRecursive(short[] array, boolean ascending, int from, int to, short[] auxArray){
        int len = to - from + 1;
        if(len < 2){
            return;
        }
        int lastLeft = from + len / 2 - 1;
        sortRecursive(array, ascending, from, lastLeft, auxArray);
        sortRecursive(array, ascending, lastLeft + 1, to, auxArray);
        int L = from;
        int R = lastLeft + 1;
        int i = from;
        while(i <= to){
            if((R > to) ||
                    (( L <= lastLeft) &&
                            (((array[L] <= array[R]) && ascending) || ((array[L] >= array[R]) && !ascending)))){
                auxArray[i] = array[L];
                L++;
            }
            else{
                auxArray[i] = array[R];
                R++;
            }
            i++;
        }
        System.arraycopy(auxArray, from, array, from, len);
    }
    
    @Override
    public void sort(byte[] array, boolean ascending, int from, int to) {
        if(to < from){
            throw new IllegalArgumentException();
        }
        sortRecursive(array, ascending, from, to, new byte[array.length]);
    }

    private void sortRecursive(byte[] array, boolean ascending, int from, int to, byte[] auxArray){
        int len = to - from + 1;
        if(len < 2){
            return;
        }
        int lastLeft = from + len / 2 - 1;
        sortRecursive(array, ascending, from, lastLeft, auxArray);
        sortRecursive(array, ascending, lastLeft + 1, to, auxArray);
        int L = from;
        int R = lastLeft + 1;
        int i = from;
        while(i <= to){
            if((R > to) ||
                    (( L <= lastLeft) &&
                            (((array[L] <= array[R]) && ascending) || ((array[L] >= array[R]) && !ascending)))){
                auxArray[i] = array[L];
                L++;
            }
            else{
                auxArray[i] = array[R];
                R++;
            }
            i++;
        }
        System.arraycopy(auxArray, from, array, from, len);
    }

    @Override
    public void sort(double[] array, boolean ascending, int from, int to) {
        if(to < from){
            throw new IllegalArgumentException();
        }
        sortRecursive(array, ascending, from, to, new double[array.length]);
    }

    private void sortRecursive(double[] array, boolean ascending, int from, int to, double[] auxArray){
        int len = to - from + 1;
        if(len < 2){
            return;
        }
        int lastLeft = from + len / 2 - 1;
        sortRecursive(array, ascending, from, lastLeft, auxArray);
        sortRecursive(array, ascending, lastLeft + 1, to, auxArray);
        int L = from;
        int R = lastLeft + 1;
        int i = from;
        while(i <= to){
            if((R > to) ||
                    (( L <= lastLeft) &&
                            (((array[L] <= array[R]) && ascending) || ((array[L] >= array[R]) && !ascending)))){
                auxArray[i] = array[L];
                L++;
            }
            else{
                auxArray[i] = array[R];
                R++;
            }
            i++;
        }
        System.arraycopy(auxArray, from, array, from, len);
    }

    @Override
    public void sort(float[] array, boolean ascending, int from, int to) {
        if(to < from){
            throw new IllegalArgumentException();
        }
        sortRecursive(array, ascending, from, to, new float[array.length]);
    }

    private void sortRecursive(float[] array, boolean ascending, int from, int to, float[] auxArray){
        int len = to - from + 1;
        if(len < 2){
            return;
        }
        int lastLeft = from + len / 2 - 1;
        sortRecursive(array, ascending, from, lastLeft, auxArray);
        sortRecursive(array, ascending, lastLeft + 1, to, auxArray);
        int L = from;
        int R = lastLeft + 1;
        int i = from;
        while(i <= to){
            if((R > to) ||
                    (( L <= lastLeft) &&
                            (((array[L] <= array[R]) && ascending) || ((array[L] >= array[R]) && !ascending)))){
                auxArray[i] = array[L];
                L++;
            }
            else{
                auxArray[i] = array[R];
                R++;
            }
            i++;
        }
        System.arraycopy(auxArray, from, array, from, len);
    }

    @Override
    public void sort(Object[] array, boolean ascending, int from, int to) {
        if(to < from){
            throw new IllegalArgumentException();
        }
        sortRecursive(array, ascending, from, to, new Object[array.length]);
    }

    @SuppressWarnings("unchecked")
    private void sortRecursive(Object[] array, boolean ascending, int from, int to, Object[] auxArray){
        int len = to - from + 1;
        if(len < 2){
            return;
        }
        int lastLeft = from + len / 2 - 1;
        sortRecursive(array, ascending, from, lastLeft, auxArray);
        sortRecursive(array, ascending, lastLeft + 1, to, auxArray);
        int L = from;
        int R = lastLeft + 1;
        int i = from;
        while(i <= to){
            if((R > to) ||
                    (( L <= lastLeft) &&
                            (((((Comparable)array[L]).compareTo(array[R]) <= 0) && ascending) ||
                                    ((((Comparable)array[L]).compareTo(array[R]) >= 0) && !ascending)))){
                auxArray[i] = array[L];
                L++;
            }
            else{
                auxArray[i] = array[R];
                R++;
            }
            i++;
        }
        System.arraycopy(auxArray, from, array, from, len);
    }
}
