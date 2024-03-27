package maven.project.JavaRoadmap.JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import maven.project.JavaRoadmap.DesignPatterns.Creational.Singleton;

class DesignPatternsTest {
	
//	--------------------------------------------------CREATIONAL PATTERNS-----------------------------------------
	
	/**
	 * Tests the {@link Singleton#createSingleton(String)} method in a multi-threaded environment.
	 * It verifies that two Singleton instances created by different threads have the same value.
	 */
	@Test
	void SingletonTest() {
	    // Shared variable to hold the Singleton instances created by the threads
	    Singleton[] singletons = new Singleton[2];
//	    create singleton instances
	    Runnable run1 = () -> {
	        singletons[0] = Singleton.createSingleton("Hello");
	    };

	    Runnable run2 = () -> {
	        singletons[1] = Singleton.createSingleton("Hey");
	    };

	    // Create and start the threads
	    Thread th1 = new Thread(run1);
	    Thread th2 = new Thread(run2);
	    th1.start();
	    th2.start();

	    // Wait for both threads to finish execution
	    try {
	        th1.join();
	        th2.join();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    System.out.println(Arrays.toString(singletons));
	    // Verify that the values of the two Singleton instances are equal
	    assertEquals(singletons[0], singletons[1]);
	}


}
