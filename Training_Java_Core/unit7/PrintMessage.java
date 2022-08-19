package unit7;

import java.io.Serializable;
import java.util.Arrays;

public class PrintMessage implements Runnable, Serializable {
    private String message = "";
    public PrintMessage(String message){
        this.message = message;
    }
    @Override
    public void run() {
        String[] element = message.split("");
        Arrays.stream(element).forEach(ele ->{
            System.out.println(Thread.currentThread().getName()+"print"+ele);

            try {
                Thread.sleep((int)(Math.random()*3)*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
