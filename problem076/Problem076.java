package problem076;


import java.util.HashMap;

/**
 * Created by kiran on 10/31/16.
 *
 * It is possible to write five as a sum in exactly six different ways:

 4 + 1
 3 + 2
 3 + 1 + 1
 2 + 2 + 1
 2 + 1 + 1 + 1
 1 + 1 + 1 + 1 + 1

 How many different ways can one hundred be written as a sum of at least two positive integers?
 */
public class Problem076 {

    static long[][] lookup;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int n = 100;
        lookup = new long[n + 1][n + 1];
        System.out.println(p(n, n) - 1);


        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }


    private static long p(int n, int m) {
        if (m == 0 || n < 0) {
            return 0;
        }

        if (n == 1 || m == 1) {
            return 1;
        }

        if (lookup[n][m] != 0) {
            return lookup[n][m];
        }

        if (n == m) {
            long result = 1 + p(n, m - 1);
            lookup[n][m] = result;
            return result;
        }

        long result = p(n, m - 1) + p(n - m, m);

        lookup[n][m] = result;
        return result;
    }

}

// Answer: 190569291
