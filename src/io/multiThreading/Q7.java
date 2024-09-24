//Q7: Write a program that uses ThreadLocal to maintain a unique value for each 
//thread and demonstrate its use in a multithreaded environment.

package io.multiThreading;


public class Q7 {

	public static void main(String[] args) {
		Q7 q7=new Q7();
		int i=0;
		ThreadLocalDemo demo=q7.new ThreadLocalDemo();
		for(i=0;i<10;i++)
		{
			Thread t1=new Thread(()->System.out.println(Thread.currentThread().getName()+" -> "+demo.getDate()));
			t1.start();
		}
	}
	
	public class ThreadLocalDemo{
		private ThreadLocal<Integer> random = ThreadLocal.withInitial(() -> (int) (Math.random()*100));//ensures that each thread gets its own separate Integer instance.
		
		public Integer getDate() {
            return random.get();
        }
		
	}

}
