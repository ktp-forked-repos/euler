package problem072;

/**
 * Created by kiran on 10/18/16.
 * Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

 If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:

 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

 It can be seen that there are 21 elements in this set.

 How many elements would be contained in the set of reduced proper fractions for d ≤ 1,000,000?
 */
public class Problem072 {
    public static void main(String[] args) {
        long sum = 0;

        long startTime = System.currentTimeMillis();


        for (int i = 2; i <= 1_000_000; i++) {
            sum += totient(i);
        }

        System.out.println(sum);

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }

    private static int totient(int n) {
        int totient = n;

        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                totient *= (1.0 - (1.0 / (float) p));

                while (n % p == 0) {
                    n /= p;
                }
            }
        }

        if (n > 1) {
            totient -= totient / n;
        }

        return totient;
    }
}
// Answer: 303963552391