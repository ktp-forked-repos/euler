package problem034;

//145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
//Find the sum of all numbers which are equal to the sum of the factorial of their digits.
//Note: as 1! = 1 and 2! = 2 are not sums they are not included.

public class Problem034 {
	
	static int getFactorialDigitSum(int num) {
		String tmp = String.valueOf(num);
		int[] digits = new int[tmp.length()];
		for (int i = 0; i < tmp.length(); i++) {
		    digits[i] = tmp.charAt(i) - '0';
		}
		
		int sum = 0;
		
		for (int i : digits) {
			sum += getFactorial(i);
		}
		
		return sum;
	}
	
	static int getFactorial(int num) {
		int factorial = 1;
		
		for (int i = 2; i <= num; i++) {
			factorial *= i;
		}
		
		return factorial;
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		int sum = 0;
		
		for (int i = 3; i < 10_000_000; i++) {
			if (i == getFactorialDigitSum(i)) {
				sum += i;
			}
		}
		
		System.out.println(sum);
		
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println("Completed in: " + duration + "ms");;



	}

}

//Answer: 40730
