package problem046;

import java.util.ArrayList;

/**
 * Created by kiran on 1/21/16.
 *
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

 9 = 7 + 2×12
 15 = 7 + 2×22
 21 = 3 + 2×32
 25 = 7 + 2×32
 27 = 19 + 2×22
 33 = 31 + 2×12

 It turns out that the conjecture was false.

 What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */

public class Problem046 {

    static ArrayList<Integer> primes = new ArrayList<Integer>();

    public static void main(String[] args) {
        primes.add(2);

        int testing = 3;

        loop:
        while (true) {
            if (isPrime(testing)) {
                testing += 2;
                continue;
            }

            for (int i = 0; true; i++) {
                 if (i == primes.size()) {
                     generateNextPrime();
                 }

                if (primes.get(i) > testing) {
                    break loop;
                }

                int squareRoot = 1;
                while (2 * squareRoot * squareRoot + primes.get(i) < testing) {
                    squareRoot++;
                }

                if (2 * squareRoot * squareRoot + primes.get(i) == testing) {
                    break;
                }
            }

            testing += 2;
        }

        System.out.println(testing);


    }

    static int generateNextPrime() {
        int nextPrime = primes.get(primes.size() - 1) + 1;

        while (!isPrime(nextPrime)) {
            nextPrime++;
        }

        primes.add(nextPrime);
        return nextPrime;
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

// Answer: 5777