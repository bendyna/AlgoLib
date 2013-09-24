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

//TODO: tests for arrays with the same element
//TODO: tests for arrays with 2 different element

@RunWith(value = Parameterized.class)
public class TestSortRandomArrays extends TestSort{

    private final static int COUNT_RANDOM_TESTS = 10000;
    private final static int LENGTH_RANDOM_TESTS = 100;

    public TestSortRandomArrays(Sort sort){
        super(sort);
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
}
