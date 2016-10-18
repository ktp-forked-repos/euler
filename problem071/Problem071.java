package problem071;

/**
 * Created by kiran on 7/20/16.
 *
 *
 * Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

 If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:

 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

 It can be seen that 2/5 is the fraction immediately to the left of 3/7.

 By listing the set of reduced proper fractions for d ≤ 1,000,000 in ascending order of size, find the numerator of the fraction immediately to the left of 3/7.
 */


public class Problem071 {
    public static void main(String[] args) {
        double largest = 0.1;
        int largestNumerator = 0;

        long startTime = System.currentTimeMillis();

        for (int den = 8; den <= 1_000_000; den++) {
            int num = (int)(den * largest);

            while ((double)(num + 1) / (double)den < 3.0 / 7.0) {
                num++;
                if (getGCD(num, den) != 1) continue;
                largestNumerator = num;
                largest = (double)num / (double)den;
            }
        }

        System.out.println(largestNumerator);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }

    private static int getGCD(int a, int b) {
        int d = 0;

        while (a % 2 == 0 && b % 2 == 0) {
            a /= 2;
            b /= 2;
            d++;
        }

        while (a != b) {
            if (a % 2 == 0) {
                a /= 2;
            } else if (b % 2 == 0) {
                b /= 2;
            } else if (a > b) {
                a = (a - b) / 2;
            } else {
                b = (b - a) / 2;
            }
        }

        return a * (int)Math.pow(2.0, d);
    }
}
// Answer: 428570