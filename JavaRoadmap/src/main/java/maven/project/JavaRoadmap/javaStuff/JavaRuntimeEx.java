package maven.project.JavaRoadmap.javaStuff;

/**
 * Class demonstrates the usage of some of the methods of java.lang.Runtime
 * @since 2024-04-08
 */
public class JavaRuntimeEx {

	public static void main(String[] args) {
		// Get the runtime instance associated with the current Java application
		Runtime runtime = Runtime.getRuntime();

		// Print the number of processors available to the JVM
		System.out.println("Available processors: " + runtime.availableProcessors());

		// Print the total amount of memory available to the JVM
		System.out.println("Total memory: " + runtime.totalMemory());

		// Print the amount of free memory in the JVM
		System.out.println("Free memory: " + runtime.freeMemory());

		// Create a large number of objects to consume memory
		for (int i = 0; i < 100000; i++) {
			new Object();
		}

		// Print the amount of free memory in the JVM after creating objects
		System.out.println("Free memory after creating objects: " + runtime.freeMemory());

		// Suggest that the JVM runs the garbage collector
		runtime.gc();

		// Print the amount of free memory in the JVM after running garbage collector
		System.out.println("Free memory after running garbage collector: " + runtime.freeMemory());
	}
}
