package problem064;

/**
 * Created by kiran on 2/2/16.
 * The first ten continued fraction representations of (irrational) square roots are:

 √2=[1;(2)], period=1
 √3=[1;(1,2)], period=2
 √5=[2;(4)], period=1
 √6=[2;(2,4)], period=2
 √7=[2;(1,1,1,4)], period=4
 √8=[2;(1,4)], period=2
 √10=[3;(6)], period=1
 √11=[3;(3,6)], period=2
 √12= [3;(2,6)], period=2
 √13=[3;(1,1,1,1,6)], period=5

 Exactly four continued fractions, for N ≤ 13, have an odd period.

 How many continued fractions for N ≤ 10000 have an odd period?
 */
public class Problem064 {
    public static void main(String[] args) {

        int count = 0;

        for (int n = 2; n <= 10_000; n++) {
            if ((int)Math.sqrt(n) * (int)Math.sqrt(n) != n) {
                if (getContinuedFractionPeriod(n) % 2 != 0) count++;
            }
        }

        System.out.println(count);
    }

    public static int getContinuedFractionPeriod(int sqrtOf) {
        int period = 0;
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

            period++;
            if (numeratorInt == firstLeadingInt && denominatorInt == 1) {
                break;
            }

            leadingInt = (int) ((Math.sqrt(sqrtOf) + numeratorInt) / denominatorInt);

            int temp = numeratorInt;
            numeratorInt = denominatorInt;
            denominatorInt = temp - leadingInt * denominatorInt;
        }

        return period;
    }
}

// Answer: 1322
