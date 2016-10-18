package problem063;

import java.math.BigInteger;

/**
 * Created by kiran on 2/2/16.
 * The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit number, 134217728=8^9, is a ninth power.

 How many n-digit positive integers exist which are also an nth power?
 */
public class Problem063 {

    public static final BigInteger ONE = new BigInteger("1");

    public static void main(String[] args) {
        int count = 0;

        for (int i = 1; i < 25; i++) {
            int n = getNumberOfNDigitNPowers(i);
            count += n;
        }

        System.out.println(count);
    }

    public static int getNumberOfNDigitNPowers(int n) {
        int count = 0;
        BigInteger base = new BigInteger("1");
        BigInteger result = base.pow(n);

        while (result.toString().length() <= n) {
            if (result.toString().length() == n) {
                count++;
            }
            base = base.add(ONE);
            result = base.pow(n);
        }

        return count;
    }
}

//Answer: 49