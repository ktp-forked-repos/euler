package problem067;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kiran on 2/15/16.
 */
public class Problem067 {

    public static void main(String[] args) {
        int[][] triangle = new int[100][];

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/problem067/triangle.txt"));

            String line;
            int lineNum = 0;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(" ");

                int[] parsedLine = new int[splitLine.length];
                for (int i = 0; i < splitLine.length; i++) {
                    parsedLine[i] = Integer.parseInt(splitLine[i]);
                }

                triangle[lineNum] = parsedLine;
                lineNum++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[][] maxSum = new int[100][];
        for (int i = 0; i < 100; i++) {
            maxSum[i] = new int[triangle[i].length];
        }

        maxSum[0][0] = triangle[0][0];
        for (int row = 1; row < 100; row++) {
            for (int col = 0; col < triangle[row].length; col++) {
                int leftParent = 0;
                int rightParent = 0;

                if (col > 0) {
                    leftParent = maxSum[row - 1][col - 1];
                }

                if (col < triangle[row].length - 1) {
                    rightParent = maxSum[row - 1][col];
                }

                maxSum[row][col] = greaterOf(rightParent, leftParent) + triangle[row][col];
            }
        }

        int max = 0;
        for (int i : maxSum[99]) {
            if (i > max) {
                max = i;
            }
        }

        System.out.println(max);
    }

    public static int greaterOf(int a, int b) {
        return a >= b ? a : b;
    }



}
