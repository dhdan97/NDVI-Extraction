import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class ExtractNDVI {
	
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter directory:");
		Path path = Paths.get(input.nextLine());
		
		//System.out.println("Please enter destination:");
		Path dst = Paths.get("F:\\FellowshipWork-Daniel.h\\NDVI Data\\2000\\RenamedData").toAbsolutePath();
		
		if(Files.exists(path) && Files.isDirectory(path) && Files.exists(dst) && Files.isDirectory(dst)) {
			System.out.printf("%nDirectory Contents:%n");
			
			DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
			
			for(Path p : directoryStream) {
				System.out.println(p.getFileName());
			}
			
			System.out.printf("Continue?[y/n]%n");
			String answer = input.nextLine();
			input.close();
			if(answer.equals("y")) {
				
				//copying .tif to directory(should work)
				DirectoryStream<Path> directoryStream1 = Files.newDirectoryStream(path);//added .getFileName()
				for(Path p : directoryStream1) {
					if(p.getFileName().toString().contains(".QKM.VI_NDVI.005.") && !p.getFileName().toString().contains(".jpg")) {
						System.out.println(p);
						FileUtils.copyFileToDirectory(p.toFile(), dst.toFile());
					}
				}
				
				DirectoryStream<Path> directoryStream2 = Files.newDirectoryStream(dst);
				for(Path p : directoryStream2) {
					
					System.out.println(p.getFileName().toString());
					NDVI n1 = new NDVI(p.getFileName().toString());
					System.out.println("Data Range: Days " + n1.getBeginDay() + "-" + n1.getEndDay());
					System.out.println("Year: " + n1.getYear());
					
					if(p.getFileName().toString().contains(".met")) {
						//System.out.println(file.getDayRange());
						File f1 = new File(p.toString() + n1.getYear() + "0" + (n1.getBeginDay()/7) + ".met");
						p.toFile().renameTo(f1);
					}
					if(p.getFileName().toString().contains(".tif.xml")) {
						//System.out.println(file.getDayRange());
						File f1 = new File(p.toString() + n1.getYear() + "0" + (n1.getBeginDay()/7) + ".tif.xml");
						p.toFile().renameTo(f1);
					}
					if(p.getFileName().toString().contains(".tif") && !p.getFileName().toString().contains(".xml") && !p.getFileName().toString().contains(".ovr")) {
						//System.out.println(p);
						File f1 = new File(p.toString() + n1.getYear() + "0" + (n1.getBeginDay()/7) + ".tif");
						p.toFile().renameTo(f1);
					}
					if(p.getFileName().toString().contains(".tif.aux.xml")) {
						//System.out.println(p);
						File f1 = new File(p.toString() + n1.getYear() + "0" + (n1.getBeginDay()/7)+ ".tif.aux.xml");
						p.toFile().renameTo(f1);
					}
					if(p.getFileName().toString().contains(".tif.ovr")) {
						//System.out.println(p);
						File f1 = new File(p.toString() + n1.getYear() + "0" + (n1.getBeginDay()/7)+ ".tif.ovr");
						p.toFile().renameTo(f1);
					}
				}
			}
			
		}
		else {
			System.out.println("Directory does not exist");
		}
	}
}
