package sort;

/*
 * Date: 25.09.13 17:21
 * Author: ivan.bendyna
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class TestSortExceptions extends TestSort {

    public TestSortExceptions(Sort sort) {
        super(sort);
    }

    @Test(expected=NullPointerException.class)
    public void testNullArray() throws Exception {
        sort.sort((long[]) null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testToLessThanFrom() throws Exception {
        sort.sort(new long[2], 1, 0);
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testArrayIndexOutOfBounds() throws Exception {
        sort.sort(new long[2], 0, 2);
    }

    @Test(expected=ClassCastException.class)
    public void testWrongComparable() throws Exception {
        sort.sort(new Object[]{3, 4.5f});
    }
}
