package problem068;

import java.util.ArrayList;

/**
 * Created by kiran on 2/21/16.
 * Consider the following "magic" 3-gon ring, filled with the numbers 1 to 6, and each line adding to nine.
 *
 Working clockwise, and starting from the group of three with the numerically lowest external node (4,3,2 in this example), each solution can be described uniquely. For example, the above solution can be described by the set: 4,3,2; 6,2,1; 5,1,3.

 It is possible to complete the ring with four different totals: 9, 10, 11, and 12. There are eight solutions in total.

 Total	Solution Set
 9	4,2,3; 5,3,1; 6,1,2
 9	4,3,2; 6,2,1; 5,1,3
 10	2,3,5; 4,5,1; 6,1,3
 10	2,5,3; 6,3,1; 4,1,5
 11	1,4,6; 3,6,2; 5,2,4
 11	1,6,4; 5,4,2; 3,2,6
 12	1,5,6; 2,6,4; 3,4,5
 12	1,6,5; 3,5,4; 2,4,6
 By concatenating each group it is possible to form 9-digit strings; the maximum string for a 3-gon ring is 432621513.

 Using the numbers 1 to 10, and depending on arrangements, it is possible to form 16- and 17-digit strings. What is the maximum 16-digit string for a "magic" 5-gon ring?
 */

public class Problem068 {

    static ArrayList<int[]> allCombinations;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ArrayList<int[]> combinations = getKCombinations(numbers, 5);

        ArrayList<int[]> centers = new ArrayList<>();
        for (int[] combination : combinations) {
            ArrayList<int[]> permutations = generatePermutations(combination);
            centers.addAll(permutations);
        }

        ArrayList<ArrayList<int[]>> externals = new ArrayList<>();
        for (int[] center : centers) {
            externals.add(generatePermutations(getRemainingDigits(center)));
        }

        long max16DigitSolution = 0;

        for (int i = 0; i < centers.size(); i++) {
            int[] center = centers.get(i);
            ArrayList<int[]> theseExternals = externals.get(i);

            for (int[] external : theseExternals) {
                if (external[0] > external[1] ||external[0] > external[2] ||external[0] > external[3] ||external[0] > external[4]) {
                    continue;
                }

                String solution = "";

                boolean haveSameSum = true;
                int sum = external[0] + center[0] + center[1];
                for (int j = 0; j < 5; j++) {
                    if (external[j] + center[j] + center[j == 4 ? 0 : j + 1] != sum) {
                        haveSameSum = false;
                        break;
                    }
                    solution += external[j] + "" + center[j] + "" + center[j == 4 ? 0 : j + 1];
                }

                if (!haveSameSum) {
                    continue;
                }

                Long solutionLong = Long.parseLong(solution);

                if (solution.length() == 16 && solutionLong > max16DigitSolution) {
                    max16DigitSolution = solutionLong;
                }
            }
        }

        System.out.println(max16DigitSolution);

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }

    private static ArrayList<int[]> getKCombinations(int[] array, int k) {
        ArrayList<int[]> combinations = new ArrayList<>();

        if (array.length == k) {
            combinations.add(array);
            return combinations;
        }

        combinationUtil(combinations, array, new int[k], k, 0, array.length - 1, 0);

        return combinations;
    }

    private static void combinationUtil(ArrayList<int[]> combinations, int[] array, int[] data, int k, int start, int end, int index) {
        if (index == k) {
            combinations.add(deepCopyArray(data));
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= k - index; i++) {
            data[index] = array[i];
            combinationUtil(combinations, array, data, k, i + 1, end, index + 1);
        }

    }

    private static int[] deepCopyArray(int[] array) {
        int[] deepCopy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            deepCopy[i]  = array[i];
        }
        return deepCopy;
    }

    private static ArrayList<int[]> generatePermutations(int[] sortedDigits) {
        ArrayList<int[]> permutations = new ArrayList<>();

        while (sortedDigits != null) {
            permutations.add(deepCopyArray(sortedDigits));
            sortedDigits = generateNextPermutation(sortedDigits);
        }

        return permutations;
    }

    private static int[] generateNextPermutation(int[] permutation) {
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

    private static int[] getRemainingDigits(int[] usedDigits) {
        int[] remainingDigits = new int[5];
        int index = 0;

        for (int digit = 1; digit <= 10; digit++) {
            boolean isUsed = false;

            for (int usedDigit : usedDigits) {
                if (digit == usedDigit) {
                    isUsed = true;
                    break;
                }
            }

            if (!isUsed) {
                remainingDigits[index] = digit;
                index++;
            }
        }

        return remainingDigits;
    }
}
//Answer: 6531031914842725