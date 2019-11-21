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
		
                String dhdan_path;
                String dhdan_dst;
                String hpuma_path = "C:\\Users\\pumah\\Desktop\\US_eMTH_NDVI.2000.056-062.QKM.COMPRES.005.2009221053420";
                String hpuma_dst =  "C:\\Users\\pumah\\Desktop\\Dump_Folder";
                
		System.out.println("Please enter directory:");
		Path path = Paths.get(hpuma_path);
		
		//System.out.println("Please enter destination:");
		Path dst = Paths.get(hpuma_dst).toAbsolutePath();
		
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
					
					if(p.getFileName().toString().contains("US")) {
						System.out.println(p.getFileName().toString());
						NDVI n1 = new NDVI(p.getFileName().toString());
						System.out.println("Data Range: Days " + n1.getBeginDay() + "-" + n1.getEndDay());
						System.out.println("Year: " + n1.getYear());
					
					
					
						//have to put if (contains US) to not fuck with already renamed files
						if(p.getFileName().toString().contains(".met") && p.getFileName().toString().contains("US")) {
							//System.out.println(file.getDayRange());
							//File f0 = new File(dst.toString());
							File f1 = new File(p.toString().replace(p.getFileName().toString(), "") + n1.getYear() + "0" + (n1.getBeginDay()/7) + ".met");
							//f0.renameTo(f1);
							p.toFile().renameTo(f1);
						}
						if(p.getFileName().toString().contains(".tif.xml") && p.getFileName().toString().contains("US")) {
							//System.out.println(file.getDayRange());
							File f1 = new File(p.toString().replace(p.getFileName().toString(), "") + n1.getYear() + "0" + (n1.getBeginDay()/7) + ".tif.xml");
							p.toFile().renameTo(f1);
						}
						if(p.getFileName().toString().contains(".tif") && !p.getFileName().toString().contains(".xml") && !p.getFileName().toString().contains(".ovr") && p.getFileName().toString().contains("US")) {
							//System.out.println(p);
							File f1 = new File(p.toString().replace(p.getFileName().toString(), "") + n1.getYear() + "0" + (n1.getBeginDay()/7) + ".tif");
							p.toFile().renameTo(f1);
						}
						if(p.getFileName().toString().contains(".tif.aux.xml") && p.getFileName().toString().contains("US")) {
							//System.out.println(p);
							File f1 = new File(p.toString().replace(p.getFileName().toString(), "") + n1.getYear() + "0" + (n1.getBeginDay()/7)+ ".tif.aux.xml");
							p.toFile().renameTo(f1);
						}
						if(p.getFileName().toString().contains(".tif.ovr") && p.getFileName().toString().contains("US")) {
							//System.out.println(p);
							File f1 = new File(p.toString().replace(p.getFileName().toString(), "") + n1.getYear() + "0" + (n1.getBeginDay()/7)+ ".tif.ovr");
							p.toFile().renameTo(f1);
						}
					}
				}
			}
			
		}
		else {
			System.out.println("Directory does not exist");
		}
	}
}
