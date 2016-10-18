package problem017;

//If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
//If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
//NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.

import java.util.HashMap;

public class Problem017 {

	public static void main(String[] args) {
		HashMap<Character, String> ones = new HashMap<Character, String>();
		ones.put('0', "");
		ones.put('1', "one");
		ones.put('2', "two");
		ones.put('3', "three");
		ones.put('4', "four");
		ones.put('5', "five");
		ones.put('6', "six");
		ones.put('7', "seven");
		ones.put('8', "eight");
		ones.put('9', "nine");
		
		HashMap<Character, String> tens = new HashMap<Character, String>();
		tens.put('0', "");
		tens.put('2', "twenty");
		tens.put('3', "thirty");
		tens.put('4', "forty");
		tens.put('5', "fifty");
		tens.put('6', "sixty");
		tens.put('7', "seventy");
		tens.put('8', "eighty");
		tens.put('9', "ninety");

		HashMap<Character, String> teens = new HashMap<Character, String>();
		teens.put('0', "ten");
		teens.put('1', "eleven");
		teens.put('2', "twelve");
		teens.put('3', "thirteen");
		teens.put('4', "fourteen");
		teens.put('5', "fifteen");
		teens.put('6', "sixteen");
		teens.put('7', "seventeen");
		teens.put('8', "eighteen");
		teens.put('9', "nineteen");

		HashMap<Character, String> hundreds = new HashMap<Character, String>();
		hundreds.put('1', "onehundred");
		hundreds.put('2', "twohundred");
		hundreds.put('3', "threehundred");
		hundreds.put('4', "fourhundred");
		hundreds.put('5', "fivehundred");
		hundreds.put('6', "sixhundred");
		hundreds.put('7', "sevenhundred");
		hundreds.put('8', "eighthundred");
		hundreds.put('9', "ninehundred");
		
		String fullString = "";
		
		for (int i = 1; i <= 1000; i++) {
			String thisNum = i + "";
			
			if (thisNum.length() == 1) {
				fullString += ones.get(thisNum.charAt(0));
			} else if (thisNum.length() == 2) {
				if (thisNum.charAt(0) == '1') {
					fullString += teens.get(thisNum.charAt(1));
				} else {
					fullString += tens.get(thisNum.charAt(0));
					fullString += ones.get(thisNum.charAt(1));
				}
			} else if (thisNum.length() == 3) {
				fullString += hundreds.get(thisNum.charAt(0));
				if (!(thisNum.charAt(1) == '0' && thisNum.charAt(2) == '0')) {
					fullString += "and";
				}
				if (thisNum.charAt(1) == '1') {
					fullString += teens.get(thisNum.charAt(2));
				} else {
					fullString += tens.get(thisNum.charAt(1));
					fullString += ones.get(thisNum.charAt(2));
				}
			} else {
				fullString += "onethousand";
			}
		}
		System.out.println(fullString.length());
	}
}

//Answer: 21124