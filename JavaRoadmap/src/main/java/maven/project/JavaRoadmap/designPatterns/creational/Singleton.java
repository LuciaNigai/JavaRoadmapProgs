package maven.project.JavaRoadmap.designPatterns.creational;


/**
 * The Singleton class represents a singleton pattern implementation.
 * It ensures that only one instance of the class is created and provides a global point of access to that instance.
 */
public class Singleton {
    /** The text stored in the singleton instance. */
    private String text;

    /** Private constructor to prevent instantiation from outside the class. */
    private Singleton(String text) {
        this.text = text;
    }

    /** 
     * The volatile keyword is used to indicate that the variable's value will be modified by different threads.
     * When a variable is declared volatile, it ensures that all threads see the most recent value written to that variable.
     */
    private static volatile Singleton singleton;

    /**
     * Creates and returns the singleton instance.
     * 
     * @param text The text to be stored in the singleton instance.
     * @return The singleton instance.
     */
    public static Singleton createSingleton(String text) {
        if (singleton == null) {
            // Using synchronized block to ensure thread safety
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton(text);
                }
            }
        }
        return singleton;
    }

    /**
     * Returns a string representation of the singleton instance.
     * 
     * @return A string representation of the singleton instance.
     */
    @Override
    public String toString() {
        return "Singleton{" +
                "text='" + text + '\'' +
                '}';
    }
}
