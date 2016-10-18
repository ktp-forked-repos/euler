package problem026;

//A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
//1/2	= 	0.5
//1/3	= 	0.(3)
//1/4	= 	0.25
//1/5	= 	0.2
//1/6	= 	0.1(6)
//1/7	= 	0.(142857)
//1/8	= 	0.125
//1/9	= 	0.(1)
//1/10	= 	0.1
//Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
//Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Problem026 {
	
	public static int getReptendLength(BigDecimal d) {
		d = BigDecimal.ONE.divide(d, 2_000, RoundingMode.HALF_UP);
		String decimal = d.toString().substring(2);		
		boolean foundReptend = false;
		int reptendLength = 0;
		
		while (!foundReptend) {
			Searching: 
				for (int i = 0; i < 500; i++) {
					for (int j = i + 1; j < 1000; j++) {
						if (decimal.charAt(i) == decimal.charAt(j)) {
							int period = j - i;
							boolean repeats = true;
							
							for (int test = 0; test < 2_000 - period - j; test += period) {
								if (! decimal.substring(i + test, j + test).equals(decimal.substring(j + test, j + test + period))) {
									repeats = false;
									break;
								}
							}
							
							if (repeats) {
								foundReptend = true;
								reptendLength = period;
								break Searching;
							}	
						}
					}
				}
		}
		
		return reptendLength;
	}

	public static void main(String[] args) {
		int longestD = 0;
		int longestReptend = 0;
		for (int d = 2; d < 1000; d ++) {
			BigDecimal a = new BigDecimal("" + d);
			int reptendLength = getReptendLength(a);
			if (reptendLength > longestReptend) {
				longestReptend = reptendLength;
				longestD = d;
			}
		}
		
		System.out.println(longestD);

	}
}

//Answer: 983
