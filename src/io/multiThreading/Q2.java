//Q2: Write Program to implement your own threadpool and implement class to take 
//runnable and able to submit task.

package io.multiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Q2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service=Executors.newFixedThreadPool(3);
		Future<String> future=service.submit(new MyThread());
		System.out.println(future.get());
		service.shutdown();

	}
	
	public static class MyThread implements Callable<String>{

		@Override
		public String call() throws Exception {
			return "Thread is returning this statement";
		}
		
	}

}
