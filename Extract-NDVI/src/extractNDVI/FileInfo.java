package extractNDVI;

public class FileInfo {
	public static void main(String[] args) {
		FileInfo test = new FileInfo("US_eMTH_NDVI.2000.070-076.QKM.VI_ACQI.005.2009220150303.tif");
		System.out.println(test.getYear());
		System.out.println(test.getStartDay());
		System.out.println(test.getEndDay());
		System.out.println(test.getExtension());
		System.out.println(test.calcMonth());
	}
	private static final int month[]= {31,28,31,30,31,30,31,31,30,31,30,31};
	private int year;
	private int startDay;
	private int endDay;
	private String extension;
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
	public int calcMonth(){
		if(startDay == 0){
			return  1;
		}
		// Index of the current month
		int i = 0;
		// Sum of the months gone by
		int daySum = 0;
		int monthLength = month.length;
		// Checking if we are in a leap year, if so then we roll a day back because we have an extra day
		if(year%4 == 0 && year%400 == 0){
			startDay--;
		}
		while(startDay > daySum && i < monthLength){
			daySum+=month[i++];
		}
		return i;
	}
}
