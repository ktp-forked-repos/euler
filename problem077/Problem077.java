package problem077;

import java.util.ArrayList;
import java.util.BitSet;

/**
 * Created by kiran on 11/1/16.
 *
 * It is possible to write ten as the sum of primes in exactly five different ways:

 7 + 3
 5 + 5
 5 + 3 + 2
 3 + 3 + 2 + 2
 2 + 2 + 2 + 2 + 2

 What is the first value which can be written as the sum of primes in over five thousand different ways?
 */

public class Problem077 {

    static ArrayList<Integer> primes = primeSieve(1_000);
    static int[][] memo = new int[1_000][1_000];

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; ; i++) {
            if (partitionPrime(i, i) > 5_000) {
                System.out.println(i);
                break;
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");

    }

    private static int partitionPrime(int goal, int max) {
        if (memo[goal][max] != 0) return memo[goal][max];

        int sum = 0;

        for (int i = 0; ; i++) {
            int nextPrime = primes.get(i);
            if (nextPrime > max) break;

            if (goal - nextPrime == 0) {
                sum++;
                break;
            } else if (goal - nextPrime > 0) {
                int result = partitionPrime(goal - nextPrime, nextPrime);
                memo[goal - nextPrime][nextPrime] = result;
                sum += result;
            } else {
                break;
            }

        }

        return sum;
    }

    private static ArrayList<Integer> primeSieve(int max) {
        BitSet isComposite = new BitSet(max + 1);

        for (int i = 2; i * i <= max; i++) {
            if (!isComposite.get(i)) {
                for (int j = i * i; j <= max; j += i) {
                    isComposite.set(j);
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int num = 2; num <= max; num++) {
            if (!isComposite.get(num)) {
                primes.add(num);
            }
        }

        return primes;
    }
}
// Answer: 71

