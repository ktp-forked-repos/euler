package problem065;

import java.math.BigInteger;

/**
 * Created by kiran on 2/2/16.
 *
 * What is most surprising is that the important mathematical constant,
 e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].

 The first ten terms in the sequence of convergents for e are:

 2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
 The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.

 Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.
 */
public class Problem065 {

    public static void main(String[] args) {
        int[] bs = generateBs();

        BigInteger[] convergent = new BigInteger[] {new BigInteger("11"), new BigInteger("4")};
        BigInteger[] prevConvergent = new BigInteger[] {new BigInteger("8"), new BigInteger("3")};
        for (int i = 4; i < 100; i++) {
            BigInteger[] temp = convergent;
            convergent = getNextConvergent(convergent, prevConvergent, new BigInteger(String.valueOf(bs[i])));
            prevConvergent = temp;
        }

        String numerator = convergent[0].toString();
        int sum = 0;
        for (char c : numerator.toCharArray()) {
            sum += c - '0';
        }

        System.out.println(sum);

    }

    public static BigInteger[] getNextConvergent(BigInteger[] convergent, BigInteger[] prevConvergent, BigInteger b) {
        BigInteger A1 = convergent[0];
        BigInteger B1 = convergent[1];
        BigInteger A2 = prevConvergent[0];
        BigInteger B2 = prevConvergent[1];

        return new BigInteger[] {A1.multiply(b).add(A2), B1.multiply(b).add(B2)};
    }

    public static int[] generateBs() {
        int[] bs = new int[100];

        for (int i = 0; i < 100; i++) {
            if ((i + 1) % 3 == 0) {
                bs[i] = 2 * ((i + 1) / 3);
            } else {
                bs[i] = 1;
            }
        }

        bs[0] = 2;

        return bs;
    }
}

// Answer: 272