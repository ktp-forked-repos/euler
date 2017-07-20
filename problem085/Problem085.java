package problem085;

/**
 * Created by kiran on 7/19/17.
 */
public class Problem085 {

    public static void main(String[] args) {
        int closest = 0;
        int closest_area = 0;
        int target = 2_000_000;
        int num;

        long startTime = System.currentTimeMillis();

        for (int width = 1; width < 1_000; width++) {
            for (int height = 1; height <= width; height++) {
                num = width *  height * (width + 1) * (height + 1) / 4;
                if (Math.abs(target - num) < Math.abs(target - closest)) {
                    closest = num;
                    closest_area = width * height;
                }
            }
        }

        System.out.println(closest_area);

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }
}
