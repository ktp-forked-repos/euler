package problem052;

/**
 * Created by kiran on 1/25/16.
 *
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

 Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 */
public class Problem052 {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        int testing = 1;

        while (true) {
            if (containSameDigits(testing, 2*testing) &&
                containSameDigits(testing, 3*testing) &&
                containSameDigits(testing, 4*testing) &&
                containSameDigits(testing, 5*testing) &&
                containSameDigits(testing, 6*testing)) {
                break;
            }
            testing++;
        }


        System.out.println(testing);

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }

    public static boolean containSameDigits(int a, int b) {
        int[] aDigits = new int[10];
        int[] bDigits = new int[10];

        for (int i = 0; i < 10; i++) {
            aDigits[i] = 0;
            bDigits[i] = 0;
        }

        for (char c : (a + "").toCharArray()) {
            aDigits[c - '0']++;
        }

        for (char c : (b + "").toCharArray()) {
            bDigits[c - '0']++;
        }

        boolean containSameDigits = true;
        for (int i = 0; i < 10; i++) {
            if (aDigits[i] != bDigits[i]) {
                containSameDigits = false;
                break;
            }
        }

        return containSameDigits;
    }
}

//Answer: 142857