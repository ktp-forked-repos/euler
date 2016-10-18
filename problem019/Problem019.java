package problem019;

//You are given the following information, but you may prefer to do some research for yourself.
//1 Jan 1900 was a Monday.
//Thirty days has September,
//April, June and November.
//All the rest have thirty-one,
//Saving February alone,
//Which has twenty-eight, rain or shine.
//And on leap years, twenty-nine.
//A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
//How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

import java.util.HashMap;

public class Problem019 {
	
	
	public static HashMap<Integer, Integer> months = new HashMap<Integer, Integer>();
	
	
	public static HashMap<Integer, String> days = new HashMap<Integer, String>();
	
	
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	
	public static int dayToNumber(int day, int month, int year) {
		int totalDays = 0;
		
		for (int i = 1900; i < year; i++) {
			if (isLeapYear(i)) {
				totalDays += 366;
			} else {
				totalDays += 365;
			}
		}
		
		for(int i = 1; i < month; i++) {
			if (i == 2 && isLeapYear(year)) {
				totalDays += 29;
			} else {
				totalDays += months.get(i);
			}
		}
		
	
		totalDays += day;
		
		return totalDays;
	}
	
	public static String toWeekDay(int dayNumber) {
		return days.get(dayNumber % 7);
	}

	public static void main(String[] args) {
		
		months.put(1, 31);
		months.put(2, 28);
		months.put(3, 31);
		months.put(4, 30);
		months.put(5, 31);
		months.put(6, 30);
		months.put(7, 31);
		months.put(8, 31);
		months.put(9, 30);
		months.put(10, 31);
		months.put(11, 30);
		months.put(12, 31);
		
		days.put(1, "Monday");
		days.put(2, "Tuesday");
		days.put(3, "Wednesday");
		days.put(4, "Thursday");
		days.put(5, "Friday");
		days.put(6, "Saturday");
		days.put(0, "Sunday");
		
		int sundays = 0;
		for (int year = 1901; year <= 2000; year ++) {
			for (int month = 1; month <= 12; month++) {
				if (toWeekDay(dayToNumber(1, month, year)).equals("Sunday")) {
					sundays++;
				}
			}
		}
		
		System.out.println(sundays);
				
	}

}

//Answer: 171
