package maven.project.JavaRoadmap;

import maven.project.JavaRoadmap.letCodePrograms.ValidParentheses;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String s="hehe";
        int n=3;
        String result="";
        for(int i=0; i<n;i++) {
        	result=result.concat(s);
        }
        
        System.out.println(s.repeat(n));
        System.out.println(result);
        
        System.out.println(summation(5));
        
        System.out.println(ValidParentheses.isValid("()[]"));
        System.out.println(ValidParentheses.isValid2("()[]"));
    }
    
    public static int summation(int n) {
    	if(n==1) {
    		return 1;
    	}
    	
    	return summation(n+(n-1));
    	
    }
    
    public static Integer basicMath(String op, int v1, int v2)
    {
      return (switch(op){
		case "+" ->v1+v2;
		case "-" -> v1-v2;
		case "*" -> v1*v2;
		case "/" -> v1/v2;
		default -> 0;
		});
		
    }
}
