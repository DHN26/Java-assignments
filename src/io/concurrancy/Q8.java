//Q8: Solve the readers-writers problem where multiple readers can access a shared 
//resource simultaneously, but only one writer can access it at a time.

package io.concurrancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class Q8 {

	public static void main(String[] args) {
		Demo demo=new Demo();
		
		Thread wt1=new Thread(()->{
			demo.writeMethod(20);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			demo.writeMethod(10);
		});
		
		Thread rt1=new Thread(()->{
			demo.readMethod(1);
			demo.readMethod(0);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			demo.readMethod(3);
		});
		
		Thread rt2=new Thread(()->{
			demo.readMethod(1);
			demo.readMethod(0);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			demo.readMethod(2);
		});
		
		rt1.start();
		rt2.start();
		wt1.start(); 
	}
	
	public static class Demo{
		ArrayList<Integer> list=new ArrayList<>( Arrays.asList(12,54,899,-45));
		ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
		
		ReadLock readLock=lock.readLock();		
		WriteLock writeLock=lock.writeLock();
		
		public void writeMethod(int i)
		{
			writeLock.lock();
			list.add(i);
			System.out.println("Element "+i+" written into list");
			writeLock.unlock();
		}
		
		public void readMethod(int i)
		{
			readLock.lock();
			System.out.println("Element at index "+i+" : "+list.get(i));
			readLock.unlock();
		}
	}

}
