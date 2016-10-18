package problem032;

//We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
//The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
//Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
//HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.

import java.util.ArrayList;

public class Problem032 {
	
	public static boolean arePandigital(int a, int b, int c) {
		
		if (String.valueOf(a).contains("0") || String.valueOf(b).contains("0")){
			return false;
		}
		
		String test = String.valueOf(a) + String.valueOf(b) + String.valueOf(c);
			
		for (int i = 1; i < 10; i++) {
			if (!test.contains(String.valueOf(i))) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public static int countDigits(int a, int b, int c) {
		return (String.valueOf(a) + String.valueOf(b) + String.valueOf(c)).length();
	}

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		ArrayList<Integer> products = new ArrayList<Integer>();
		
		for (int a = 2; a < 5000; a++) {
			for (int b = 2; b < 5000; b++) {
				int c = a * b;
				if (countDigits(a, b, c) == 9) {
					if (arePandigital(a, b, c)) {
						if (!products.contains(c)) {
							products.add(c);
						}
					}
				}
			}
		}
		
		int sum = 0;
		
		for (Integer a : products) {
			sum += a;
		}
		
		System.out.println(sum);
		
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println("Completed in: " + duration + "ms");
	}

}

//Answer: 45228
