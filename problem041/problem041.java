package problem041;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kiran on 1/19/16.
 *
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

 What is the largest n-digit pandigital prime that exists?
 */
public class problem041 {

    public static ArrayList<Integer> generatePermutations(int[] sortedDigits) {
        ArrayList<Integer> permutations = new ArrayList<Integer>();

        while (sortedDigits != null) {
            permutations.add(collapse(sortedDigits));
            sortedDigits = generateNextPermutation(sortedDigits);
        }

        return permutations;

    }

    public static int[] generateNextPermutation(int[] permutation) {
        int k = permutation.length - 2;
        int I = permutation.length - 1;

        while (k > -1 && permutation[k] > permutation[k + 1]) {
            k--;
        }

        if (k == -1) {
            return null;
        }

        while (I >= 0 && permutation[k] > permutation[I]) {
            I--;
        }

        int temp = permutation[k];
        permutation[k] = permutation[I];
        permutation[I] = temp;

        for (int i = 0; i < (permutation.length - (k + 1)) / 2; i++) {
            temp = permutation[i + k + 1];
            permutation[i + k + 1] = permutation[permutation.length - 1 - i];
            permutation[permutation.length - 1 - i] = temp;
        }

        return permutation;
    }

    public static int collapse(int[] array) {
        String s = "";

        for (int i : array) {
            s += i;
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        int biggestPandigitalPrime = 0;


        for (int i = 2; i < 10; i++) {
            int[] digits = new int[i];

            for (int a = 0; a < i; a++) {
                digits[a] = a + 1;
            }

            for (int pandigital : generatePermutations(digits)) {
                if (isPrime(pandigital)) {
                    if (pandigital > biggestPandigitalPrime) {
                        biggestPandigitalPrime = pandigital;
                    }
                }
            }
        }

        System.out.println(biggestPandigitalPrime);
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

// Answer: 7652413
