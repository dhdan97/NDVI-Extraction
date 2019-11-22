package extractNDVI;

import java.util.SplittableRandom;

public class FileInfo {
	// Testing
	public static void main(String[] args) {
		FileInfo test = new FileInfo("US_eMTH_NDVI.2000.070-076.QKM.VI_ACQI.005.2009220150303.tif");
		System.out.println(test.getYear());
		System.out.println(test.getStartDay());
		System.out.println(test.getEndDay());
		System.out.println(test.getExtension());
		System.out.println(test.calcMonth());
	}
	private static final int month[]= {31,28,31,30,31,30,31,31,30,31,30,31}; // Array containing the number of days in each month
	private int year; // Current year in file
	private int startDay; // Start day in file
	private int endDay; // End day in in file
	private String extension; // Extension of the given file
	FileInfo(){
		year = 0;
		startDay = 0;
		endDay = 0;
		extension = "";
	}
	FileInfo(String fileName){
		year = Integer.parseInt(fileName.substring(13, 17));
		startDay = Integer.parseInt(fileName.substring(18, 21));
		endDay = Integer.parseInt(fileName.substring(22, 25));
		extension = fileName.substring(55);
	}
	private static String formatValue(Integer i){
		if(i >= 1 && i <= 9){
			return "0" + i.toString();
		}
		return i.toString();
	}
	public String getWeek(){
		int week = getStartDay()/7;
		return formatValue(week);
	}
	public int getYear(){
		return year;
	}
	public int getStartDay(){
		return startDay;
	}
	public int getEndDay() {
		return endDay;
	}
	public String getExtension() {
		return extension;
	}
	public String calcMonth(){
		if(startDay == 0){ return  "01"; } // Base case when the day is 0
		int i = 0; // Index of the current month
		int daySum = 0; // Sum of the months gone by
		int monthLength = month.length;
		// Checking if we are in a leap year, if so then we roll a day back because we have an extra day
		if(year%4 == 0 && year%400 == 0){
			startDay--;
		}
		// Iterate through the month array days until the start day is not longer greater than the sum of the months
		// Also, make sure that i is a valid index for the month array
		while(startDay > daySum && i < monthLength){
			daySum+=month[i++];
		}
		return formatValue(i);
	}
}
