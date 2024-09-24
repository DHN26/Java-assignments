//Q4: Write a program where multiple threads increment a shared counter using 
//AtomicInteger and ensure that the increments are atomic.

package io.concurrancy;

import java.util.concurrent.atomic.AtomicInteger;

public class Q4 {

	public static void main(String[] args) throws InterruptedException {
		DemoClass demo=new DemoClass();
		
		Thread t1=new Thread() {
			public void run()
			{
				for(int i=0;i<150;i++)
				{
					demo.setCount();
				}
			}
		};
		
		Thread t2=new Thread() {
			public void run()
			{
				for(int i=0;i<150;i++)
				{
					demo.setCount();
				}
			}
		};
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println(demo.getCount());

	}
	
	public static class DemoClass{
		AtomicInteger i=new AtomicInteger(1);
		
		public void setCount()
		{
			i.incrementAndGet();
		}
		
		public int getCount()
		{
			return i.get();
		}
	}

}
