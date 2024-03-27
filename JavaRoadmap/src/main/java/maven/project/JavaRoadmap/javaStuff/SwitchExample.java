package maven.project.JavaRoadmap.javaStuff;


/**
 * This class demonstrates the usage of switch statements and switch expressions in Java.
 */
public class SwitchExample {

    public static void main(String... args) {
		
        // Example of a switch statement
        int nLetters = 0;
        String name = "Jane";
        switch(name) {
            case "Jane":
            case "Sean":
            case "Alan":
            case "Paul":
                nLetters = 4;
                break;
            case "Janet" :
            case "Susan" :
                nLetters = 5;
                break;
            case "Maaike":
            case "Alison":
            case "Miriam":
                nLetters = 6;
                break;
            default:
                System.out.println("Unrecognized name");
                nLetters = 2;
                break;
        }
        System.out.println(nLetters);
		
        // Example of a switch expression
        nLetters = switch(name) {
            case "Jane", "Sean", "Alan", "Paul" -> 4;
            case "Janet", "Susan" -> 5;
            case "Maaike", "Alison", "Miriram" -> 6;
            default -> {
                System.out.println("Unrecognized name");
                yield -1; // letters initialized to -1
            }
        };
        System.out.println(nLetters);
		
        // The result of a switch statement can be returned to println method
        System.out.println(switch(name) {
            case "Jane", "Sean", "Alan", "Paul" -> 4;
            case "Janet", "Susan" -> 5;
            case "Maaike", "Alison", "Miriram" -> 6;
            default -> "Unrecognized name " + name;
        });
		
	}
	
}
