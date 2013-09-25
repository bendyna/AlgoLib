package sort;/*
 * Date: 24.09.13 14:38
 * Author: ivan.bendyna
 */

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;

@RunWith(value = Parameterized.class)
public class TestSortTime extends TestSort{

    private final static int LENGTH_TIME_TESTS = 100000;

    public TestSortTime(Sort sort){
        super(sort);
    }

    @Rule
    public Timeout globalTimeout = new Timeout(1000);

    @Test
    public void testTimeRandomArray() throws Exception{
        if(sort.isNlgN()){
            sort.sort(generateLongArray(new Random(), LENGTH_TIME_TESTS));
        }
    }

    @Test
    public void testTimeSortedArray() throws Exception {
        if(sort.isNlgN()){
            sort.sort(createSortedSequence(LENGTH_TIME_TESTS));
        }
    }

    @Test
    public void testTimeReverseSortedArray() throws Exception {
        if(sort.isNlgN()){
            sort.sort(createSortedSequence(LENGTH_TIME_TESTS), false);
        }
    }

    @Test
    public void testTimeArrayOneElement() throws Exception {
        if(sort.isNlgN()){
            sort.sort(createArrayOneElement(LENGTH_TIME_TESTS));
        }
    }

    @Test
    public void testTimeArrayFewEquals() throws Exception {
        if(sort.isNlgN()){
            sort.sort(generateArrayFewEquals(LENGTH_TIME_TESTS));
        }
    }
}