package maven.project.JavaRoadmap.javaIO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;


//	java has two file API's
//		The original java.io.file (since java 1/0)
//		the newer java.nio.file.Path (since java 1.7)

//	java.nio.file.Path does everything java.io.file can, but generaly in a better way and more.
//  the differences between two APIs ->  https://www.oracle.com/technical-resources/articles/javase/nio.html


/**
 * Class demonstrates useful methods for workign with file API
 * @version 0.1
 * @since 2024-04-03
 */
public class LearningFilesAPI {
	/**
	 * demonstrates hte methods fro working with files APIs
	 * @param args
	 * @throws URISyntaxException
	 * @throws IOException
	 */

	public static void main(String[] args) throws URISyntaxException, IOException {
		
		String pathRoot = "C:/Users/luchi/git/javaroadmap/JavaRoadmap/src/main/java/maven/project/JavaRoadmap/resources";

		//		----------------------------------CONSTRUCTING A PATH OBJECT-----------------------------
		
//		Starting java 11 you should use the static--------------- PATH.OF METHOD----------------- to construct paths
//		!!!!IMPORTANT Path.of or Paths.get do not create a new file, they just create a Path object, which then can be used for 
//		various file I\O operations
		Path path = Path.of(pathRoot+"/workingWithFiles1.txt");	
		System.out.println(path);

		path =Path.of(pathRoot+"/workingWithFiles1.txt");
		System.out.println(path);
		
		path = Path.of("C:","Users", "luchi","git","javaroadmap", "JavaRoadmap","src","main","java","maven","project","JavaRoadmap","resources","workingWithFiles1.txt");
		System.out.println(path);
		
		path = Path.of(new URI("file:///"+pathRoot+"/workingWithFiles1.txt"));
		System.out.println(path);
		
//		----------------------RESOLVE METHOD--------- could be used to append the relative path ro already created absolute path
		/*EXAMPLE
		 * Path basePath = Path.of(pathRoot);
		 * Path file1 = basePath.resolve("fileName1.txt");
		 * Path file2 = basePath.resolve("fileName2.txt");
		 * 
		 * */
		
		
//		Pre java-11, Path.of was called -------------PATHS.GET--------------, which you'll need to use if you're stuck on older Java versions
//		or building a library taht needs some backward compatibility. 
//		Starting with java-11, Paths.get internaly redirects to Path.get
		/*EXAMPLE
		 * path = Paths.get(pathRoot+"/workingWithFiles1.txt");
		 * System.out.println(path);
		 */
		
//		------------------------------------COMMON FILE OPERATIONS-------------------------------
//		FILES.EXISTS() -> Checks if a file or directory exists. Also lets you specify additional parameters, 
//			to define how symlinks are handled, i.e. followed (default) or not.
		boolean exists= Files.exists(path);
		System.out.println("File exists: "+exists);
		
		
//		FILES.GETLASTMODIFIEDTIME()  -> returns the last modified date of the file
		FileTime lastModifiedTime = Files.getLastModifiedTime(path);
		System.out.println("File was last modified at "+lastModifiedTime);
		
//		FILES.MISMATCH() -> (!Java 12+) It compares the sizes and bytes of two files and returns the position of the first 
//			(byte) mismatch. Or, -1L if there was no mismatch.
		long mismatchIndex =Files.mismatch(path, Paths.get(pathRoot+"/workingWithFiles1.txt"));
		System.out.println("mismacth "+mismatchIndex);
		
		
//		FILES.GETOWNER() -> reurns the owner of the file
		UserPrincipal owner = Files.getOwner(path);
		System.out.println("Owner of the file is "+owner);
		
//		--------------------------------------CREATING TEMP FILES-----------------------------
		/*
		 * Note: Temp files, contrary to popular belief, do not delete themselves. You
		 * have to make sure to explicitly delete them, when creating them in unit tests
		 * or when running in production.
		 */
		
//		 By default file is created in the default temp directory,but you can also specify your own directory


		Path tempFile = Files.createTempFile(Path.of(pathRoot),"tempFile", ".txt");
		System.out.println(tempFile);
		
//		another way (will create the temp directory and then the temp file in it)
		Path parentDir = Paths.get(pathRoot);
		Path tmpDirectory = Files.createTempDirectory(parentDir,null);
		System.out.println(tmpDirectory);
		Path tempFile2 = Files.createTempFile(tmpDirectory, "TempFile2", ".txt");
		System.out.println(tempFile2);
		
//		------------------------------CREATING FILES AND DIRECTORIS----------------------------
		Path newDirectory = Files.createDirectories(path.getParent().resolve("NewDir"));
		System.out.println("new directory " +newDirectory);
		
		Path newFile = Files.createFile(newDirectory.resolve("emptyFile.txt"));
		System.out.println("New file "+newFile);
		
		
//		-------------------------------------WRITING TO FILE ---------------------------------------
//		-----------WRITING STRINGS TO FILE
		Files.writeString(tempFile, "this is my string 1 that i write to temp file");
		/*
		 * StandardOpenOption is an enum in Java introduced in Java 7 as part of the java.nio.file package. 
		 * It provides a set of options that specify how a file should be opened or created when working with 
		 * the Files class or the FileChannel class.
		 * */
//		in this case the string is appended to the end of file 
		Files.writeString(tempFile, "\nthis is my string 2 that i write to temp file", StandardOpenOption.APPEND);
		
//		----------WRITING BITES TO FILE
		Files.write(tempFile2, "This is my bites string".getBytes(StandardCharsets.ISO_8859_1));
		
		
//		writing strings to file using BUFFERDERWRITER
//		
		try(BufferedWriter bufferedWriter = Files.newBufferedWriter(path)){
			bufferedWriter.write("Hello world!");
			bufferedWriter.newLine();
			bufferedWriter.write("This is a test");
			bufferedWriter.newLine();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
//		writing byte data using OutputStream
		byte[] rawData = {65,66,67,68,69};
		try(OutputStream os = Files.newOutputStream(path, StandardOpenOption.APPEND)){
			os.write(rawData);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
//		---------------------------------------READING FROM FILES-------------------------
//		reading a tring, if character set is not specified it is considered UTF-8
		String readingString = Files.readString(tempFile);
		System.out.println(readingString);
		
//		or we can specify the character set
		readingString = Files.readString(tempFile, StandardCharsets.ISO_8859_1);
		System.out.println(readingString);
		
//		reading bytes from files
		String readingBytes =new String( Files.readAllBytes(tempFile2),StandardCharsets.UTF_8);
		System.out.println(readingBytes);
	}
}
