package extractNDVI;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;

public class NDVI {

	public NDVI() {
		// TODO Auto-generated constructor stub
	}
	
//	public boolean isValid(String fileName) {
//		if(fileName.contains(".QKM.VI_NDVI.005.") && !k.getFileName().toString().contains(".jpg")) {
//			return true;
//		}
//	}
	public static void renameFiles(Path outputFolder) throws IOException {
		DirectoryStream<Path> directoryStream = Files.newDirectoryStream(outputFolder);
		
		//for every file in output folder
		for(Path p : directoryStream) {
			
			//if not already renamed(ie filename does not contain "US", get FileInfo
			if(p.getFileName().toString().contains("US")) {
				FileInfo n1 = new FileInfo(p.getFileName().toString());
				System.out.println("Data Range: Days " + n1.getStartDay() + "-" + n1.getEndDay());
				System.out.println("Year: " + n1.getYear());
				
				//if .met file
				if(p.getFileName().toString().contains(".met")) {
					File f1 = new File(p.toString().replace(p.getFileName().toString(), "") + n1.getYear() + n1.calcMonth() + (n1.getWeek() + ".met"));
					p.toFile().renameTo(f1);
				}
				//if .tif.xml
				if(p.getFileName().toString().contains(".tif.xml")) {
					File f1 = new File(p.toString().replace(p.getFileName().toString(), "") + n1.getYear() + n1.calcMonth() + (n1.getWeek() + ".tif.xml"));
					p.toFile().renameTo(f1);
				}
				//if .tif
				if(p.getFileName().toString().contains(".tif") && !p.getFileName().toString().contains(".xml") && !p.getFileName().toString().contains(".ovr")) {
					File f1 = new File(p.toString().replace(p.getFileName().toString(), "") + n1.getYear() + n1.calcMonth() + (n1.getWeek() + ".tif"));
					p.toFile().renameTo(f1);
				}
				if(p.getFileName().toString().contains(".tif.aux.xml")) {
					File f1 = new File(p.toString().replace(p.getFileName().toString(), "") + n1.getYear() + n1.calcMonth() + (n1.getWeek()+ ".tif.aux.xml"));
					p.toFile().renameTo(f1);
				}
				if(p.getFileName().toString().contains(".tif.ovr") && p.getFileName().toString().contains("US")) {
					File f1 = new File(p.toString().replace(p.getFileName().toString(), "") + n1.getYear() + n1.calcMonth() + (n1.getWeek()+ ".tif.ovr"));
					p.toFile().renameTo(f1);
				}	
			}
		}
	}
	//accepts a src path(single folder) and copies proper .tif file to dst directory
	public static void moveToDirectory(Path src, Path dst) throws IOException {
		DirectoryStream<Path> directoryStream1 = Files.newDirectoryStream(src);
		
		//for every file in single folder
		for(Path k : directoryStream1) {
			if(k.getFileName().toString().contains(".QKM.VI_NDVI.005.") && !k.getFileName().toString().contains(".jpg")) {
				System.out.println(k);
				FileUtils.copyFileToDirectory(k.toFile(), dst.toFile());
			}
		}
	}

}