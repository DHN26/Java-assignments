//Q2: Create a custom exception named InvalidInputException. Write a program that 
//takes user input for a positive integer. If the input is negative or zero, 
//throw an InvalidInputException with an appropriate error message

package io.exceptionHandling;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a number : ");
		int n=scan.nextInt();
		try {
			if(!(n>0))
				throw new InvalidInputException("Number should be greater than 0");				
		}
		catch(InvalidInputException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static class InvalidInputException extends Exception{
		public InvalidInputException(String msg)
		{
			super(msg);
		}
	}

}
