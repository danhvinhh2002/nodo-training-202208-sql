package unit6;

public class ThreadNumberTest {
    public static void main(String[] args) throws InterruptedException {
//        PrintNumber number = new PrintNumber();
//        Thread thread = new Thread();
//        thread.setName("Hanoi_Thread");
//        thread.start();
//        while(thread.isAlive()){
//            if(number.getNumber()%10 == 0){
//                number.setAlive(false);
//                  Thread.sleep(1000);
////                TimeUnit.SECONDS.sleep(1);
//            }
//            break;
//        }

        System.out.println("Main Thread say hello");
        System.out.println("Main Thread say goodbye");
        PrintNumber number = new PrintNumber();
        Thread thread = new Thread(number);
        thread.setName("FSoft_Thread1");
        thread.setDaemon(true);
        thread.start();

        Thread thread2 = new Thread(number);
        thread2.setName("FSoft_Thread 2");
        thread2.start();
//        System.out.println("Main Thread say hello");
//        System.out.println("Main Thread say goodbye");
    }
}
