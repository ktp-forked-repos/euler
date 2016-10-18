package problem058;

/**
 * Created by kiran on 1/29/16.
 *
 * Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.

 37 36 35 34 33 32 31
 38 17 16 15 14 13 30
 39 18  5  4  3 12 29
 40 19  6  1  2 11 28
 41 20  7  8  9 10 27
 42 21 22 23 24 25 26
 43 44 45 46 47 48 49

 It is interesting to note that the odd squares lie along the bottom right diagonal, but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.

 If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed.
 If this process is continued, what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?
 */
public class Problem058 {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();




        int sideLength = 7;
        int numberOfPrimes = 8;
        int diagonalsSize = 13;

        while ((double) numberOfPrimes / (double) diagonalsSize > 0.1) {
            sideLength +=2;
            int nEven = sideLength - 1;
            int nOdd = sideLength - 2;

            if (isPrime(nEven * nEven + nEven + 1)) {
                numberOfPrimes++;
            }

            if (isPrime(nOdd * nOdd + nOdd + 1)) {
                numberOfPrimes++;
            }

            if (isPrime(nEven * nEven + 1)) {
                numberOfPrimes++;
            }

            diagonalsSize += 4;
        }

        System.out.println(sideLength);
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
// Answer: 26241