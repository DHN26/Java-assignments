//Q5: Write a program that generates a large list of random integers and calculates 
//the sum using parallel streams. Compare the execution time with a sequential stream 
//for the same task.

package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Q5 {

	public static void main(String[] args) {
		Random random=new Random();
		int size=100000000;
		
		List<Long> list=new ArrayList<>();
		for(int i=0;i<size;i++)
		{
			list.add(random.nextLong(1000));
		}
		
		
		//sum using parallel stream
		long before=System.currentTimeMillis();
		System.out.println("Before executing parallel : "+before);
		long sum=list.parallelStream().mapToLong(inte->inte.longValue()).sum();
		System.out.println(sum);
		long after=System.currentTimeMillis();
		System.out.println("Before executing parallel : "+after);
		System.out.println("Execution time : "+(after-before));
		
		System.out.println();
		
		long before2=System.currentTimeMillis();
		System.out.println("Before executing sequential : "+before2);
		long sum2=list.stream().mapToLong(inte->inte.longValue()).sum();
		System.out.println(sum2);
		long after2=System.currentTimeMillis();
		System.out.println("Before executing sequential : "+after2);
		System.out.println("Execution time : "+(after2-before2));
		
	}

}
