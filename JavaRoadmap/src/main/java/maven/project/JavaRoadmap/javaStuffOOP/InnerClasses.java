package maven.project.JavaRoadmap.javaStuffOOP;

import java.util.Comparator;

/**
 * Demonstrates the usage of the Outer class and its inner and nested classes.
 * 
 * @version 1.0
 * @since 2024-03-24
 */
public class InnerClasses {
    /**
     * Entry point to the application. Creates instances of Outer, InnerClass, and NestedClass, and demonstrates their usage.
     */
    public static void main(String... args) {
        Outer outer = new Outer("Outer", 1);
        Outer.InnerClass inner = outer.new InnerClass();
        Outer.NestedClass nested = new Outer.NestedClass();
        inner.display();
        nested.displayNested(outer);
        outer.methodWithLocalClass("Hey");
        System.out.println("Comparision result: "+outer.comp.compare(outer.getText(), "Hey"));;
    }
}

/**
 * Shows an example of inner, static nested, local and anonymous classes usage.
 * 
 * @version 1.0
 * @since 2024-03-24
 */
class Outer {
    // instance variables of the outer class
    private String text;
    private int number;

    /**
     * Constructs an Outer object with the specified text and number.
     * 
     * @param text   the text
     * @param number the number
     */
    public Outer(String text, int number) {
        this.text = text;
        this.number = number;
    }

    /**
     * accesor method for age 
     * @return text
     */
    public String getText() {
		return text;
	}
    
   /**
    * accesor method for number
    * @return number
    */
	public int getNumber() {
		return number;
	}



	/**
     * Method demonstrates the local class.
     * 
     * @param text2 the string to compare with the instance variable of the outer class
     */
    public void methodWithLocalClass(String text2) {
//    	A local class has access to the members of its enclosing class
//    	also it has acces to local variables, but only the ones that are declared final or are effectively final
        class Compare implements java.util.Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }
        Compare comparator = new Compare();
        int result = comparator.compare(this.text, text2);
        System.out.println("Comparison result: " + result);
    }
    
//    We can do the same as above by just using an anonymous class
//    an anonymous class has access to the members of the enclosing class, and to local variables that are declared final or are effectively final
    /**
     * Anonymous class implementing a Comparator interface
     */
    Comparator<String> comp = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    };

    /**
     * Inner class that contains one instance variables and has a method that prints the instance variables of the outer class with its own instance variable.
     */
    class InnerClass {
        private String inner = "inner class";

        /**
         * Displays the outer and inner class instance variables.
         * 
         * @param Nothing
         */
        public void display() {
            System.out.println(text + " " + number + " " + inner);
        }
    }

    /**
     * Static nested class that demonstrates accessing outer class instance fields.
     * 
     * @version 1.0
     * @since 2024-03-24
     */
    static class NestedClass {
        private int age = 22;

        /**
         * Displays the outer class instance fields along with the age.
         * 
         * @param outer the reference to the outer class object whose data we want to display
         */
        public void displayNested(Outer outer) {
            System.out.println(outer.getText() + " " + outer.getNumber() + " " + age);
        }
    }
}
