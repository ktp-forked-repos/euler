package problem081;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kiran on 11/4/16.
 *
 * In the 5 by 5 matrix below, the minimal path sum from the top left to the bottom right, by only moving to the right and down, is indicated in bold red and is equal to 2427.

 Find the minimal path sum, in matrix.txt (right click and "Save Link/Target As..."), a 31K text file containing a 80 by 80 matrix, from the top left to the bottom right by only moving right and down.
 *
 */
public class Problem081 {
    public static void main(String[] args) {

        int[][] matrix = new int[80][80];

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/problem081/p081_matrix.txt"));

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
        totalCost[0][0] = matrix[0][0];

        for (int i = 1; i < 80; i++) {
            totalCost[i][0] = totalCost[i - 1][0] + matrix[i][0];
            totalCost[0][i] = totalCost[0][i - 1] + matrix[0][i];
        }

        for (int row = 1; row < 80; row++) {
            for (int col = 1; col < 80; col++) {
                totalCost[row][col] = Math.min(totalCost[row - 1][col], totalCost[row][col - 1]) + matrix[row][col];
            }
        }

        System.out.println(totalCost[79][79]);


        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Completed in: " + duration + "ms");
    }
}
// Answer: 427337