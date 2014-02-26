/*
 * Filename: NumberTheoryUtil.java
 * Date: Jul 13, 2013 6:36:08 PM
 * Author: Bendyna Ivan
 */

package numbertheory;

public class NumberTheoryUtil {

    // count different dividers including 1 and N
    public static int countDividers(int N) {
        int res = 1;
        while (N % 2 == 0) {
            res++;
            N = N / 2;
        }
        int i = 3;
        while (N > 1) {
            while (N % i > 0 && i * i <= N) {
                i = i + 2;
            }
            if (N % i == 0) {
                int p = 1;
                while (N % i == 0) {
                    p++;
                    N = N / i;
                }
                res = res * p;
            }
            else {
                res = res * 2;
                N = 1;
            }
        }
        return res;
    }

    public static int gcd(int a, int b) {
        if((a == 0 && b == 0) || a < 0 || b < 0) {
            throw new IllegalArgumentException();
        }
        if(a < b) {
            return gcd(b, a);
        }
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static class GcdexResult {
        //ax + by = gcd

        public int gcd;
        public long x;
        public long y;

        public GcdexResult(int gcd, int x, int y) {
            this.gcd = gcd;
            this.x = x;
            this.y = y;
        }
    }

    @SuppressWarnings("SuspiciousNameCombination")
    public static GcdexResult gcdex(int a, int b) {
        if(a < b) {
            GcdexResult res = gcdex(b, a);
            long tx = res.x;
            res.x = res.y;
            res.y = tx;
            return res;
        }
        if(b == 0) {
            return new GcdexResult(a, 1, 0);
        }
        int r = a % b;
        int c = a / b;

        GcdexResult res = gcdex(b, r);
        long tx = res.x;
        res.x = res.y;
        res.y = tx - c * res.y;
        return res;
    }

    // -1 - no solution
    public static int reverseModule(int a, int m) {
        GcdexResult gcdexResult = gcdex(a, m);
        if(gcdexResult.gcd != 1) {
            return -1;
        }
        long x = gcdexResult.x;
        x = ((x % m) + m) % m;
        return (int) x;
    }
}
