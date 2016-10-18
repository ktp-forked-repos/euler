package problem004;

//A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
//Find the largest palindrome made from the product of two 3-digit numbers.

public class Problem004 {
	
	public static boolean isPalindrome(int n) {
		String stringN = n + "";
		
		for (int i = 0; i < stringN.length(); i++) {
			if (stringN.charAt(i) != stringN.charAt(stringN.length() - 1 - i)) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		int largestPalindrome = 0;
		for (int a = 100; a < 1000; a++) {
			for (int b = a; b < 1000; b++) {
				int product = a * b;
				if (isPalindrome(product) && product > largestPalindrome) {
					largestPalindrome = product;
				}
			}
		}

		System.out.println("The largest palindromic number that is a product of two 3-digit numbers is " + largestPalindrome);
		
	}

}

//Answer: 906609