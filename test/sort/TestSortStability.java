package sort;/*
 * Date: 24.09.13 12:50
 * Author: ivan.bendyna
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;

import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class TestSortStability extends TestSort {

    private final static int COUNT_TESTS = 1000;
    private final static int LENGTH_TESTS = 100;
    private final static int MAX_INT_VALUE = 10;

    public TestSortStability(Sort sort){
        super(sort);
    }

    @Test
    public void testStability() throws Exception {
        if(sort.isStable()){
            Random rand = new Random();
            for(int i = 1; i < COUNT_TESTS; i++){
                IndexedInteger array[] = new IndexedInteger[LENGTH_TESTS];
                for(int j = 0; j < LENGTH_TESTS; j++){
                    array[j] = new IndexedInteger(rand.nextInt(MAX_INT_VALUE) + 1, j + 1);
                }
                int from = rand.nextInt(LENGTH_TESTS);
                int to = rand.nextInt(LENGTH_TESTS);
                if(to < from){
                    int t = from;
                    from = to;
                    to = t;
                }
                boolean ascending = rand.nextBoolean();
                sort.sort(array, ascending, from, to);
                for(int j = from; j < to; j++){
                    if(array[j].value == array[j + 1].value){
                        assertTrue(array[j].index < array[j + 1].index);
                    }
                }
            }
        }
    }

    private class IndexedInteger implements Comparable<IndexedInteger>{
        private int value;
        private int index;

        IndexedInteger(int value, int index){
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(IndexedInteger o) {
            if(value < o.value){
                return -1;
            }
            if(value > o.value){
                return 1;
            }
            return 0;
        }
    }
}
