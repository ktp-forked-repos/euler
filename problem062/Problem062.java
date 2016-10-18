package problem062;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kiran on 2/2/16.
 The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (384^3) and 66430125 (405^3). In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.

 Find the smallest cube for which exactly five permutations of its digits are cube.
 */

public class Problem062 {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        HashMap<String, ArrayList<Long>> cubeMap = new HashMap<String, ArrayList<Long>>();
        ArrayList<Long> cubes = new ArrayList<Long>();

        for (long n = 1; true; n++) {
            long cube = n * n * n;
            String sortedDigits = collapse(insertionSort(splitIntoDigits(cube)));

            if (cubeMap.get(sortedDigits) == null) {
                cubeMap.put(sortedDigits, new ArrayList<Long>());
                cubeMap.get(sortedDigits).add(cube);
            } else {
                cubeMap.get(sortedDigits).add(cube);
            }

            if (cubeMap.get(sortedDigits).size() == 5) {
                long min = cubeMap.get(sortedDigits).get(0);
                for (Long aLong : cubeMap.get(sortedDigits)) {
                    if (aLong < min) min = aLong;
                }

                System.out.println(min);
                break;
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }


    public static String collapse(int[] array) {
        String s = "";

        for (int i : array) {
            s += i;
        }

        return s;
    }


    public static int[] splitIntoDigits(long n) {
        String number = String.valueOf(n);
        int[] digits = new int[number.length()];

        for(int i = 0; i < number.length(); i++) {
            digits[i] = Character.digit(number.charAt(i), 10);
        }

        return digits;
    }

    public static int[] insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = temp;
        }

        return array;
    }

}

// Answer: 127_035_954_683
