package problem024;

//A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
//012   021   102   120   201   210
//What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

import java.util.ArrayList;
import java.util.Arrays;




public class Problem024 {
	
	public static int index = 1;
	static long startTime = System.nanoTime();

	public static void nextNumber(String perm, ArrayList<Integer> remaining) {
		if (remaining.size() == 0) {
			if (index == 1_000_000) {
				System.out.println(perm);
				long endTime = System.nanoTime();
				System.out.println("Took "+(endTime - startTime) + " ns");
				System.exit(0);
			}
			index++;
			return;
		}
		for (int i = 0; i < remaining.size(); i++) {
			String newPerm = perm;
			newPerm += remaining.get(i);
			ArrayList<Integer> nextRemaining = new ArrayList<Integer>();
			nextRemaining.addAll(remaining);
			nextRemaining.remove(i);
			nextNumber(newPerm, nextRemaining);
		}		
	}

	public static void main(String[] args) {

		ArrayList<Integer> ints = new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
		
		nextNumber("", ints);
		

	}
}

//Answer: 2783915460
