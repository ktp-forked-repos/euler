package problem051;

import java.util.ArrayList;

/**
 * Created by kiran on 1/25/16.
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

 By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

 Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
 */
public class Problem051 {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        int testing = 0;
        boolean foundResult = false;

        while (!foundResult) {

            testing++;

            if (!isPrime(testing)) {
                continue;
            }

            ArrayList<String> templates = generateTemplates(testing);
            for (String template : templates) {
                if (getNumberOfPrimesWithTemplate(template) == 8) {
                    foundResult = true;
                    break;
                }
            }
        }

        System.out.println(testing);

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");

    }

    static ArrayList<String> generateTemplates(int prime) {
        ArrayList<String> templates = new ArrayList<String>();
        String primeString = prime + "";

        for (int i = 0; i < 10; i++) {
            String template = primeString.replace((char)(i + '0'), '*');
            if (!template.equals(primeString))
                templates.add(template);
        }

        return templates;
    }

    static int getNumberOfPrimesWithTemplate(String template) {
        int numberOfPrimes = 0;

        for (int i = 0; i < 10; i++) {
            int potentialPrime = Integer.parseInt(template.replace('*', (char)(i + '0')));
            if (isPrime(potentialPrime)) {
                if (i == 0 && template.charAt(0) == '*') {
                    continue;
                }
                numberOfPrimes++;
            }

        }

        return numberOfPrimes;
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

//Answer: 121313