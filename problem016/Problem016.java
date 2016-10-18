package problem016;

//2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
//What is the sum of the digits of the number 2^1000?	

import java.math.BigInteger;

public class Problem016 {

	public static void main(String[] args) {
		BigInteger big = new BigInteger("2").pow(1000);
		
		String bigString = big.toString();
		
		int sum = 0;
		
		for (int i = 0; i < bigString.length(); i++) {
			sum += Character.getNumericValue(bigString.charAt(i));
		}
		
		System.out.println(sum);
	}

}
//Answer: 1366
