//The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
//Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
//(Please note that the palindromic number, in either base, may not include leading zeros.)

package problem036;

public class Problem036 {
	
	public static boolean isPalindrome(String str) {
		if (str.length() < 2) {
			return true;
		}
		
		if (str.charAt(0) != str.charAt(str.length() - 1)) {
			return false;
		}
		
		return isPalindrome(str.substring(1, str.length() - 1));
	}

	public static void main(String[] args) {
		int sum = 0;
		long startTime = System.currentTimeMillis();
		
		for (int i = 1; i < 1_000_000; i++) {
			if (isPalindrome(i + "") && isPalindrome(Integer.toString(i, 2))) {
				sum += i;
			}
		}
		
		System.out.println(sum);

		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println("Completed in: " + duration + "ms");
	}

}
//Answer: 872187