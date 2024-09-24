package io.multiThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	int count = 1;
	boolean produced = false;

	public void produce(int n) throws InterruptedException {
		try {
			lock.lock();
			while (true) {
				if(count>5)
					break;
				if (!produced) {
					System.out.println("Producer "+n+" is producing item no. " + count);
					produced = true;
					condition.signal();
				}
				condition.await(2, TimeUnit.SECONDS);

			}
		} finally {
			lock.unlock();
		}

	}

	public void consume(int n) throws InterruptedException {
		try {
			lock.lock();
			while (true) {
				if(count>5)
				{
					break;
				}
				if (!produced) {
					condition.await(2, TimeUnit.SECONDS);
				} else {
					System.out.println("Consumer "+n+" is consuming item no " + count);
					produced = false;
					condition.signal();
					count++;
				}
			}
		} finally {
			lock.unlock();
		}
	}

}
