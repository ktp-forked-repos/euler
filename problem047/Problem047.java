package problem047;

import java.util.ArrayList;

/**
 * Created by kiran on 1/23/16.
 *
 * The first two consecutive numbers to have two distinct prime factors are:

 14 = 2 × 7
 15 = 3 × 5

 The first three consecutive numbers to have three distinct prime factors are:

 644 = 2² × 7 × 23
 645 = 3 × 5 × 43
 646 = 2 × 17 × 19.

 Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?
 */
public class Problem047 {

    public static void main(String[] args) {

        int testing = 1;
        int streak = 0;
        int streakStart = 0;

        while (true) {

            if (getPrimeFactors(testing).size() == 4) {
                streak++;

                if (streak == 4) {
                    break;
                } else if (streak == 1) {
                    streakStart = testing;
                }

            } else {
                streak = 0;
            }

            testing++;
        }

        System.out.println(streakStart);

    }

    public static ArrayList<Integer> getPrimeFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i * i<= n; i++) {
            if (n % i == 0) {
                if (isPrime(i)) {
                    factors.add(i);
                }
                if (isPrime(n / i)) {
                    factors.add(n / i);
                }
            }
        }

        if (factors.size() > 0) {
            if (n / factors.get(factors.size() - 1) == factors.get(factors.size() - 1))
                factors.remove(factors.size() - 1);
        }


        return factors;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
// Answer: 134043