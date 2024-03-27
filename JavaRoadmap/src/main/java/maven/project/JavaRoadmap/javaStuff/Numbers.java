package maven.project.JavaRoadmap.javaStuff;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class demonstrates number formating methods and generation of random numbers
 * @version 1.0
 * @since 226/03/2024
 */
public class Numbers {


	public static void main(String[] args) {
//		formating numeric print output
		
//		the printf and format
//		some of the formating that you can do with formaT
		long n = 461012;
	      System.out.format("%d%n", n);      //  -->  "461012"
	      System.out.format("%08d%n", n);    //  -->  "00461012"
	      System.out.format("%+8d%n", n);    //  -->  " +461012"
	      System.out.format("%,8d%n", n);    // -->  " 461,012"
	      System.out.format("%+,8d%n%n", n); //  -->  "+461,012"
	      
	      double pi = Math.PI;

	      System.out.format("%f%n", pi);       // -->  "3.141593"
	      System.out.format("%.3f%n", pi);     // -->  "3.142"
	      System.out.format("%10.3f%n", pi);   // -->  "     3.142"
	      System.out.format("%-10.3f%n", pi);  // -->  "3.142"
	      System.out.format(Locale.FRANCE,
	                        "%-10.4f%n%n", pi); // -->  "3,1416"

	      Calendar c = Calendar.getInstance();
	      System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"

	      System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"

	      System.out.format("%tD%n", c);    // -->  "05/29/06"
		
//	      DecimalFormat class 
	      customFormat("###,###.###", 123456.789);
	      customFormat("###.##", 123456.789);
	      customFormat("000000.000", 123.78);
	      customFormat("$###,###.###", 12345.67); 
	      
	      
//	     ---------------------------------------- generating random number between 50 and 60--------------------------------------
//	      using Math.random()
//	      it generates pseudo-random double values, so it is not suitable for generating random integers directly (you need to cast the result to int)
	      double randomNumber = Math.random()*11+50;
	      System.out.println("Random number using math.random() "+(int)randomNumber);
	      
//	      using java.util.Random
//	      this method is more flexible since it allows to generate both integer and floating point numbers
	      Random random = new Random();
	      int res = random.nextInt(11)+50;
	      System.out.println("Random number using Random "+res);
	      
//	      using java.util.concurrent.ThreadLocalRandom
//	      provides similar functionality ans the Random but is designed for concurrent use in multi-threaded apps
//	      Each thread accessing ThreadLocalRandom gets its own independent random number generator, avoiding contention between threads.
	      int randomTh = ThreadLocalRandom.current().nextInt(11)+50;
	      System.out.println("Random number using ThreadLocalRandom "+randomTh);
	      
//	      using java.security.SecureRandom
//	      it is designed to provide cryptographically secure random numbers.
//	      It uses a cryptographically strong pseudo-random number generator (PRNG) algorithm.
//	      It's suitable for generating random numbers for security-sensitive applications, such as cryptography, secure protocols, and password generation.
	      SecureRandom secRand = new SecureRandom();
	      int randomSec = secRand.nextInt(11)+50;
	      System.out.println("Random number using SecureRandom "+randomSec);
	      
//	      --------------------------------------------------generating a negative random number----------------------------
//	      using Math.random
	      double negativeMathRand = Math.random()*-100;
	      int intNegMathRnd = (int)negativeMathRand;
	      System.out.println("Negative random number usign math.random() "+intNegMathRnd);
//	      using Random
	      int negativeRandom = -random.nextInt(100);
	      System.out.println("Negative radom number using Random " + negativeRandom);
//	      using  ThreadLocalRandom
	      int negativeNumThrLoc = -ThreadLocalRandom.current().nextInt(100);
	      System.out.println("Negative random number using ThreadLocalRandom "+negativeNumThrLoc);
	      

	}
//	DecimalFormat class
	static public void customFormat(String pattern, double value) {
		DecimalFormat myFormater = new DecimalFormat(pattern);
		String output = myFormater.format(value);
		System.out.println(value+" "+pattern+" "+output);
	}

}
