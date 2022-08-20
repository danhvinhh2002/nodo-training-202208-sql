package unit6;

public class DeadLockDemo extends Thread{
    private Object lock1;
    private Object lock2;
    Thread thread = new Thread();
    public DeadLockDemo(Object lock1,Object lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1){
            System.out.println(thread.getName()+" :Holding "+lock1+"...");
            try {
                Thread.sleep(10);
                System.out.println(thread.getName()+ "Waiting for "+lock1+": "+lock2+"...");
                synchronized (lock2){
                    System.out.println(thread.getName()+ "------>"+lock1+" : "+lock2+"...");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
