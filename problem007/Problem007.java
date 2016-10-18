package problem007;

//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//What is the 10 001st prime number?

public class Problem007 {
	
	public static boolean isPrime(int n) {
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

		int prime = 1;
		int testing = 1;
		
		while (prime < 10001) {
			testing += 2;
			if (isPrime(testing)) {
				prime++;
			}
		}
		
		System.out.println(testing + " is the 10001st prime");
	
	}

}

//Answer: 104743
