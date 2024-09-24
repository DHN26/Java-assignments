//Q5: Write a program that demonstrates chained exceptions. Create a custom exception 
//class CustomException and another class that throws an ArithmeticException. Catch
//the ArithmeticException and throw a CustomException with the ArithmeticException as 
//a chained exception.

package io.exceptionHandling;

public class Q5 {

	public static void main(String[] args) {
		try {
			AnotherClass.method();
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}

	}
	
	public static class CustomException extends Exception{
		public CustomException(String msg)
		{
			super(msg);
		}
	}
	
	public static class AnotherClass extends Exception{
		public static void method() throws CustomException
		{
			try {
				int res=4/0;
			}
			catch(ArithmeticException e)
			{
				throw new CustomException("Arithmetic exception has occured and caught in AnotherClass");
			}
		}
	}

}
