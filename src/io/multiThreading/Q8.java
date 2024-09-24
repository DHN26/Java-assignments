//Q8: Implement a producer-consumer problem with multiple producers and consumers 
//using ReentrantLock and Condition

package io.multiThreading;

public class Q8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ProducerConsumer pc = new ProducerConsumer();
		Thread t1 = new Thread(() -> {
			{
				try {
					pc.produce(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(() -> {
			{
				try {
					pc.consume(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread prod2 = new Thread(() -> {
			{
				try {
					pc.produce(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread con2 = new Thread(() -> {
			{
				try {
					pc.consume(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		prod2.start();
		con2.start();
	}

}
