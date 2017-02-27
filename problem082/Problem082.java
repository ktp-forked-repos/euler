package problem082;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kiran on 11/4/16.
 */
public class Problem082 {
    public static void main(String[] args) {
        int[][] matrix = new int[80][80];

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/problem082/p082_matrix.txt"));

            String line;
            int lineIndex = 0;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(",");
                for (int i = 0; i < splitLine.length; i++) {
                    matrix[lineIndex][i] = Integer.parseInt(splitLine[i]);
                }
                lineIndex++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long startTime = System.currentTimeMillis();

        int[][] totalCost = new int[80][80];

        for (int row = 0; row < 80; row++) {
            totalCost[row][0] = matrix[row][0];
        }

        for (int col = 1; col < 80; col++) {
            int[] prevCol = new int[80];
            int[] newCol = new int[80];
            for (int row = 0; row < 80; row++) {
                newCol[row] = totalCost[row][col-1] + matrix[row][col];
                prevCol[row] = newCol[row];

            }

            boolean foundDiff = true;
            while (foundDiff) {
                foundDiff = false;

                for (int row = 1; row < 79; row++) {
                    newCol[row] = Math.min(newCol[row], Math.min(newCol[row-1] + matrix[row][col], newCol[row+1] + matrix[row][col]));
                }
                newCol[0] = Math.min(newCol[0], newCol[1] + matrix[0][col]);
                newCol[79] = Math.min(newCol[79], newCol[78] + matrix[79][col]);

                for (int row = 0; row < 80; row++) {
                    if (newCol[row] != prevCol[row]) {
                        foundDiff = true;
                    }
                }

                prevCol = newCol.clone();

            }

            for (int row = 0; row < 80; row++) {
                totalCost[row][col] = newCol[row];
            }

        }

        int min = totalCost[0][79];
        for (int row = 1; row < 80; row++) {
            if (totalCost[row][79] < min) {
                min = totalCost[row][79];
            }
        }

        System.out.println(min);
       


        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }
}
