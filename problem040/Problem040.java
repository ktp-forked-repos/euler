package problem040;

/**
 * Created by kiran on 1/19/16.
 *
 * An irrational decimal fraction is created by concatenating the positive integers:

 0.123456789101112131415161718192021...

 It can be seen that the 12th digit of the fractional part is 1.

 If dn represents the nth digit of the fractional part, find the value of the following expression.

 d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */
public class Problem040 {

    static int d(int index) {
        int i = 1;
        int number = 1;

        while (i <= index) {
            for (char digit : Integer.toString(number).toCharArray()) {
                if (i == index) {
                    return digit - '0';
                }
                i++;
            }
            number++;
        }

        return 0;
    }



    public static void main(String[] args) {
        System.out.println(d(1) * d(10) * d(100) * d(1000) * d(10000) * d(100000) * d(1000000));
    }


}
// Answer: 210