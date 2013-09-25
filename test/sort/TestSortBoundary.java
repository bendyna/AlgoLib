package sort;/*
 * Date: 24.09.13 15:38
 * Author: ivan.bendyna
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class TestSortBoundary extends TestSort {

    public TestSortBoundary(Sort sort) {
        super(sort);
    }

    @Test
    public void testEmptyArray() throws Exception {
        sort.sort(new long[]{});
    }
}
