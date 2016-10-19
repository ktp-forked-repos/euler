package problem073;

/**
 * Created by kiran on 10/19/16.
 * Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

 If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:

 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

 It can be seen that there are 3 fractions between 1/3 and 1/2.

 How many fractions lie between 1/3 and 1/2 in the sorted set of reduced proper fractions for d ≤ 12,000?
 */
public class Problem073 {
    public static void main(String[] args) {
        int sum = 0;
        long startTime = System.currentTimeMillis();

        double fraction = 0;
        for (int i = 2; i <= 12_000; i++) {
            for (int j = 1; j < i; j++) {
                fraction = (double)j / (double)i;
                if (1.0/3.0 < fraction && fraction < 1.0/2.0) {
                     if (getGCD(i, j) == 1) sum++;
                }
            }
        }

        System.out.println(sum);

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }

    private static int getGCD(int a, int b) {
        int d = 0;

        while (a % 2 == 0 && b % 2 == 0) {
            a /= 2;
            b /= 2;
            d++;
        }

        while (a != b) {
            if (a % 2 == 0) {
                a /= 2;
            } else if (b % 2 == 0) {
                b /= 2;
            } else if (a > b) {
                a = (a - b) / 2;
            } else {
                b = (b - a) / 2;
            }
        }

        return a * (int)Math.pow(2.0, d);
    }
}
// Answer: 7295372
