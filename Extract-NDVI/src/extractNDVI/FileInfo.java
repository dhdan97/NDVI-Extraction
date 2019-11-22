package extractNDVI;

public class FileInfo {
	private int year;
	private int startDay;
	private int endDay;
	String extension;

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
	public int calcMonth(int startDay, int year){
		boolean isLeapYear = false;
		if(year%4 == 0 && year%400 == 0){
			isLeapYear = true;
		}



		return 0;
	}
}
