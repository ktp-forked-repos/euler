//The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
//There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
//How many circular primes are there below one million?

package problem035;

public class Problem035 {
	
	public static int rotate(int i) {
		String str = "" + i;
		
		if (str.length() < 2) {
			return Integer.parseInt(str);
		}
		
		char temp = str.charAt(0);
		str = str.substring(1, str.length()) + temp;
		return Integer.parseInt(str);
	}
	
	public static boolean isPrime(int n) {
		if (n < 2) return false;
		if (n == 2) return true;
		if (n % 2 == 0) return false;
		for (int i = 3; i * i <= n; i += 2) {
	        if (n % i == 0) {
			    return false;
			}
				
		}
		return true;
	}
	
	public static boolean containsEvenDigit(int i) {
		String str = i + "";
		for (char c : str.toCharArray()) {
			if (Integer.parseInt("" + c) % 2 == 0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int count = 1;
		for (int i = 0; i < 1_000_000; i++) {
			if (containsEvenDigit(i)) {
				continue;
			}
			int rotation = i;
			boolean isCircularPrime = true;
			if (isPrime(rotation)) {
				rotation = rotate(rotation);
				while (rotation != i) {
					if (!isPrime(rotation)) {
						isCircularPrime = false;
						break;
					}
					rotation = rotate(rotation);
				}
			} else {
				isCircularPrime = false;
			}
			
			if (isCircularPrime) {
				count++;
			}
		}
		
		System.out.println(count);


		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println("Completed in: " + duration + "ms");
	}
	
	
}
//Answer: 55
