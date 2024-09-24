//Q5: Write a program of Thread, so thread1 should print 1 to 5 and thread2
//should print 6 to 10?

package io.multiThreading;

public class Q5 {

	public static void main(String[] args) {
		Thread t1=new Thread(()->method("thread1"));
		t1.start();
		
		Thread t2=new Thread(()->method("thread2"));
		t2.start();

	}
	
	public static void method(String s)
	{
		if(s.equals("thread1"))
		{
			for(int i=1;i<=5;i++)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
		else if(s.equals("thread2"))
		{
			for(int i=6;i<=10;i++)
			{
				System.out.print(i+" ");
			}
		}
	}
	
	

}
