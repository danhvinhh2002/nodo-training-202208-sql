package chuong9;

public class RunnableTest {
    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+"Say hello java class");
//            }
//        };
//        new Thread(runnable).start();
//        Runnable runnable = ()->{
//            System.out.println(Thread.currentThread().getName()+" Say hello java");
//        };
//        new Thread(runnable).start();
//        new Thread(
//                () -> System.out.println(Thread.currentThread().getName()+ " Say hello java")
//        ).start();
        new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName()+" Say hello java");
                    System.out.println("1 + 1 = "+(1+1));
                }
        ).start();
    }
}
