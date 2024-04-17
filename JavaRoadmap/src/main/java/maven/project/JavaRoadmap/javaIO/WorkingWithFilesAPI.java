package maven.project.JavaRoadmap.javaIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is an example of use of the learned material on Files API (java.nio.file)
 * @since 2024-04-03
 */
public class WorkingWithFilesAPI {

	public static void main(String[] args) {
		
		Path basePath = Path.of("C:/Users/luchi/git/javaroadmap/JavaRoadmap/src/main/java/maven/project/JavaRoadmap/resources");
		Path file1Path = basePath.resolve("File1.txt");
//		the file does not exists since we did not create it yet
		System.out.println(Files.exists(file1Path));
		
//		we can do it at the same time that we want to write the information to the file
		try {
//			the CREATE enum constant will check iof the file exists it will write to this file, 
//			if not it will create it and then write the data
//			we could also use CREATE_NEW, but it would throw FileAlreadyExistsException if the file already exists
			Files.writeString(file1Path, "This is the string that I want to add first", StandardOpenOption.CREATE);
			Files.writeString(file1Path, "\nSecond String appended to first\n", StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String> list = new ArrayList<>();
		list.add("New line to be added");
		list.add("Third line to be added");
		list.add("Last lien to be added");
		/*
		try {
			for(String line : list) {
				Files.writeString(file1Path, line, StandardOpenOption.APPEND);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		*/
		
//		or using Files.write
		try {
			Files.write(file1Path, list, StandardOpenOption.APPEND);
			System.out.println("File writen succesfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
