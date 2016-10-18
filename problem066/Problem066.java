package problem066;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by kiran on 2/5/16.
 *
 * Consider quadratic Diophantine equations of the form:

 x^2 – Dy^2 = 1

 For example, when D=13, the minimal solution in x is 649^2 – 13×180^2 = 1.

 It can be assumed that there are no solutions in positive integers when D is square.

 By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:

 32 – 2×22 = 1
 22 – 3×12 = 1
 92 – 5×42 = 1
 52 – 6×22 = 1
 82 – 7×32 = 1

 Hence, by considering minimal solutions in x for D ≤ 7, the largest x is obtained when D=5.

 Find the value of D ≤ 1000 in minimal solutions of x for which the largest value of x is obtained.
 */

public class Problem066 {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        int largestD = 0;
        BigInteger largestX = new BigInteger("0");

        for (int D = 2; D <= 1000; D++) {
            if (D == (int) Math.sqrt(D) * (int) Math.sqrt(D)) {
                continue;
            }

            ArrayList<Integer> bs = getBs(D);

            BigInteger minimalX = findMinimalSolution(bs, D);

            if (minimalX.compareTo(largestX) == 1) {
                largestX = minimalX;
                largestD = D;
            }
        }

        System.out.println(largestD);


        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }

    public static BigInteger findMinimalSolution(ArrayList<Integer> bs, int D) {
        BigInteger[] prevConvergent = {new BigInteger("1"), new BigInteger("0")};
        BigInteger[] convergent = {new BigInteger("" + (int)Math.sqrt(D)), new BigInteger("1")};

        loop:
            while (true) {
                for (Integer b : bs) {
                    BigInteger[] temp = convergent;
                    convergent = getNextConvergent(convergent, prevConvergent, new BigInteger(b + ""));
                    prevConvergent = temp;

                    if (isDiophantineSolution(D, convergent[0], convergent[1])) {
                        break loop;
                    }
                }
            }

        return convergent[0];
    }

    private static boolean isDiophantineSolution(int D, BigInteger x, BigInteger y) {
        return x.multiply(x).subtract(new BigInteger(D + "").multiply(y).multiply(y)).equals(new BigInteger("1"));
    }

    public static BigInteger[] getNextConvergent(BigInteger[] convergent, BigInteger[] prevConvergent, BigInteger b) {
        BigInteger A1 = convergent[0];
        BigInteger B1 = convergent[1];
        BigInteger A2 = prevConvergent[0];
        BigInteger B2 = prevConvergent[1];

        return new BigInteger[] {A1.multiply(b).add(A2), B1.multiply(b).add(B2)};
    }

    public static ArrayList<Integer> getBs(int sqrtOf) {
        ArrayList<Integer> bs = new ArrayList<Integer>();

        int leadingInt = (int) Math.sqrt(sqrtOf);
        int firstLeadingInt = leadingInt;
        int numeratorInt = 1;
        int numeratorFactor = 1;
        int denominatorInt = -1 * leadingInt;

        while (true) {
            numeratorFactor = numeratorInt;
            numeratorInt = -1 * denominatorInt;

            denominatorInt = sqrtOf - numeratorInt * numeratorInt;
            denominatorInt /= numeratorFactor;

            leadingInt = (int) ((Math.sqrt(sqrtOf) + numeratorInt) / denominatorInt);
            bs.add(leadingInt);

            if (numeratorInt == firstLeadingInt && denominatorInt == 1) {
                break;
            }

            int temp = numeratorInt;
            numeratorInt = denominatorInt;
            denominatorInt = temp - leadingInt * denominatorInt;
        }

        return bs;
    }
}
