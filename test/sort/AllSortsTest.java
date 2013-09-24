package sort;/*
 * Date: 06.09.13 13:27
 * Author: ivan.bendyna
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.assertTrue;

//TODO: test stability of some sorts
//TODO: time tests
//TODO: tests for arrays with the same element
//TODO: tests for arrays with 2 different element

@RunWith(value = Parameterized.class)
public class AllSortsTest {

    private final static int COUNT_RANDOM_TESTS = 10000;
    private final static int LENGTH_RANDOM_TESTS = 100;
    private final static int LENGTH_TIME_TESTS = 100000;

    private Sort sort;

    public AllSortsTest(Sort sort){
        this.sort = sort;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] sorts = new Object[][]{{new MergeSort()}, {new QuickSort(false)}, {new QuickSort(true)}, {new HeapSort()}, {new BubbleSort()}, {new InsertionSort()}};
        return Arrays.asList(sorts);
    }

    @Test
    public void testEmptyArrays() throws Exception {
        //test for exceptions
        sort.sort(new long[]{});
    }

    @Test
    public void testRandomLongArrays() throws Exception {
        Random rand = new Random();
        for(int i = 0; i < COUNT_RANDOM_TESTS; i++){
            long[] array = generateLongArray(rand, LENGTH_RANDOM_TESTS);
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

    @Test
    public void testRandomLongObject() throws Exception {
        Random rand = new Random();
        for(int i = 0; i < COUNT_RANDOM_TESTS; i++){
            String[] array = generateStringArray(rand, LENGTH_RANDOM_TESTS);
            boolean ascending = rand.nextBoolean();
            sort.sort(array, ascending);
            assertTrue(checkArray(array, ascending));
        }
    }

    @Test(timeout = 1000)
    public void testTimeRandomArray() throws Exception {
        Random rand = new Random();
        if(sort.isNlgN()){
            sort.sort(generateLongArray(rand, LENGTH_TIME_TESTS));
        }
    }

    @Test(timeout = 1000)
    public void testTimeSortedArray() throws Exception {
        if(sort.isNlgN()){
            sort.sort(createSortedArray());
        }
    }

    @Test(timeout = 1000)
    public void testTimeReverseSortedArray() throws Exception {
        if(sort.isNlgN()){
            sort.sort(createSortedArray(), false);
        }
    }

    private long[] createSortedArray(){
        long[] array = new long[LENGTH_TIME_TESTS];
        for(int i = 0; i < LENGTH_TIME_TESTS; i++){
            array[i] = i;
        }
        return array;
    }

    private long[] generateLongArray(Random rand, int length){
        long[] array = new long[length];
        for(int j = 0; j < array.length; j++){
            array[j] = rand.nextLong();
        }
        return array;
    }

    private String[] generateStringArray(Random rand, int length){
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
