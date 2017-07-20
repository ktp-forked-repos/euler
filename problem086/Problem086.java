package problem086;

/**
 * Created by kiran on 7/19/17.
 */
public class Problem086 {
    public static void main(String[] args) {
        int M = 0;
        int solutions = 0;
        int min, min_sqrt;
        int a, b, c;


        long startTime = System.currentTimeMillis();

        while (solutions < 1_000_000) {
            M++;
            for (int y = 1; y <= M; y++) {
                for (int z = 1; z <= y; z++) {
                    a = M * M + (y + z) * (y + z);
                    b = y * y + (M + z) * (M + z);
                    c = z * z + (y + M) * (y + M);

                    min = Math.min(Math.min(a, b), c);
                    min_sqrt = (int) Math.sqrt(min);
                    if (min_sqrt * min_sqrt == min) {
                        solutions++;
                    }
                }
            }
        }

        System.out.println(M);

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }
}
