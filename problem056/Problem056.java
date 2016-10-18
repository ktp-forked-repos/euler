package problem056;

import java.math.BigInteger;

/**
 * Created by kiran on 1/29/16.
 * A googol (10^100) is a massive number: one followed by one-hundred zeros; 100^100 is almost unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.

 Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?
 */
public class Problem056 {

    public static void main(String[] args) {
        int maxDigitalSum = 0;

        for (int a = 2; a < 100; a++) {
            for (int b = 2; b < 100; b++) {
                BigInteger aToTheB = new BigInteger(a + "").pow(b);
                int digitalSum = getDigitalSum(aToTheB);

                if (digitalSum > maxDigitalSum) {
                    maxDigitalSum = digitalSum;
                }
            }
        }

        System.out.println(maxDigitalSum);
    }

    public static int getDigitalSum(BigInteger number) {
        int sum = 0;

        for (char digit : number.toString().toCharArray()) {
            sum += digit - '0';
        }

        return sum;
    }
}

// Answer: 972