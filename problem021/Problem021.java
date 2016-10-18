package problem021;

//Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
//If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
//For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
//Evaluate the sum of all the amicable numbers under 10000.


public class Problem021 {
	
	public static int getDivisorSum(int number) {
		int sum = 0;
		for (int i = 1; i <= number / 2; i++) {
			if (number % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	public static boolean isAmicable(int number) {
		int divisorSum = getDivisorSum(number);
		
		int otherDivisorSum = getDivisorSum(divisorSum);
		
		if (otherDivisorSum == number && number != divisorSum) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 10000; i++) {
			if (isAmicable(i)) {
				sum += i;
			}
		}
		
		System.out.println(sum);
	}
}

//Answer: 31626
