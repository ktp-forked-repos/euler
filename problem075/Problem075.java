package problem075;

/**
 * Created by kiran on 10/19/16.
 *
 * It turns out that 12 cm is the smallest length of wire that can be bent to form an integer sided right angle triangle in exactly one way, but there are many more examples.

 12 cm: (3,4,5)
 24 cm: (6,8,10)
 30 cm: (5,12,13)
 36 cm: (9,12,15)
 40 cm: (8,15,17)
 48 cm: (12,16,20)

 In contrast, some lengths of wire, like 20 cm, cannot be bent to form an integer sided right angle triangle, and other lengths allow more than one solution to be found; for example, using 120 cm it is possible to form exactly three different integer sided right angle triangles.

 120 cm: (30,40,50), (20,48,52), (24,45,51)

 Given that L is the length of the wire, for how many values of L ≤ 1,500,000 can exactly one integer sided right angle triangle be formed?
 */
public class Problem075 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int size = 1_500_000;
        int[] ways = new int[size + 1];

        for (int k = 1; 4 * k <= size; k++) {
            for (int m = 1; 2 * k * m * (m + 1) <= size; m++) {
                for (int n = (m % 2 == 0 ? 1 : 2); n < m; n += 2) {
                    if (getGCD(m, n) != 1) continue;

                    int a = k * (m * m - n * n);
                    int b = k * 2 * m * n;
                    int c = k * (m * m + n * n);

                    if (a + b + c > size) continue;
                    ways[a + b + c]++;
                }

            }
        }

        int sum = 0;
        for (int i = 12; i <= size; i++) {
            if (ways[i] == 1) sum++;
        }

        System.out.println(sum);

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }

    private static int getGCD(int a, int b) {
        int t;
        while(b != 0){
            t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

}
// Answer: 161667