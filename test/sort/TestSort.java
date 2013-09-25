package sort;/*
 * Date: 24.09.13 14:42
 * Author: ivan.bendyna
 */

import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class TestSort {

    protected final Sort sort;

    public TestSort(Sort sort){
        this.sort = sort;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] sorts = new Object[][]{{new MergeSort()}, {new QuickSort(false)}, {new QuickSort(true)}, {new HeapSort()}, {new BubbleSort()}, {new InsertionSort()}};
        return Arrays.asList(sorts);
    }

    protected long[] generateLongArray(Random rand, int length){
        long[] array = new long[length];
        for(int j = 0; j < array.length; j++){
            array[j] = rand.nextLong();
        }
        return array;
    }

    protected String[] generateStringArray(Random rand, int length){
        String[] array = new String[length];
        for(int j = 0; j < array.length; j++){
            byte[] chars = new byte[rand.nextInt(10) + 5];
            for(int i = 0; i < chars.length; i++){
                chars[i] = (byte) ('A' + rand.nextInt('z' - 'A'));
            }
            array[j] = new String(chars);
        }
        return array;
    }

    protected boolean checkArray(long[] array, boolean ascending ,int from, int to){
        for(int i = from; i < to; i++){
            if(array[i] == array[i + 1]) {
                continue;
            }
            if((array[i] < array[i + 1]) ^ ascending ){
                return false;
            }
        }
        return true;
    }

    protected boolean checkArray(String[] array, boolean ascending){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i].equals(array[i + 1])) {
                continue;
            }
            if((array[i].compareTo(array[i + 1]) < 0) ^ ascending ){
                return false;
            }
        }
        return true;
    }

    protected long[] createReversedSequence(int length){
        long[] array = new long[length];
        for(int i = 0; i < length; i++){
            array[i] = length - i - 1;
        }
        return array;
    }

    protected long[] createSortedSequence(int length){
        long[] array = new long[length];
        for(int i = 0; i < length; i++){
            array[i] = i;
        }
        return array;
    }

    protected long[] createArrayOneElement(int length){
        return createArrayOneElement(length, 1);
    }

    protected long[] createArrayOneElement(int length, long element){
        long[] array = new long[length];
        for(int i = 0; i < length; i++){
            array[i] = element;
        }
        return array;
    }

    protected long[] generateArrayFewEquals(int length){
        return generateArrayFewEquals(length, 3);
    }

    protected long[] generateArrayFewEquals(int length, int count){
        Random rand = new Random();
        long[] array = new long[length];
        for(int i = 0; i < length; i++){
            array[i] = rand.nextInt(count);
        }
        return array;
    }
}
