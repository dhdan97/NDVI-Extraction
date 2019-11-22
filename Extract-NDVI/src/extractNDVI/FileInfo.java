package extractNDVI;

public class FileInfo {
	private int year;
	private int beginDay;
	private int endDay;
	String dataType;
	FileInfo(String fileName){
		year = Integer.parseInt(fileName.substring(13, 17));
		beginDay = Integer.parseInt(fileName.substring(19, 21));
		endDay = Integer.parseInt(fileName.substring(23, 25));
		beginDay = Integer.parseInt(fileName.substring(18, 21));
		endDay = Integer.parseInt(fileName.substring(22, 25));
		dataType = fileName.substring(55);
	}

}
