//Q4: Write a program with three methods - methodA, methodB, and methodC. methodA 
//calls methodB, and methodB calls methodC. Throw a custom exception in methodC and 
//catch it in methodA. Demonstrate exception propagation.

package io.exceptionHandling;

public class Q4 {

	public static void main(String[] args) {
		System.out.println("Calling Method A in main method :");
		methodA();
	}
	
	public static void methodA()
	{
		System.out.println("Statement of Method A.");
		try {
			methodB();
		} catch (ReadyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void methodB() throws ReadyException {
		System.out.println("Statement of MEthod B.");
		methodC();
		
	}

	private static void methodC() throws ReadyException {
		try {
			int res=4/0;
			System.out.println(res);
		}
		catch(Exception e)
		{
			throw new ReadyException();
		}
		
	}
	
	
	public static class ReadyException extends Exception{
		public ReadyException()
		{
			super("Made exception.");
		}
	}
	

}
