package problem074;

import java.util.HashSet;

/**
 * Created by kiran on 10/19/16.
 *
 * The number 145 is well known for the property that the sum of the factorial of its digits is equal to 145:

 1! + 4! + 5! = 1 + 24 + 120 = 145

 Perhaps less well known is 169, in that it produces the longest chain of numbers that link back to 169; it turns out that there are only three such loops that exist:

 169 → 363601 → 1454 → 169
 871 → 45361 → 871
 872 → 45362 → 872

 It is not difficult to prove that EVERY starting number will eventually get stuck in a loop. For example,

 69 → 363600 → 1454 → 169 → 363601 (→ 1454)
 78 → 45360 → 871 → 45361 (→ 871)
 540 → 145 (→ 145)

 Starting with 69 produces a chain of five non-repeating terms, but the longest non-repeating chain with a starting number below one million is sixty terms.

 How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?
 */

public class Problem074 {

    static int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int numChains = 0;
        for (int i = 0; i < 1_000_000; i++) {
            int previous = i;
            HashSet<Integer> chain = new HashSet<>();
            chain.add(i);

            for (int j = 0; j < 60; j++) {
                if (chain.size() != j + 1) break;
                int sum = 0;
                for (int digit : splitIntoDigits(previous)) sum += factorial[digit];
                chain.add(sum);
                previous = sum;
            }

            if (chain.size() == 60) {
                numChains++;
            }
        }

        System.out.println(numChains);

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }

    private static int[] splitIntoDigits(int n) {
        int numLength = numLength(n);
        int[] digits = new int[numLength];
        for (int i = 0; i < numLength; i++) {
            digits[i] = n % 10;
            n /= 10;
        }

        return digits;
    }

    static int numLength(int n) {
        if (n == 0) return 1;
        n = Math.abs(n);
        int l;
        for (l = 0; n > 0; l++) n /= 10;
        return l;
    }
}
