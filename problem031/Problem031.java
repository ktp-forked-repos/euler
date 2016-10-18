package problem031;

//In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
//1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
//It is possible to make £2 in the following way:
//1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
//How many different ways can £2 be made using any number of coins?


public class Problem031 {

	public static void main(String[] args) {
		;long startTime = System.currentTimeMillis();
		long combinations = 1;
		for (int onePence = 0; onePence <= 200; onePence++) {
			for (int twoPence = 0; twoPence <= 100; twoPence++) {
				for (int fivePence = 0; fivePence <= 40; fivePence++) {
					for (int tenPence = 0; tenPence <= 20; tenPence++) {
						for (int twentyPence = 0; twentyPence <= 10; twentyPence++) {
							for (int fiftyPence = 0; fiftyPence <= 4; fiftyPence++) {
								for (int onePound = 0; onePound <= 2; onePound++) {
									if (onePence + (2 * twoPence) + (5 * fivePence) + (10 * tenPence) + (20 * twentyPence) + (50 * fiftyPence) + (100 * onePound) == 200) {
										combinations++;
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(combinations);
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println("Completed in: " + duration + "ms");
	}

}

//Answer: 73682
