package problem080;

import java.math.BigDecimal;

/**
 * Created by kiran on 11/1/16.
 *
 * It is well known that if the square root of a natural number is not an integer, then it is irrational. The decimal expansion of such square roots is infinite without any repeating pattern at all.

 The square root of two is 1.41421356237309504880..., and the digital sum of the first one hundred decimal digits is 475.

 For the first one hundred natural numbers, find the total of the digital sums of the first one hundred decimal digits for all the irrational square roots.
 */
public class Problem080 {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        int total = 0;
        for (int num = 2; num < 100; num++) {
            if ((int)Math.sqrt(num) != Math.sqrt(num)) {

                BigDecimal x = new BigDecimal(num);
                char[] digits = babylonianSqrt(x, 105).toString().replace(".", "").toCharArray();

                for (int i = 0; i < 100; i++) {
                    total += Character.getNumericValue(digits[i]);
                }

            }
        }

        System.out.println(total);

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }

    private static BigDecimal babylonianSqrt(BigDecimal x, int scale) {
        BigDecimal TWO = new BigDecimal(2);
        BigDecimal prevSqrt = new BigDecimal(0);
        BigDecimal sqrt = new BigDecimal(Math.sqrt(x.doubleValue()));

        while (!sqrt.equals(prevSqrt)) {
            prevSqrt = sqrt;
            sqrt = x.divide(prevSqrt, scale, BigDecimal.ROUND_HALF_UP);
            sqrt = sqrt.add(prevSqrt);
            sqrt = sqrt.divide(TWO, scale, BigDecimal.ROUND_HALF_UP);
        }

        return sqrt;

    }
}
// Answer: 40886