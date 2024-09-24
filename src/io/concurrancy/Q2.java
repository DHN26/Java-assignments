package io.concurrancy;

public class Q2 {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Counter.incrementStaticCount();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Counter.incrementStaticCount();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-2");

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter1.incrementInstanceCount();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-3");

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter2.incrementInstanceCount();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Counter {
    private static int staticCount = 0;
    private int instanceCount = 0;

    // Class-level lock
    public static synchronized void incrementStaticCount() {
        staticCount++;
        System.out.println(Thread.currentThread().getName() + " - Static Count: " + staticCount);
    }

    // Object-level lock
    public synchronized void incrementInstanceCount() {
        instanceCount++;
        System.out.println(Thread.currentThread().getName() + " - Instance Count: " + instanceCount);
    }
}

