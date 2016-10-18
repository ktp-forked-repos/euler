package problem003;

//The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600851475143 ?

public class Problem003 {
	
	public static boolean isPrime(long a) {
		for (long i = 2; i < a / 2; i ++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		long i = 600851475143L;
		
		for (long a = 2; a < 600851475143L / 2; a++) {
			if (i % a == 0 && isPrime(a)) {
				System.out.println(a);
			}
		}
		
		System.out.println("The largest prime factor of 600851475143 is the last number above ^");
		
	}

}

//Answer: 6857