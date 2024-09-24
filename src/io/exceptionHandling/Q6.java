//Q6: Create a program that contains nested try-catch blocks. Inside the innermost 
//try block, attempt to divide two numbers. Catch the following exceptions:ArithmeticException: Division 
//by zero NumberFormatException: If the user enters a non-numeric input

package io.exceptionHandling;

import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		System.out.println("Enter a number :");
		Scanner scan=new Scanner(System.in);
		try {
			String input = scan.next();
            int n = Integer.parseInt(input);
			
			try {
				int res=n/0;
				System.out.println(res);
			}
			catch(ArithmeticException e)
			{
				System.out.println("Exception at innermost try-catch : "+e.getMessage());
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("Exception at outermost try-catch : "+e.getMessage());
		}
	}

}
