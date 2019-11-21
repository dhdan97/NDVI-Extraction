import java.io.IOException;
import java.util.stream.IntStream; 


public class NDVI {
	private int year;
	private int month;
	private int beginDay;
	private int endDay;
	private String dataType;

	public NDVI(String fileName) {
		year = Integer.parseInt(fileName.substring(13, 17));
		
		beginDay = Integer.parseInt(fileName.substring(18, 21));//19 - 21 works for 2 digits, 18 - 21 works for 3 (?)
		
		endDay = Integer.parseInt(fileName.substring(22, 25));// 23 - 25 works for 2 digits, 22 - 25 works for 3 (?)
		dataType = fileName.substring(55);
	}
	
//	private int calculateMonth() {
//		switch(this.beginDay) {
//		IntStream s = new IntStream(1,2);
//		case(IntStream(1,2)):
//			
//		}
//		
//	}
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}

	public int getBeginDay() {
		return beginDay;
	}

	public int getEndDay() {
		return endDay;
	}

	public String getDataType() {
		return dataType;
	}

//	public static void main(String[] args) throws IOException {
//		String filename = "US_eMTH_NDVI.2000.006-009.QKM.VI_NDVI.005.2009221053420.tif.aux.xml";
//		
//		NDVI n1 = new NDVI(filename);
//		
//		System.out.println(n1.getBeginDay());
//		System.out.println(n1.getEndDay());
//		System.out.println(n1.getYear());
//		System.out.println(n1.getDataType());
//	}
}
