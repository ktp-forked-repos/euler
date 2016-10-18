package problem023;

//A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
//A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
//As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
//Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

public class Problem023 {
	
	public static int[] abundants = new int[6961];
	
	public static boolean isAbundant(int n) {
		int sum = 0;
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		
		if (sum > n) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isAbundantSum(int n) {
		for (int i = 0; i < abundants.length; i++) {
			if (abundants[i] + 12 > n) {
				break;
			}
			for (int j = 0; j < abundants.length; j++) {
				if (abundants[i] + abundants[j] > n) {
					break;
				}
				if (abundants[i] + abundants[j] == n) {
					return true;
				}
			}
		}
		return false;
	}
	
	

	public static void main(String[] args) {
		int num = 0;
		for (int i = 12; i < 28112; i++) {
			if(isAbundant(i)) {
				abundants[num] = i;
				num++;
			}
		}
		
		int sum = 0;
		for (int i = 1; i < 28123; i++) {
			if (!isAbundantSum(i)) {
				sum += i;
			}
		}
		
		System.out.println(sum);

	}

}
//Answer: 4179871
