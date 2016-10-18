package problem050;

import java.util.ArrayList;

/**
 * Created by kiran on 1/23/16.
 *
 * The prime 41, can be written as the sum of six consecutive primes:

 41 = 2 + 3 + 5 + 7 + 11 + 13
 This is the longest sum of consecutive primes that adds to a prime below one-hundred.

 The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

 Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
public class Problem050 {

    public static void main(String[] args) {

        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 1; i < 1_000_000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        long startTime = System.currentTimeMillis();

        int maxSumPrime = 0;
        int maxSumLength = 0;

        for (int start = 0; start < primes.size(); start++) {
            int sum = 0;
            int sumLength = 0;

            if (primes.get(start) > 500_000) {
                break;
            }

            while (sum < 1_000_000) {
                sum += primes.get(start + sumLength);
                sumLength++;

                if (sumLength > maxSumLength) {
                    if (isPrime(sum)) {
                        maxSumPrime = sum;
                        maxSumLength = sumLength;
                    }
                }
            }
        }

        System.out.println(maxSumPrime);

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
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
