package extractNDVI;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ExtractDriver {

	public ExtractDriver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		String hpumasrc = "C:\\Users\\pumah\\Desktop\\Src_Folder";
		//Acquire directory; better not to hard code this since I will be creating my own sample directories
		System.out.println("Please enter directory:");
		Path path = Paths.get(input.nextLine());
		input.close();
		
		//have Henry insert his own path and change the string
		String dhdanPath = "F:\\FellowshipWork-Daniel.h\\NDVI Data\\2000\\RenamedData";
		String hpumaPath = "C:\\Users\\pumah\\Desktop\\Dump_Folder";
		Path dst = Paths.get(hpumaPath).toAbsolutePath();
		
		//if valid extraction directory and valid output directory
		if(Files.exists(path) && Files.isDirectory(path) && Files.exists(dst) && Files.isDirectory(dst)) {
			System.out.printf("%nDirectory Contents:%n");
			
			//for every folder in extraction directory
			DirectoryStream<Path> mainStream = Files.newDirectoryStream(path);
			for(Path i : mainStream) {
				System.out.println(i.getFileName());
				NDVI.moveToDirectory(i, dst);
				
//				for every file inside the output directory
//				DirectoryStream<Path> innerStream = Files.newDirectoryStream(dst);
//				for(Path j : innerStream) {
//					System.out.println("	" + j.getFileName());
//				}
			}
			NDVI.renameFiles(dst);
		}
	}

}
