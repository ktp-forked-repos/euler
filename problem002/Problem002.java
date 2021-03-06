package problem002;

//Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
//1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
//By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.

public class Problem002 {

	public static void main(String[] args) {
		
		int last = 0;
		int current = 1;
		int evenSum = 0;
		
		while (current < 4000000) {
			int temp = current;
			current += last;
			last = temp;
			
			if (current % 2 == 0) {
				evenSum += current;
			}
			
			System.out.println(current);
			
		}
		
		System.out.println("Sum of even Fibonacci numbers less than 4,000,000: " + evenSum);
		
		
	}

}

//Answer: 4613732
