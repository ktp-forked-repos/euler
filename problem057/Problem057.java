package problem057;

import com.sun.tools.internal.ws.wsdl.framework.TWSDLParserContextImpl;

import java.math.BigInteger;

/**
 * Created by kiran on 1/29/16.
 *
 * It is possible to show that the square root of two can be expressed as an infinite continued fraction.

 √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...

 By expanding this for the first four iterations, we get:

 1 + 1/2 = 3/2 = 1.5
 1 + 1/(2 + 1/2) = 7/5 = 1.4
 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...

 The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.

 In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
 */

public class Problem057 {
    static final BigInteger TWO = new BigInteger("2");

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        BigInteger[] convergent = new BigInteger[] {new BigInteger("1"), new BigInteger("1")};
        int count = 0;

        for (int i = 0; i < 1000; i++) {
            convergent = getNextConvergent(convergent);
            if (convergent[0].toString().length() > convergent[1].toString().length()) {
                count++;
            }
        }

        System.out.println(count);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");

    }

    public static BigInteger[] getNextConvergent(BigInteger[] convergent) {
        BigInteger p = convergent[0];
        BigInteger q = convergent[1];

        return new BigInteger[] {p.add(q.multiply(TWO)), p.add(q)};
    }

}

// Answer: 153