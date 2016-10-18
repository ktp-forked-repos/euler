package problem070;

/**
 * Created by kiran on 7/20/16.

 Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of positive numbers less than or equal to n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, φ(9)=6.
 The number 1 is considered to be relatively prime to every positive number, so φ(1)=1.

 Interestingly, φ(87109)=79180, and it can be seen that 87109 is a permutation of 79180.

 Find the value of n, 1 < n < 107, for which φ(n) is a permutation of n and the ratio n/φ(n) produces a minimum.
 */
public class Problem070 {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        int minN = 0;
        float minRatio = 1_000_000;
        for (int n = 2; n < 10_000_000; n++) {
            int totient = totient(n);
            float ratio = (float)n / (float)totient;

            if (ratio < minRatio && isPermutation(n, totient)) {
                minRatio = ratio;
                minN = n;
            }
        }


        System.out.println(minN);

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }

    private static int totient(int n) {
        int totient = n;

        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                totient *= (1.0 - (1.0 / (float) p));

                while (n % p == 0) {
                    n /= p;
                }
            }
        }

        if (n > 1) {
            totient -= totient / n;
        }

        return totient;
    }

    private static boolean isPermutation(int a, int b) {

        if (Integer.toString(a).length() != Integer.toString(b).length()) {
            return false;
        }
        
        int[] digits = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        while (a > 0) {
            int digit = a % 10;
            digits[digit]++;
            a /= 10;
        }

        while (b > 0) {
            int digit = b % 10;
            digits[digit]--;
            b /= 10;
        }

        for (int digit : digits) {
            if (digit != 0) {
                return false;
            }
        }

        return true;
    }
}
// Answer: 8319823
