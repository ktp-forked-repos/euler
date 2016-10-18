package problem069;

/**
 * Created by kiran on 3/20/16.
 *
 * Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of numbers less than n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, φ(9)=6.

 It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.

 Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
 */
public class Problem069 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();


//        HashMap<Integer, ArrayList<Integer>> factors = new HashMap<>();

        double maxRatio = 0;
        int maxN = 0;

        for (int n = 2; n <= 1_000_000; n++) {

            double ratio = (double)n / (double)totient(n);
            if (ratio > maxRatio) {
                maxRatio = ratio;
                maxN = n;
            }
        }

        System.out.println(maxN + " with ratio of " + maxRatio);

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

// Answer: 510510
