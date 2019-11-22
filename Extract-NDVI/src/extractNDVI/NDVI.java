package extractNDVI;

import org.apache.commons.io.FileUtils;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class NDVI {

	public NDVI() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isValid(String fileName) {
		if(fileName.contains(".QKM.VI_NDVI.005.") && !k.getFileName().toString().contains(".jpg")) {
			return true;
		}
	}
	
	public void moveToDirectory(DirectoryStream<Path> directory) {
		DirectoryStream<Path> directoryStream1 = Files.newDirectoryStream(i);//added .getFileName()
		for(Path k : directoryStream1) {
			if(k.getFileName().toString().contains(".QKM.VI_NDVI.005.") && !k.getFileName().toString().contains(".jpg")) {
				System.out.println(k);
				FileUtils.copyFileToDirectory(k.toFile(), dst.toFile());
			}
		}
	}

}
