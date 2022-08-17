package chuong10;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyExample {
    public static List<Integer> addData(List<Integer> list) throws InterruptedException {
        while(true){
            Integer random = (int)(Math.random() * 100);
            list.add(random);
            System.out.println("add new data "+random);
            Thread.sleep(1000);
        }
    }
    public static List<Integer> printData(List<Integer> list) throws InterruptedException {
        while(true){
            try {
                System.out.println("===============");
                list.forEach(value ->
                        System.out.println("value = "+value));
                Thread.sleep(800);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        new Thread(()-> {
            try {
                addData(list);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                printData(list);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
