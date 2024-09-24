package io.concurrancy;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Q5 {
    private final ReentrantLock lock1 = new ReentrantLock();
    private final ReentrantLock lock2 = new ReentrantLock();
    private static volatile boolean deadlockDetected = false;

    public static void main(String[] args) throws InterruptedException {
        Q5 obj = new Q5();
        Thread t1 = new Thread(() -> {
            try {
                obj.printA();
            } catch (InterruptedException e) {
                System.out.println("Thread-1 interrupted.");
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            try {
                obj.printB();
            } catch (InterruptedException e) {
                System.out.println("Thread-2 interrupted.");
            }
        }, "Thread-2");

        t1.start();
        t2.start();

        // Start the deadlock detection thread
        Thread deadlockDetector = new Thread(() -> {
            while (true) {
                detectDeadlock(t1, t2);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        deadlockDetector.setDaemon(true); // Ensure it doesn't block program exit
        deadlockDetector.start();

        t1.join();
        t2.join();
    }

    public void printA() throws InterruptedException {
        boolean lock1Acquired = false;
        boolean lock2Acquired = false;
        while (true) {
            try {
                lock1Acquired = lock1.tryLock(500, TimeUnit.MILLISECONDS);
                if (lock1Acquired) {
                    System.out.println("Lock 1 acquired by A.");
                    Thread.sleep(1000);
                    lock2Acquired = lock2.tryLock(500, TimeUnit.MILLISECONDS);
                    if (lock2Acquired) {
                        System.out.println("Lock 2 acquired by A.");
                        break;
                    } else {
                        System.out.println("Could not acquire lock 2 on A");
                    }
                } else {
                    System.out.println("Could not acquire lock 1 on A");
                }
            } finally {
                if (lock2Acquired) {
                    lock2.unlock();
                }
                if (lock1Acquired) {
                    lock1.unlock();
                }
            }
            // Sleep before retrying
            Thread.sleep(1000);

            
        }
    }

    public void printB() throws InterruptedException {
        boolean lock1Acquired = false;
        boolean lock2Acquired = false;
        while (true) {
            try {
                lock2Acquired = lock2.tryLock(500, TimeUnit.MILLISECONDS);
                if (lock2Acquired) {
                    System.out.println("Lock 2 acquired by B.");
                    Thread.sleep(1000);
                    lock1Acquired = lock1.tryLock(500, TimeUnit.MILLISECONDS);
                    if (lock1Acquired) {
                        System.out.println("Lock 1 acquired by B.");
                        break;
                    } else {
                        System.out.println("Could not acquire lock 1 on B");
                    }
                } else {
                    System.out.println("Could not acquire lock 2 on B");
                }
            } finally {
                if (lock1Acquired) {
                    lock1.unlock();
                }
                if (lock2Acquired) {
                    lock2.unlock();
                }
            }
            // Sleep before retrying
            Thread.sleep(1000);

        }
    }

    private static void detectDeadlock(Thread t1, Thread t2) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = threadMXBean.findDeadlockedThreads();
        if (threadIds != null) {
            deadlockDetected = true;
            ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds);
            System.out.println("Deadlock detected involving threads:");
            for (ThreadInfo threadInfo : threadInfos) {
                System.out.println(threadInfo.getThreadName());
            }
            // Interrupt one of the threads to break the deadlock
            t1.interrupt();
            t2.interrupt();
        }
    }
}
