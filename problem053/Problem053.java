package problem053;

import java.math.BigDecimal;

/**
 * Created by kiran on 1/25/16.
 *
 * There are exactly ten ways of selecting three from five, 12345:

 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345

 In combinatorics, we use the notation, 5C3 = 10.

 In general,

 nCr =
 n!
 r!(n−r)!
 ,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
 It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.

 How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?
 */
public class Problem053 {

    public static void main(String[] args) {
        long count = 0;

        long startTime = System.currentTimeMillis();

        for (int n = 1; n <= 100; n++) {
            for (int k = 1; k < n; k++) {
                if (binomialCoefficient(n, k).toString().length() > 6) {
                    count++;
                }
            }
        }

        System.out.println(count);

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }

    public static BigDecimal binomialCoefficient(int n, int k) {
        BigDecimal[] row = new BigDecimal[k + 1];
        row[0] = new BigDecimal("1");

        for (int i = 1; i < k + 1; i++)
            row[i] = new BigDecimal("0");

        for (int i = 1; i <= n; i++) {
            for (int j = (i < k) ? i : k; j > 0; j--) {
                row[j] = row[j].add(row[j - 1]);
            }
        }

        return row[k];
    }
}

//Answer: 4075
