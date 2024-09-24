//Q1: Write a program for Object level and method level synchronization.

package io.concurrancy;

public class Q1 {

	public static void main(String[] args) {
		Q1 q1=new Q1();
		ThreadDemo demo=q1.new ThreadDemo();
		
		Thread t1=new Thread(()->{
			try {
				demo.synMethod();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			demo.otherMethod();
		});
		
		Thread t2=new Thread(()->{
			try {
				demo.synMethod();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			demo.otherMethod();
		});
			
		t1.start(); //t1 acquires lock on synMEthod and executes pura and lock on print statement
		//of otherMEthod and release lock. Next t2 acquires lock and for loop of otherMEthod and
		//for loop of synMethod starts executing parallelly.
		t2.start();
		
	}
	
	public class ThreadDemo {

		public synchronized void synMethod() throws InterruptedException
		{
			System.out.println("Method synchronization statement.");
			for(int i=1;i<=5;i++)
			{
				System.out.println(i+" of method eg.");
				Thread.sleep(100);
			}
		}
		
		public void otherMethod()
		{
			
			synchronized(this)
			{
				System.out.println("Object synchronization statement.");
			}
			for(int i=1;i<=5;i++)
			{
				System.out.println(i+" of object eg.");
			}
		}
		
	}

}
