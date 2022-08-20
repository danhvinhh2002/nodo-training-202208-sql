package unit6;

public class PrintNumber implements Runnable{

    private Integer number = (1);
    private boolean alive = true;

    public int getNumber() {
        return number;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
//        synchronized (number) {
            while (true) {
                number++;
                System.out.println(current.getName() + " number is " + number + "");
                try {
                    Thread.sleep(300);
                    if(number % 10 ==0){
                        break;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//            }
        }
        System.out.println(current.getName()+" is stoped!");
    }
}
