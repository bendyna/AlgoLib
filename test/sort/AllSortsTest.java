package sort;/*
 * Date: 06.09.13 13:27
 * Author: ivan.bendyna
 */

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

//TODO: test stability of some sorts
public class AllSortsTest {

    private final static int COUNT_RANDOM_TESTS = 1000;
    private final static int LENGTH_RANDOM_TESTS = 1000;

    @Test
    public void testAll() throws Exception {
        Sort[] sorts = new Sort[]{new MergeSort()};
        for(Sort sort : sorts){
            testSort(sort);
        }
    }

    private void testSort(Sort sort) throws Exception {
        testEmpty(sort);
        testRandomLongArrays(sort);
    }

    private void testEmpty(Sort sort) throws Exception {
        sort.sort(new int[]{});
    }

    private void testRandomLongArrays(Sort sort) throws Exception {
        Random rand = new Random();
        for(int i = 0; i < COUNT_RANDOM_TESTS; i++){
            long[] array = generateLongArray(rand);
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

    private boolean checkArray(long[] array, boolean ascending){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] == array[i + 1]) {
                continue;
            }
            if((array[i] < array[i + 1]) ^ ascending ){
                return false;
            }
        }
        return true;
    }

}
