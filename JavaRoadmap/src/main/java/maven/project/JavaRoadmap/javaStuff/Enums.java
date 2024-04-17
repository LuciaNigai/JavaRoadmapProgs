package maven.project.JavaRoadmap.javaStuff;

/**
 * Enumerations (enums) are a special type in Java for defining a group of constants.
 * Each constant behaves like an object and can have attributes and methods.
 * In this example, the enum Planet represents different planets in our solar system.
 */
enum Planet {
    EARTH(3), MARS(4), VENUS(2), MERCURY(1), JUPITER(5), SATURN(6), URANUS(7), NEPTUNE(8);
    
    int number;

    // Constructor to assign a number to each planet
    Planet(int number) {
        this.number = number;
    }
}

/**
 * Enums class demonstrates the usage of enums in Java.
 * It contains a method to determine if a planet is habitable for humans.
 */
public class Enums {

    /**
     * Main method where the program starts execution.
     * It initializes a planet and checks if it is habitable.
     * @param args The command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        Planet myPlanet = Planet.MARS;
        canILiveHere(myPlanet);
    }

    /**
     * Determines if a given planet is habitable for humans.
     * Prints a message indicating whether the planet is habitable or not.
     * @param planet The planet to check for habitability.
     */
    static void canILiveHere(Planet planet) {
        switch (planet) {
            case EARTH:
                System.out.println("You can live here:)");
                System.out.println("This is planet number " + planet.number);
                break;
            default:
                System.out.println("You can't live here... yet");
                System.out.println("This is planet number " + planet.number);
                break;
        }
    }
}
