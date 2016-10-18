package problem009;

//A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//a^2 + b^2 = c^2
//For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.

public class Problem009 {

	public static void main(String[] args) {

		for (int a = 1; a < 333; a++) {
			for (int b = a + 1; 1000 - a > 2 * b; b++) {
				int c = 1000 - b - a;
				if ((a * a) + (b * b) == (c * c)) {
					System.out.println(a + ", " + b + ", " + c);
					System.out.println("a * b * c = " + (a * b * c));
					System.exit(0);
				}
			}
		}
	}

}

//Answer: 31875000
