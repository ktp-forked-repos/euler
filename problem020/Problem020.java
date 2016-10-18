package problem020;

//n! means n × (n − 1) × ... × 3 × 2 × 1
//For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
//and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
//Find the sum of the digits in the number 100!

import java.math.BigInteger;

public class Problem020 {

	public static void main(String[] args) {
		BigInteger factorial = new BigInteger("1");
		
		for (int i = 2; i <= 100; i++) {
			factorial = factorial.multiply(new BigInteger(i + ""));
		}
		
		String factorialString = factorial.toString();
		
		int sum = 0;
		
		for (char c : factorialString.toCharArray()) {
			sum += Character.getNumericValue(c);
		}
		
		System.out.println(sum);
	}

}

//Answer: 648