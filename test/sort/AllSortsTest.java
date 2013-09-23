package sort;/*
 * Date: 06.09.13 13:27
 * Author: ivan.bendyna
 */

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

//TODO: test stability of some sorts
//TODO: time tests
//TODO: tests for arrays with the same element
//TODO: tests for arrays with 2 different element
public class AllSortsTest {

    private final static int COUNT_RANDOM_TESTS = 10000;
    private final static int LENGTH_RANDOM_TESTS = 100;

    @Test
    public void testAll() throws Exception {
        Sort[] sorts = new Sort[]{new MergeSort(), new QuickSort(), new HeapSort(), new BubbleSort(), new InsertionSort()};
        for(Sort sort : sorts){
            testSort(sort);
        }
    }

    private void testSort(Sort sort) throws Exception {
        testEmpty(sort);
        testRandomLongArrays(sort);
        testRandomObjectArrays(sort);
    }

    private void testEmpty(Sort sort) throws Exception {
        //test for exceptions
        sort.sort(new long[]{});
    }

    private void testRandomLongArrays(Sort sort) throws Exception {
        Random rand = new Random();
        for(int i = 0; i < COUNT_RANDOM_TESTS; i++){
            long[] array = generateLongArray(rand);
            boolean ascending = rand.nextBoolean();
            int from = rand.nextInt(array.length);
            int to = rand.nextInt(array.length);
            if(to < from){
                int temp = from;
                from = to;
                to = temp;
            }
            sort.sort(array, ascending, from, to);
            assertTrue(checkArray(array, ascending, from, to));
        }
    }

    private void testRandomObjectArrays(Sort sort) throws Exception {
        Random rand = new Random();
        for(int i = 0; i < COUNT_RANDOM_TESTS; i++){
            String[] array = generateStringArray(rand);
            boolean ascending = rand.nextBoolean();
            sort.sort(array, ascending);
            assertTrue(checkArray(array, ascending));
        }
    }

    private long[] generateLongArray(Random rand){
        long[] array = new long[LENGTH_RANDOM_TESTS];
        for(int j = 0; j < array.length; j++){
            array[j] = rand.nextLong();
        }
        return array;
    }

    private String[] generateStringArray(Random rand){
        String[] array = new String[LENGTH_RANDOM_TESTS];
        for(int j = 0; j < array.length; j++){
            byte[] chars = new byte[rand.nextInt(10) + 5];
            for(int i = 0; i < chars.length; i++){
                chars[i] = (byte) ('A' + rand.nextInt('z' - 'A'));
            }
            array[j] = new String(chars);
        }
        return array;
    }

    private boolean checkArray(long[] array, boolean ascending ,int from, int to){
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

    private boolean checkArray(String[] array, boolean ascending){
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

}
