package maven.project.JavaRoadmap.javaStuff;

//In Java, Exception is an unwanted or unexpected event, 
//	which occurs during the execution of a program, i.e. 
//	at run time, that disrupts the normal flow of the program’s 
//  instructions.


/*
 * Error vs Exception
 * 
 *  Error: An Error indicates a serious problem that a reasonable application should not try to catch.
 *  Exception: Exception indicates conditions that a reasonable application might try to catch.
 */

/*
 * All exception and error types are subclasses of the class Throwable, which is the base class of the hierarchy.
 * */

/*
 * Exception categories
 * 
 *  Built-in Exceptions
     *  Checked Exception (are checked at compile time)
     *  Unchecked Exception (are checked at runtime)
 *  User-Defined Exceptions

 * */

/*
 * Checked Exceptions: Checked exceptions are called compile-time exceptions because these exceptions are checked 
 * at compile-time by the compiler.
     
  *Unchecked Exceptions: The unchecked exceptions are just opposite to the checked exceptions. The compiler will 
  *not check these exceptions at compile time. In simple words, if a program throws an unchecked exception, and 
  *even if we didn’t handle or declare it, the program would not give a compilation error.
  
 * */

/*
 * Program statements that you think can raise exceptions are contained within a try block. 
 * If an exception occurs within the try block, it is thrown. Your code can catch this exception(using CATCH BLOCK) 
 * and handle it in some rational manner. 
 * System-generated exceptions are automatically thrown by the Java run-time system. 
 * To manually throw an exception, use the keyword THROW. Any exception that is thrown out of a method must be 
 * specified as such by a THROWS clause. Any code that absolutely must be executed after a try block completes 
 * is put in a FINALLY BLOCK.
 */

/*
 * ---------EXCEPTION HANDLING WITH METHOD OVERRIDING-----------
 *   ---if the superclass method does not declare an exception, the subclass overriden method cannot declare the checked exception, but it can declare unchecked exception.
 *   ---if the superclass method declares an exception, the subclass overriden method can declare same, subclass exception or no exception, but cannot declare parent exception.
 * */





/**
 * Class that demonstrates the methods to print the exceptions
 * 
 * @since 2024-04-02
 */
public class ExceptionHandling {

	public static void main(String... args) {
		getExceptionPrintStackTravce(4, 0);
		getExcepctionToString(5, 0);
		getExceptionGetMessage(8, 0);
//		if there is more than one exception to be caught
//		we need to move from more specific exceptions towards
//		more general ones
		try {
			arrayExc(new int[] { 1, 2, 3, 4, 5 });
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		System.out.println("Hello");
		
		try {
			validateAge(13);
		} catch (AgeException e) {
			e.printStackTrace();
		}
		try {
			validateAge(80);
		} catch (AgeException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method demonstartes the usage of printStackTrace() for exception printiong
	 * 
	 * @param a int
	 * @param b int
	 */
	public static void getExceptionPrintStackTravce(int a, int b) {
		try {
			System.out.println(a / b);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metjod demonstartes the usage of toStirng() for exception printing
	 * 
	 * @param a
	 * @param b
	 */
	public static void getExcepctionToString(int a, int b) {
		try {
			System.out.println(a / b);
		} catch (ArithmeticException e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Method demonstrates the usage of getMessage() from exception printing
	 * 
	 * @param a
	 * @param b
	 */
	public static void getExceptionGetMessage(int a, int b) {
		try {
			System.out.println(a / b);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void arrayExc(int[] arr) {
		for (int i = 0; i <= arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	/**
	 * Method that demonstates the usage of the custom exception
	 * @param age the agen to be checked 
	 * @throws AgeException if the age is less than 18 or bigger than 6
	 */
	private static void validateAge(int age) throws AgeException{
		if(age<18) {
			throw new AgeException();
		}
		if(age>65) {
			throw new AgeException("You're too old");
		}
	}
}

/**
 * Class demonstrates the creation of a custom exception
 * To create a custom eaception we need to extend Exception class that belongs to java.lang.package
 * you can also override the necessaery superclass constructors
 * Note that you should try to extend the type of exception that already exists and is is closest to your custom exception
 * @since 2024-04-04
 */
class AgeException extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AgeException() {
		super();
	}
	public AgeException(String message) {
		super(message);
	}
	
	public AgeException(Throwable cause) {
		super(cause);
	}
}
