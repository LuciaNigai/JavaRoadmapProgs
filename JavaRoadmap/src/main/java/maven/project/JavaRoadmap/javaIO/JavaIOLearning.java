package maven.project.JavaRoadmap.javaIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class demonstartes the usage of java.io package classes
 * @version 1.0
 * @since 2024-04-05
 */
public class JavaIOLearning {
	public static void main(String[] args) {
		String path = "C:\\Users\\luchi\\git\\javaroadmap\\JavaRoadmap\\src\\main\\java\\maven\\project\\JavaRoadmap\\resources\\workingWithFiles1.txt";
		int letterA = 65;

//		Writing byte to file
		writeByteToFile(path, letterA);

//	    Writing string to file
		writeStringToFile(path, "Writing String data to file using FileOuputStream");
		
//		write stirng to file using BufferedOutputStream
		writeToFileBufferedOutputStream(path, "Writing to file usign BufferedOutputStream");
		
//		Reading from file a single character
		readFromFileSingleCharacter(path);
		
//		readinf from file all characters
		readFromFileAllCharacters(path);
		
//		reading from file using BufferedInputStream
		readFromFileBufferedInputStream(path);
				
	}

	/**
	 * The method demonstrates writing bytes to file using FileOutputStream
	 * 
	 * @param path file path
	 * @param b    byte to be writen to file
	 */
	public static void writeByteToFile(String path, int b) {
		try {
			FileOutputStream fout = new FileOutputStream(path);
			fout.write(b);
			fout.close();
			System.out.println("Success..");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The method demosntates writing String to file using FileOutputStream
	 * 
	 * @param path file path
	 * @param data String to be writen
	 */
	public static void writeStringToFile(String path, String data) {
//		to write String data to file using FileOutputStream, we
//		need first to convert this String into byte Array
//		we can do so by using getBytes() method of the String class
		try {
			FileOutputStream foutString = new FileOutputStream(path);
			byte b[] = data.getBytes();
			foutString.write(b);
			foutString.close();
			System.out.println("Writen the string to file using OutputStream");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The method demonstrates the process of writing to file using the BufferedOutputStream
	 * @param path
	 */
		public static void writeToFileBufferedOutputStream(String path, String text) {
			try {
				FileOutputStream fout = new FileOutputStream(path);
				BufferedOutputStream bout = new BufferedOutputStream(fout);
				
				byte[] b = text.getBytes();
				
				bout.write(b);
				bout.flush();
				bout.close();
				fout.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Writen stirng to file using BufferedOutputStream");
		}
	
/**
 * The method demosntrates the process of reading single character from file using FileInputStream
 * @param path path to file
 */
	public static void readFromFileSingleCharacter(String path) {
		try {
			FileInputStream fin = new FileInputStream(path);
			int i = fin.read();
			System.out.println((char)i);
			fin.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
/**
 * The method demonstrates the process of reading all characters from file using FileInputStream
 * @param path path to file
 */
	public static void readFromFileAllCharacters(String path) {
		try {
			FileInputStream fin = new FileInputStream(path);
			int i=0;
//			The read method reads the byte data from the input stream
//			 and returns the byte read as integer (0-255), or -1
//			if the end of the sream has been reached.
//			so in this method we are reading from file until the 
//			fin.read() does not return -1
			while((i=fin.read())!=-1) {
				System.out.print((char)i);
			}
			System.out.println();
			fin.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void readFromFileBufferedInputStream(String path) {
		try {
			FileInputStream fin = new FileInputStream(path);
			BufferedInputStream bin = new BufferedInputStream(fin);
			int i;
			while((i=bin.read())!=-1) {
				System.out.print((char)i);
			}
			bin.close();
			fin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
