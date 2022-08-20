package unit6;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadLockExample {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Runnable readTask =()->{
            System.out.println("start reading");
            lock.readLock().lock();
            try {
                System.out.println("fOOOO");
            }finally {
                lock.readLock().unlock();
                System.out.println("end reading");
            }
        };
    }
}
