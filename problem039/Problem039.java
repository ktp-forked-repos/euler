package problem039;

/**
 * Created by kiran on 1/19/16.
 *
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

 {20,48,52}, {24,45,51}, {30,40,50}

 For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class Problem039 {

    public static void main(String[] args) {

        int maxP = 12;
        int maxSolutions = 1;

        for (int p = 12; p <= 1000; p++) {
            int solutions = 0;

            for (int a = 1; a < p / 2; a++) {
                for (int b = a; b < p / 2; b++) {
                    double c = Math.sqrt((double)a * a + b * b);

                    if ((int)c * (int)c == a*a + b*b) {
                        if (a + b + (int)c == p) {
                            solutions++;
                        }
                    }

                }
            }

            if (solutions > maxSolutions) {
                maxSolutions = solutions;
                maxP = p;
            }
        }

        System.out.println(maxP);

    }
}

// Answer: 840