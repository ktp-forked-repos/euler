package problem043;

import java.util.ArrayList;

/**
 * Created by kiran on 1/19/16.
 *
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather longeresting sub-string divisibility property.

 Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

 d2d3d4=406 is divisible by 2
 d3d4d5=063 is divisible by 3
 d4d5d6=635 is divisible by 5
 d5d6d7=357 is divisible by 7
 d6d7d8=572 is divisible by 11
 d7d8d9=728 is divisible by 13
 d8d9d10=289 is divisible by 17
 Find the sum of all 0 to 9 pandigital numbers with this property.
 */
public class Problem043 {

    public static void main(String[] args) {

        long sum = 0;

        ArrayList<String> pandigitals = generatePermutations(new long[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});

        for (String pandigital : pandigitals) {
            if (hasProperty(pandigital)) {
                sum += Long.parseLong(pandigital);
            }
        }

        System.out.println(sum);

    }

    public static boolean hasProperty(String number) {

        int s1 = Integer.parseInt(number.substring(1, 4));
        int s2 = Integer.parseInt(number.substring(2, 5));
        int s3 = Integer.parseInt(number.substring(3, 6));
        int s4 = Integer.parseInt(number.substring(4, 7));
        int s5 = Integer.parseInt(number.substring(5, 8));
        int s6 = Integer.parseInt(number.substring(6, 9));
        int s7 = Integer.parseInt(number.substring(7, 10));


        return  s1 % 2 == 0 &&
                s2 % 3 == 0 &&
                s3 % 5 == 0 &&
                s4 % 7 == 0 &&
                s5 % 11 == 0 &&
                s6 % 13 == 0 &&
                s7 % 17 == 0;
    }

    public static String collapse(long[] array) {
        String s = "";

        for (long i : array) {
            s += i;
        }

        return s;
    }


    public static ArrayList<String> generatePermutations(long[] sortedDigits) {
        ArrayList<String> permutations = new ArrayList<String>();

        while (sortedDigits != null) {
            permutations.add(collapse(sortedDigits));
            sortedDigits = generateNextPermutation(sortedDigits);
        }

        return permutations;

    }

    public static long[] generateNextPermutation(long[] permutation) {
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

        long temp = permutation[k];
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

// Answer: 16_695_334_890