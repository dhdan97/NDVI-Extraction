//import java.io.IOException;

public class NDVI {
	private int year;
	private int beginDay;
	private int endDay;
	private String dataType;

	public NDVI(String fileName) {
		year = Integer.parseInt(fileName.substring(13, 17));
		beginDay = Integer.parseInt(fileName.substring(19, 21));
		endDay = Integer.parseInt(fileName.substring(23, 25));
		dataType = fileName.substring(55);
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
//		String filename = "US_eMTH_NDVI.2000.056-062.QKM.VI_NDVI.005.2009221053420.tif.aux.xml";
//		
//		NDVI n1 = new NDVI(filename);
//		
//		System.out.println(n1.getBeginDay());
//		System.out.println(n1.getEndDay());
//		System.out.println(n1.getYear());
//		System.out.println(n1.getDataType());
//	}
}
