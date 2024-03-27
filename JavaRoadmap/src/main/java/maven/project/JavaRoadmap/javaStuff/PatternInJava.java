package maven.project.JavaRoadmap.javaStuff;

/**
 * This class provides methods to print various patterns in Java.
 */
public class PatternInJava {
	
//  *
//  **
//  ***
//  ****
	
	public static void printPattern1(int n)
	{
		System.out.println("Pattern 1");
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
	}
	

//  ****
//  ***
//  **
//  *
	
	public static void printPattern2(int n) 
	{
		System.out.println("Pattern 2");
		for(int i=0; i<n; i++)
		{
		    for(int j=0; j<n-i; j++)
		    {
		        System.out.print("*");
		    }
		    System.out.println();
		}
		System.out.println();
	}

	
//    *
//   **
//  ***
// ****
	
	public static void printPattern3(int n)
	{
		System.out.println("Pattern 3");
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++){
                if(j<n-i-1){
                    System.out.print(" ");
                }
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
	}
	
	
//  ****
//   ***
//    **
//     *
	
	public static void printPattern4(int n)
	{
		System.out.println("Pattern 4");
        for(int i=0; i<n; i++){
            for(int j=1; j<=n; j++){
                if(j<=i){
                    System.out.print(" ");
                }
                else System.out.print("*");
            }
            System.out.println();
        }
		System.out.println();
	}
	
//	    *
//	   ***
//	  *****
//	 *******
	
	public static void printPattern5(int n)
	{
		System.out.println("Pattern 5");
		int i,j,k;
		for(i=0; i<n; i++)
		{
			for(j=0; j<n-i-1; j++)
			{
				System.out.print(" ");
			}
			for(k=0; k<2*i+1; k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
//    *
//   * *
//  * * *
// * * * *
	
	
	public static void printPattern6(int n)
	{
		System.out.println("Pattern 6");
        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++){
                if(j<n-i-1){
                    System.out.print(" ");
                }
                else {
                    System.out.print("*");
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
		System.out.println();
	}
	
	
//	 *******
//	  *****
//	   ***
//	    *
	
	//version written by me
	public static void printPattern7(int n)
	{
		System.out.println("Pattern 7");
		for(int i=0; i<n;i++)
		{
			for(int j=0; j<i; j++)
			{
				System.out.print(" ");
			}
			for(int k=0; k<n*2-i*2-1; k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
		
		//chatGPT version of previous code
	public static void printPattern7_1(int n)
	{
		System.out.println("Pattern 7_1");
		 for (int i = n - 1; i >= 0; i--) {
	            for (int j = 0; j < n - i - 1; j++) 
	            {
	                System.out.print(" ");
	            }
	            for (int k = 0; k < 2 * i + 1; k++) 
	            {
	                System.out.print("*");
	            }
	            System.out.println();
	        }
		 System.out.println();
	}
	
//	     *
//	    ***
//	   *****
//	  *******
//	   *****
//	    ***
//	     *
	
	public static void printPattern8(int n)
	{
		System.out.println("Pattern 8");
		int i,j,k;
		for (i=0; i<n; i++)
		{
			for(j=0; j<n-i-1; j++)
			{
				System.out.print(" ");
			}
			for(k=0; k<i*2+1; k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(i=n-2; i>=0; i--)
		{
			for(j=0; j<n-i-1; j++)
			{
				System.out.print(" ");
			}
			for(k=0; k<i*2+1; k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
//	*
//	**
//	***
//	****
//	***
//	**
//	*
	public static void printPattern9(int n)
	{
		System.out.println("Pattern 9");
		int i,j;
		for(i=0; i<n; i++)
		{
			for(j=0; j<=i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(i=n-2; i>=0; i--)
		{
			for(j=0; j<=i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
//	    *
//	   **
//	  ***
//	 ****
//	  ***
//	   **
//	    *
	public static void printPattern10(int n)
	{
		System.out.println("Pattern 10");
		int i,j,k;
		for(i=0; i<n; i++)
		{
			for(j=0; j<n-i-1; j++)
			{
				System.out.print(" ");
			}
			for(k=0; k<=i; k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(i=n-2; i>=0; i--)
		{
			for(j=0; j<n-i-1; j++)
			{
				System.out.print(" ");
			}
			for(k=0; k<=i; k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	
//	  *******
//	   *****
//	    ***
//	     *
//	    ***
//	   *****
//	  *******
	public static void printPattern11(int n)
	{
		System.out.println("Pattern 11");
		int i,j,k;
		for(i=n-1; i>=0; i--)
		{
			for(j=0; j<n-i-1; j++)
			{
				System.out.print(" ");
			}
			for(k=0; k<=i*2; k++)
			{
				System.out.print("*");
			}
			System.out.println();	
		}
		for(i=1; i<n; i++)
		{
			for(j=0; j<n-i-1; j++)
			{
				System.out.print(" ");
			}
			for(k=0; k<=i*2; k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
//	   *
//	  * *
//	 *   *
//	*******
	public static void printPattern12(int n)
	{
		System.out.println("Pattern 12");
		int i,j,k;
		for(i=0; i<=n; i++)
		{
				for(j=0; j<n-i; j++)
				{
						System.out.print(" ");
				}
				
				for(k=1; k<=i*2-1; k++)
				{
					if(k==1 || k==2*i-1 || i==n)
					{
						System.out.print("*");
					}
					else
					System.out.print(" ");
				}
				
				System.out.println();
		}
		System.out.println();
	}
	
//	*******
//	 *   *
//	  * *
//	   *
	
	public static void printPattern13(int n)
	{
		System.out.println("Pattern 13");
		int i,j,k;
		for(i=n; i>=1; i--)
		{
				for(j=0; j<n-i; j++)
				{
						System.out.print(" ");
				}
				
				for(k=1; k<=i*2-1; k++)
				{
					if(k==1 || k==2*i-1 || i==n)
					{
						System.out.print("*");
					}
					else
					System.out.print(" ");
				}
				
				System.out.println();
		}
		System.out.println();
	}
	
	
//	     *
//	    * *
//	   *   *
//	  *     *
//	   *   *
//	    * *
//	     *
	public static void printPattern14(int n)
	{
		System.out.println("Pattern 14");
		int i,j,k;
		for(i=0; i<=n; i++)
		{
			for(j=0; j<n-i; j++)
			{
				System.out.print(" ");
			}
			for(k=1; k<=i*2-1; k++)
			{
				if(k==1 || k==i*2-1)
				{
					System.out.print("*");
				}
				else System.out.print(" ");
			}
			System.out.println();
		}
		for(i=n-1; i>=1; i--)
		{
			for(j=0; j<n-i; j++)
			{
				System.out.print(" ");
			}
			for(k=1; k<=i*2-1; k++)
			{
				if(k==1 || k==i*2-1)
				{
					System.out.print("*");
				}
				else System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
//	1
//	12
//	123
//	1234
//	12345
	public static void printPattern15(int n)
	{
		System.out.println("Pattern 15");
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<=i; j++)
			{
				System.out.print(j+1);
			}
			System.out.println();
		}
		System.out.println();
	}
	
//	1
//	23
//	456
//	78910
//	1112131415
	public static void printPattern16(int n)
	{
		System.out.println("Pattern 16");
		int k=1;
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<=i; j++)
			{
				
				System.out.print(k);
				k+=1;
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	//aaaaaaaaaaaaaaaaaaaaaaa    ---------------------------
	public static void printPattern17(int n)
	{
		System.out.println("Pattern 17");
		 for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                System.out.print(" ");
	            }

	            int num = 1;
	            for (int j = 0; j <= i; j++) {
	                System.out.print(num + " ");
	                num = num * (i - j) / (j + 1);
	            }
	            System.out.println();
	        }
		 System.out.println();
	}
}