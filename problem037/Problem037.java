package problem037;

public class Problem037 {
	
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
	
	public static boolean isPossibleTruncPrime(int i) {
		String str = i + "";
		if (str.charAt(0) == '1' || str.charAt(str.length() - 1) == '1') {
			return false;
		}
		
		return true;
	}
	

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		int count = 0;
		int sum = 0;
		int i = 11;
		
		while (count < 11) {
			boolean isTruncPrime = true;
			if (isPossibleTruncPrime(i)) {
				String truncatedLeft = i + "";
				String truncatedRight = i + "";

				while (!truncatedRight.equals("")) {


					if (!isPrime(Integer.parseInt(truncatedRight))) {
						isTruncPrime = false;
						break;
					} else if (!isPrime(Integer.parseInt(truncatedLeft))) {

						isTruncPrime = false;
						break;
					}
					truncatedLeft = truncatedLeft.substring(1, truncatedLeft.length());
					truncatedRight = truncatedRight.substring(0, truncatedRight.length() - 1);
				}
			} else {
				isTruncPrime = false;
			}
			
			if (isTruncPrime) {
				count++;
				sum += i;
			}
			
			i += 2;
		}

		System.out.println(sum);
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println("Completed in: " + duration + "ms");
	}

}
//Answer: 748317
