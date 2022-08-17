package chuong10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SynchronizedExample {
    static void addData(List<Integer> list){
        IntStream.range(0,1000).forEach(index ->{
            try{
                list.add(index);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<List<Integer>> values = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < 10; i++){
            List<Integer> list = new ArrayList<>();
            new Thread(()-> {
                try {
                    addData(list);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();
            values.add(list);
        }
        Thread.sleep(5*1000);
        values.forEach(list ->
                System.out.println("number items of list ->"+list.size()));
    }
}
