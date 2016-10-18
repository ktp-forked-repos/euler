package problem022;

//Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
//For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
//What is the total of all the name scores in the file?

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem022 {
	
	public static boolean isInOrder(String str1, String str2) {
		boolean foundOrder = false;
		int checkingLetter = 0;
		while (!foundOrder) {
			if (str1.length() == checkingLetter) {
				return true;
			} else if (str2.length() == checkingLetter) {
				return false;
			} else {
				if (str1.charAt(checkingLetter) < str2.charAt(checkingLetter)) {
					return true;
				} else if (str1.charAt(checkingLetter) > str2.charAt(checkingLetter)) {
					return false;
				}
			}
			checkingLetter++;
		}
		return true;
	}
	
	public static ArrayList<String> quicksort(ArrayList<String> names) {
		ArrayList<String> beforePivot = new ArrayList<String>();
		ArrayList<String> afterPivot = new ArrayList<String>();
		if (names.size() < 2) {
			return names;
		}
		
		String pivot = names.get(0);
		
		
		
		for (int i = 1; i < names.size(); i++) {
			if (isInOrder(names.get(i), pivot)) {
				beforePivot.add(names.get(i));
			} else {
				afterPivot.add(names.get(i));
			}
		}
		
		ArrayList<String> sorted = new ArrayList<String>();
		
		sorted.addAll(quicksort(beforePivot));
		sorted.add(pivot);
		sorted.addAll(quicksort(afterPivot));
		
		return sorted;
	}
	
	

	public static void main(String[] args) {
		
		String names = "";
		try(BufferedReader br = new BufferedReader(new FileReader("/Users/kiran/Desktop/Programming/Eclipse Workspace/Project Euler/src/problem022/names.txt"))) {
		    names = br.readLine().replace("\"", "");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ArrayList<String> splitNames = new ArrayList<String>(Arrays.asList(names.split(",")));
		
		splitNames = quicksort(splitNames);
		
		long sumOfScores = 0;
		for (int i = 0; i < splitNames.size(); i++) {
			int sumOfLetters = 0;
			for (char c : splitNames.get(i).toCharArray()) {
				sumOfLetters += (int)c - 64;
			}
			sumOfScores += sumOfLetters * (i + 1); 
			
		}
				
		System.out.println(sumOfScores);
	}

}

//Answer: 871198282
