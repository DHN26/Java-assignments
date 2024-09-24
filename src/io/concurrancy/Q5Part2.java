package io.concurrancy;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class Q5Part2 {

    private static class Resource {
        private final String name;

        Resource(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private static final Resource resource1 = new Resource("Resource1");
    private static final Resource resource2 = new Resource("Resource2");

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task(resource1, resource2), "Thread-1");
        Thread thread2 = new Thread(new Task(resource2, resource1), "Thread-2");

        thread1.start();
        thread2.start();

        detectAndResolveDeadlock();
    }

    private static class Task implements Runnable {
        private final Resource resource1;
        private final Resource resource2;

        Task(Resource resource1, Resource resource2) {
            this.resource1 = resource1;
            this.resource2 = resource2;
        }

        @Override
        public void run() {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " locked " + resource1.getName());
                try {
                    // Adding delay so that both threads can start trying to lock resources
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " locked " + resource2.getName());
                }
            }
        }
    }

    private static void detectAndResolveDeadlock() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        while (true) {
            long[] threadIds = bean.findDeadlockedThreads(); // Returns null if no threads are deadlocked
            if (threadIds != null) {
                ThreadInfo[] infos = bean.getThreadInfo(threadIds);
                System.out.println("Deadlock detected!");

                for (ThreadInfo info : infos) {
                    System.out.println(info.getThreadName() + " is waiting for " + info.getLockInfo());
                }

                // Breaking the deadlock by interrupting one of the threads
                for (long id : threadIds) {
                    Thread deadlockedThread = findThreadById(id);
                    if (deadlockedThread != null) {
                        System.out.println("Interrupting " + deadlockedThread.getName());
                        deadlockedThread.interrupt();
                    }
                }
                break;
            }
        }
    }

    private static Thread findThreadById(long id) {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getId() == id) {
                return thread;
            }
        }
        return null;
    }
}

