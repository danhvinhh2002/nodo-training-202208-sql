package unit6;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        HashMap<Object, Object> map = new HashMap<>();
        executor.submit(()->{
            System.out.println("Start writing");
            try{
                TimeUnit.SECONDS.sleep(10);
                map.put("foo","bar");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("End writing");
            }
        });
//        Runnable readTake = ()->{
//            System.out.println("Start reading");
//            try{
//                System.out.println(map.get("foo"));
//            }finally {
//                System.out.println("End reading");
//            }
//        };
//        executor.submit(readTake);
//        executor.submit(readTake);
        ReadWriteLock lock = new ReentrantReadWriteLock();
        executor.submit(()->{
            System.out.println("start writing");
            lock.writeLock().lock();
            try{
                System.out.println(map.get("foo"));
            }finally {
                lock.writeLock().unlock();
                System.out.println("End writing");
            }
        });
    }
}
