package problem013;

//Work out the first ten digits of the sum of the following one-hundred 50-digit numbers. 

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;


public class Problem013 {

	public static void main(String[] args) {
		
		BigInteger[] numbers = new BigInteger[100];
		
		try(BufferedReader br = new BufferedReader(new FileReader("/Users/kiran/Desktop/Programming/Eclipse Workspace/Project Euler/src/problem013/numbers.txt"))) {
		    String line = br.readLine();
		    int i = 0;
		    while (line != null) {
		        numbers[i] = new BigInteger(line);
		        line = br.readLine();
		        i++;
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BigInteger sum = new BigInteger("0");
		for (BigInteger big : numbers) {
			sum = sum.add(big);
		}
		
		System.out.println((sum + "").substring(0, 10));
	}

}

//Answer: 5537376230
