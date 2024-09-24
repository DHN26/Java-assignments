//Q3: Write a program that showcases the difference between unchecked and checked 
//exceptions. Use both types of exceptions in separate scenarios and demonstrate 
//how they are handled differently.

package io.exceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Q3 {

	public static void main(String[] args) {
		
		try {
			File file=new File("some.txt");
			FileReader read=new FileReader(file);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("This is a checked exception : "+e.getMessage());
		}
		
		try {
			int res=2/0;
			System.out.println(res);
		}
		catch(ArithmeticException e)
		{
			System.out.println("This is a unchecked exception : "+e.getMessage());
		}
		
	}

}
