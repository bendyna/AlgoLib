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
}
