package extractNDVI;

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