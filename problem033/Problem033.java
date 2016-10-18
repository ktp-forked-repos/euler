package problem033;

//The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
//We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
//There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
//If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

public class Problem033 {
	
	public static double containSameDigit(int a, int b) {
		
		for (char i : String.valueOf(a).toCharArray()) {
			for (char j : String.valueOf(b).toCharArray()) {
				if (i == j) {
					if (i != '0') {
						return Double.valueOf(replaceOnce(String.valueOf(a), i)) / Double.valueOf(replaceOnce(String.valueOf(b), i));
					}
				}
			}
		}
		
		return 0;
	}
	
	
	public static int[] simplifyFraction(int[] fraction) {
		int numerator = fraction[0];
		int denominator = fraction[1];
		
		for (int factor = 2; factor <= Math.min(numerator, denominator); factor++) {
			if (numerator % factor == 0 && denominator % factor == 0) {
				int[] simplifiedFraction = simplifyFraction(new int[] {numerator / factor, denominator / factor});
				numerator = simplifiedFraction[0];
				denominator = simplifiedFraction[1];
			}
		}
		
		return new int[] {numerator, denominator};
	}
	
	public static String replaceOnce(String start, char toReplace) {
		if (start.startsWith(String.valueOf(toReplace))) {
			return start.substring(1);
		} else {
			return start.substring(0, 1);
		}
	}
	

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		//code
		
		int numeratorProduct = 1;
		int denominatorProduct = 1;
		
		for (int a = 10; a < 100; a++) {
			for (int b = 10; b < 100; b++) {
				double division = containSameDigit(a, b);
				if (division != 0) {
					if ((double)a / (double)b == division && division < 1) {
						if (a != b) {
							numeratorProduct *= a;
							denominatorProduct *= b;
						}
					}
				}
			}
		}

		System.out.println(simplifyFraction(new int[] {numeratorProduct, denominatorProduct})[1]);
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println("Completed in: " + duration + "ms");

	}

}

//Answer: 100
