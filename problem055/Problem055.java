package problem055;

import java.math.BigInteger;

/**
 * Created by kiran on 1/29/16.
 *
 * If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.

 Not all numbers produce palindromes so quickly. For example,

 349 + 943 = 1292,
 1292 + 2921 = 4213
 4213 + 3124 = 7337

 That is, 349 took three iterations to arrive at a palindrome.

 Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome.
 A number that never forms a palindrome through the reverse and add process is called a Lychrel number.
 Due to the theoretical nature of these numbers, and for the purpose of this problem, we shall assume that a number is Lychrel until proven otherwise.
 In addition you are given that for every number below ten-thousand, it will either (i) become a palindrome in less than fifty iterations, or, (ii) no one, with all the computing power that exists, has managed so far to map it to a palindrome.
 In fact, 10677 is the first number to be shown to require over fifty iterations before producing a palindrome: 4668731596684224866951378664 (53 iterations, 28-digits).

 Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.

 How many Lychrel numbers are there below ten-thousand?
 */
public class Problem055 {

    public static void main(String[] args) {

        int count = 0;

        for (int candidate = 1; candidate < 10_000; candidate++) {
            if (isLychrel(new BigInteger(candidate + ""))) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static BigInteger addReverse(BigInteger number) {
        BigInteger reversed = reverse(number);
        return number.add(reversed);
    }

    public static BigInteger reverse(BigInteger number) {
        String numberString = number.toString();
        String reversedString = "";

        for (int digit = numberString.length() - 1; digit >= 0 ; digit--) {
            reversedString += numberString.charAt(digit);
        }

        return new BigInteger(reversedString);
    }

    public static boolean isPalindrome(String str) {
        if (str.length() < 2) {
            return true;
        }

        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }

        return isPalindrome(str.substring(1, str.length() - 1));
    }

    public static boolean isLychrel(BigInteger candidate) {

        for (int i = 0; i < 50; i++) {
            candidate = addReverse(candidate);
            if (isPalindrome(candidate.toString())) {
                return false;
            }
        }

        return true;
    }
}

// Answer: 249
