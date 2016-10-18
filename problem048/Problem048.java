package problem048;

import java.math.BigInteger;

/**
 * Created by kiran on 1/23/16.
 *
 * The series, 11 + 22 + 33 + ... + 1010 = 10405071317.

 Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
 */

public class Problem048 {
    public static void main(String[] args) {
        BigInteger sum = new BigInteger("0");

        for (int i = 1; i <= 1000; i++) {
            BigInteger n = new BigInteger(i + "");

            sum = sum.add(n.pow(i));
        }

        String result = sum.toString();

        System.out.println(result.substring(result.length() - 10, result.length()));

    }
}
