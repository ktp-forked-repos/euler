package problem042;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kiran on 1/19/16.
 *
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

 By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value.
 For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

 Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
 */
public class Problem042 {


    public static void main(String[] args) {


        String[] words;
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get("src/problem042/words.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        content = content.replace("\"", "");
        words = content.split(",");

        int count = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (isTriangleNumber(getSumOfLetters(word))) {
                count++;
            }
        }

        System.out.println(count);
    }

    static int getSumOfLetters(String word) {
        int sum = 0;

        for (char letter : word.toLowerCase().toCharArray()) {
            sum += letter - 'a' + 1;
        }


        return sum;
    }

    static boolean isTriangleNumber(int number) {
        number *= 2;

        int i = 1;

        while (i * (i + 1) < number) {
            i++;
        }

        if (i * (i + 1) == number) {
            return true;
        }

        return false;
    }
}

// Answer: 162