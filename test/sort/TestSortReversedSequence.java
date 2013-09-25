package sort;/*
 * Date: 25.09.13 13:38
 * Author: ivan.bendyna
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertArrayEquals;

@RunWith(value = Parameterized.class)
public class TestSortReversedSequence extends TestSort{

    private final int SEQUENCE_LENGTH = 100;

    public TestSortReversedSequence(Sort sort) {
        super(sort);
    }

    @Test
    public void test() throws Exception {
        long[] array = new long[SEQUENCE_LENGTH];
        long[] expected = new long[SEQUENCE_LENGTH];
        for(int i = 0; i < SEQUENCE_LENGTH; i++){
            array[i] = SEQUENCE_LENGTH - i - 1;
            expected[i] = i;
        }
        sort.sort(array);

        assertArrayEquals(expected, array);
    }
}
