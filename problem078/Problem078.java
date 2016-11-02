package problem078;

/**
 * Created by kiran on 11/1/16.
 *
 * Let p(n) represent the number of different ways in which n coins can be separated into piles. For example, five coins can be separated into piles in exactly seven different ways, so p(5)=7.

 OOOOO
 OOOO   O
 OOO   OO
 OOO   O   O
 OO   OO   O
 OO   O   O   O
 O   O   O   O   O
 Find the least value of n for which p(n) is divisible by one million.
 */

public class Problem078 {
    static int[] lookup;
    static int[] pentagonals;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        lookup = new int[1_000_000];
        pentagonals = new int[1_000];
        int index = 0;
        for (int i = 1; i <= 500; i = i > 0 ? -i : -i + 1) {
            pentagonals[index++] = i * (3 * i - 1) / 2;
        }

        for (int i = 0; ; i++) {
            if (partitions(i) % 1_000_000 == 0) {
                System.out.println(i);
                break;
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }

    private static int partitions(int n) {
        if (lookup[n] != 0) return lookup[n];

        if (n < 0) {
            return 0;
        }

        if (n < 2) {
            return 1;
        }

        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (n - pentagonals[i] < 0) {
                break;
            }

            int result = partitions(n - pentagonals[i]) % 1_000_000;
            lookup[n - pentagonals[i]] = result;

            int sign = i % 4 < 2 ? 1 : -1;
            sum += sign * result;
        }

        return sum;
    }


}
