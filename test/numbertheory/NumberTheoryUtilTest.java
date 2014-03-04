/*
 * Filename: NumberTheoryUtilTest.java
 * Date: Jul 13, 2013 6:44:49 PM
 * Author: Bendyna Ivan
 */

package numbertheory;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Random;

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

    @Test
    public void testGcd() {
        assertEquals(10, NumberTheoryUtil.gcd(100, 30));
        assertEquals(1, NumberTheoryUtil.gcd(57, 5));
        assertEquals(1, NumberTheoryUtil.gcd(97, 300));
        assertEquals(6, NumberTheoryUtil.gcd(102, 36));
        assertEquals(1, NumberTheoryUtil.gcd(1, 6));
        assertEquals(1, NumberTheoryUtil.gcd(9, 1));
        assertEquals(1, NumberTheoryUtil.gcd(0, 1));
        assertEquals(1, NumberTheoryUtil.gcd(1, 0));
    }

    @Test
    public void testRandomGcd() {
        Random rand = new Random();
        for(int i = 0; i < 1000; i++) {
            int a = rand.nextInt(10000);
            int b = rand.nextInt(10000);
            if(a + b > 0) {
                int g = NumberTheoryUtil.gcd(a, b);
                assertEquals(0, a % g);
                assertEquals(0, b % g);
            }
        }
    }

    @Test
    public void testRandomGcdex() {
        Random rand = new Random();
        for(int i = 0; i < 10000; i++) {
            int a = rand.nextInt(10000);
            int b = rand.nextInt(10000);
            if(a + b > 0) {
                NumberTheoryUtil.GcdexResult gcdexResult = NumberTheoryUtil.gcdex(a, b);
                assertEquals(0, a % gcdexResult.gcd);
                assertEquals(0, b % gcdexResult.gcd);
                assertEquals(gcdexResult.gcd, gcdexResult.x * a +gcdexResult.y * b);
            }
        }
    }

    @Test
    public void testReverseModule() {
        assertEquals(1, NumberTheoryUtil.reverseModule(1, 2));
        assertEquals(2, NumberTheoryUtil.reverseModule(2, 3));
        assertEquals(-1, NumberTheoryUtil.reverseModule(2, 4));
    }

    @Test
    public void testRandomReverseModule() {
        Random rand = new Random();
        for(int i = 0; i < 10000; i++) {
            int m = rand.nextInt(10000) + 2;
            int a = rand.nextInt(m);
            int ra = NumberTheoryUtil.reverseModule(a, m);
            if(ra >= 0) {
                long la = a;
                la *= ra;
                la %= m;
                assertEquals(1, la);
            }
        }
    }

    @Test
    public void testBinomialCoefficient() {
        assertEquals(5, NumberTheoryUtil.getBinomialCoefficient(1, 5, 1000000007));
        assertEquals(1, NumberTheoryUtil.getBinomialCoefficient(0, 5, 1000000007));
        assertEquals(1, NumberTheoryUtil.getBinomialCoefficient(5, 5, 1000000007));
        assertEquals(1, NumberTheoryUtil.getBinomialCoefficient(1, 1, 1000000007));
        assertEquals(252, NumberTheoryUtil.getBinomialCoefficient(5, 10, 1000000007));
    }

    @Test
    public void testCombinationsWithRepetition() {
        assertEquals(5, NumberTheoryUtil.combinationsWithRepetition(1, 5, 1000000007));
        assertEquals(28, NumberTheoryUtil.combinationsWithRepetition(6, 3, 1000000007));
        assertEquals(5, NumberTheoryUtil.combinationsWithRepetition(4, 2, 1000000007));
        assertEquals(35, NumberTheoryUtil.combinationsWithRepetition(3, 5, 1000000007));
    }

    @Test
    public void testPrimeNumbers() {
        assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13}, NumberTheoryUtil.getPrimeNumbers(13));
        assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13}, NumberTheoryUtil.getPrimeNumbers(14));
        assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13}, NumberTheoryUtil.getPrimeNumbers(16));
        assertArrayEquals(new int[]{2, 3, 5, 7, 11, 13, 17}, NumberTheoryUtil.getPrimeNumbers(17));
        assertArrayEquals(new int[]{2, 3}, NumberTheoryUtil.getPrimeNumbers(3));
        assertArrayEquals(new int[]{2, 3}, NumberTheoryUtil.getPrimeNumbers(4));
        assertArrayEquals(new int[]{2, 3, 5}, NumberTheoryUtil.getPrimeNumbers(5));
    }
}
