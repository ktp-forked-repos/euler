package problem049;

import java.util.ArrayList;

/**
 * Created by kiran on 1/23/16.
 *
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

 There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.

 What 12-digit number do you form by concatenating the three terms in this sequence?
 */
public class Problem049 {

    public static void main(String[] args) {

        String result = "";

        for (int i = 1000; i < 10000; i++) {
            if (isPrime(i)) {
                int[] digits = new int[4];

                for (int digit = 0; digit < 4; digit++) {
                    digits[digit] = (i + "").charAt(digit) - '0';
                }

                ArrayList<Integer> primePermutations = generatePrimePermutations(digits);

                for (int a = 0; a < primePermutations.size(); a++) {
                    int perm = primePermutations.get(a);

                    for (int b = a + 1; b < primePermutations.size(); b++) {
                        int otherPerm = primePermutations.get(b);

                        int difference = otherPerm - perm;

                        for (int c = b + 1; c < primePermutations.size(); c++) {
                            int thirdPerm = primePermutations.get(c);

                            if (thirdPerm - otherPerm == difference && perm != 1487) {
                                result = (perm + "") + (otherPerm + "") + (thirdPerm + "");
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);

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

    public static ArrayList<Integer> generatePrimePermutations(int[] digits) {
        ArrayList<Integer> primePermutations = new ArrayList<Integer>();

        while (digits != null) {
            if (isPrime(collapse(digits)))
                primePermutations.add(collapse(digits));
            digits = generateNextPermutation(digits);
        }

        return primePermutations;

    }

    public static int collapse(int[] array) {
        String s = "";

        for (int i : array) {
            s += i;
        }

        return Integer.parseInt(s);
    }

    public static int[] generateNextPermutation(int[] permutation) {
        int k = permutation.length - 2;
        int I = permutation.length - 1;

        while (k > -1 && permutation[k] >= permutation[k + 1]) {
            k--;
        }

        if (k == -1) {
            return null;
        }

        while (I >= 0 && permutation[k] >= permutation[I]) {
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


}
