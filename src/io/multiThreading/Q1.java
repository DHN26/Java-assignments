//Q3: Implement your own ArrayList  using plain array? supported Add(), indexof(), 
//contains() also implement Addall() method in your own ArrayList ? Write a method  
//to support add(int index, int value) ? 

package io.multiThreading;

public class Q1 {

	public static void main(String[] args) throws InterruptedException {
		MyThread t1=new MyThread();
		t1.start();
		t1.join();
		MyThread t2=new MyThread();
		t2.start();
		
	}
	
	public static class MyThread extends Thread{
		public synchronized void run()
		{
			System.out.println("Thread execution started.");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread execution completed.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
