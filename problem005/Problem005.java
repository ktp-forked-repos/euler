package problem005;

//2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

public class Problem005 {

	public static void main(String[] args) {

		int[] numbers = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
		
		boolean found = false;
		long current = 1;
				
		while (found == false) {
			boolean works = true;
			for (int num : numbers) {
				if (current % num != 0) {
					works = false;
					break;
				}
			}
			
			if (works) {
				found = true;
				break;
			} else {
				current++;
			}
		}
		
		System.out.println(current);

	}

}

//Answer: 232792560