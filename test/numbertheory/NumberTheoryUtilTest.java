/*
 * Filename: NumberTheoryUtilTest.java
 * Date: Jul 13, 2013 6:44:49 PM
 * Author: Bendyna Ivan
 */

package numbertheory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberTheoryUtilTest {

    @Test
    public void testCountDividers() throws Exception {
        for (int i = 1; i < 1000; i++) {
            assertEquals(countDividersNaive(i),
                            NumberTheoryUtil.countDividers(i));
        }
    }

    @Test(timeout = 1000)
    public void testTime() throws Exception {
        for (int i = 1; i <= 1000000; i++) {
            NumberTheoryUtil.countDividers(i);
        }
    }

    private int countDividersNaive(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                res++;
            }
        }
        return res;
    }
}
