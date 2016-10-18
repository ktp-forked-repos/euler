package problem060;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kiran on 1/31/16.
 * The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order the result will always be prime.
 * For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.

 Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
 */

public class Problem060 {


   static  ArrayList<Integer> primes;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        primes = new ArrayList<Integer>();

        for (int i = 0; i < 10_000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        HashMap<Integer, ArrayList<Integer>> partners = new HashMap<Integer, ArrayList<Integer>>();

        for (Integer prime : primes) {
            partners.put(prime, generatePartnersFor(prime));
        }

        int minSum = 1_000_000_000;

        for (int a = 0; a < primes.size() - 4; a++) {
            int pA = primes.get(a);

            for (int b = a + 1; b < primes.size() - 3; b++) {
                int pB = primes.get(b);

                if (!partners.get(pA).contains(pB)) {
                    continue;
                }

                for (int c = b + 1; c < primes.size() - 2; c++) {
                    int pC = primes.get(c);

                    if (!partners.get(pA).contains(pC) || !partners.get(pB).contains(pC)) {
                        continue;
                    }

                    for (int d = c + 1; d < primes.size() - 1; d++) {
                        int pD = primes.get(d);

                        if (!partners.get(pA).contains(pD) || !partners.get(pB).contains(pD) || !partners.get(pC).contains(pD)) {
                            continue;
                        }

                        for (int e = d + 1; e < primes.size(); e++) {
                            int pE = primes.get(e);

                            if (!partners.get(pA).contains(pE) || !partners.get(pB).contains(pE) || !partners.get(pC).contains(pE) || !partners.get(pD).contains(pE)) {
                                continue;
                            }

                            int sum = pA + pB + pC + pD + pE;
                            if (sum < minSum) {
                                minSum = sum;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(minSum);

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");

    }

    public static ArrayList<Integer> generatePartnersFor(int prime) {
        ArrayList<Integer> partners = new ArrayList<Integer>();

        for (Integer partner : primes) {
            if (isPrime(Integer.parseInt(prime + "" + partner)) && isPrime(Integer.parseInt(partner + "" + prime))) {
                partners.add(partner);
            }
        }

        return partners;
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
// Answer: 26033