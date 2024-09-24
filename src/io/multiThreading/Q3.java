//Q3: Write a program with three threads. First thread should print Even numbers, 
//Second thread should print Odd Numbers, third thread should print sum of odd and 
//even numbers. Above threads should print in a sequential manner.

package io.multiThreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3 {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> list=Arrays.asList(1,3,46,99,0,24,134);
		
		Thread t3=new Thread() {
			{
				System.out.println("Sum thread :");
				int sum=0;
				for(int i=0;i<list.size();i++)
				{
					sum+=list.get(i);						
				}
				System.out.println(sum);
			}
		};
		Thread t1=new Thread() {
			{
				System.out.println("Even thread :");
				for(int i=0;i<list.size();i++)
				{
					if(list.get(i)%2==0)
						System.out.println(list.get(i));
				}
			}
		};
		
		Thread t2=new Thread() {
			{
				System.out.println("Odd thread :");
				for(int i=0;i<list.size();i++)
				{
					if(list.get(i)%2!=0)
						System.out.println(list.get(i));
				}
			}
		};
		
		
		
		
		t3.start();
		t1.start();
		t2.start();

		System.out.println("End of execution.");
	}

}
