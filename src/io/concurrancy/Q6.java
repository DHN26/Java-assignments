//Q6: Solve a problem using semaphores, for example, implement a scenario where a 
//certain number of threads can concurrently access a resource.

package io.concurrancy;

import java.util.concurrent.Semaphore;

public class Q6 {

	public static void main(String[] args) {
		Semaphore sema=new Semaphore(2, true);
		
		SemaphoreDemo s1=new SemaphoreDemo(sema);
		Thread t1=new Thread(s1);
		
		SemaphoreDemo s2=new SemaphoreDemo(sema);
		Thread t2=new Thread(s2);
		
		SemaphoreDemo s3=new SemaphoreDemo(sema);
		Thread t3=new Thread(s3);
		
		
		t1.start(); t2.start(); t3.start();
		
	}
	
	public static class SemaphoreDemo implements Runnable{
		Semaphore sema;
		
		public SemaphoreDemo(Semaphore sema)
		{
			this.sema=sema;
		}

		@Override
		public void run() {
			try {
				sema.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i=11;i<=15;i++)
			{
				System.out.println(i+" printed by "+Thread.currentThread().getName());
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sema.release();
		}
		
		
	}

}
