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

    private final static int SEQUENCE_LENGTH = 100;

    public TestSortReversedSequence(Sort sort) {
        super(sort);
    }

    @Test
    public void test() throws Exception {
        long[] array = createReversedSequence(SEQUENCE_LENGTH);
        long[] expected = createSortedSequence(SEQUENCE_LENGTH);
        sort.sort(array);

        assertArrayEquals(expected, array);
    }
}
