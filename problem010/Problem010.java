package problem010;

//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//Find the sum of all the primes below two million.

public class Problem010 {
	
	public static boolean isPrime(int n) {
		if (n == 1) return false;
		if (n == 2) return true;
		if (n % 2 == 0) return false;

		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
			
		}
		return true;
	}

	public static void main(String[] args) {
		long sum = 2;
		
		for (int i = 3; i < 2000000; i += 2) {
			if (isPrime(i)) {
				sum += i;
			}
		}
		
		System.out.println("The sum of all primes below 2000000 is " + sum);
		
	}
}

//Answer: 142913828922