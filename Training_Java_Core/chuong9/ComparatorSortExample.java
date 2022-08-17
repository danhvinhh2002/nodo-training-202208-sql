package chuong9;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorSortExample {
    public static void main(String[] args) {
        Integer[] values = {12,345,122,4,6,83,6,2};
//        Arrays.sort(values, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });

        Arrays.sort(values, (Integer o1, Integer o2) ->{
            return  o2-o1;
        });
        for (Integer ele: values){
            System.out.print(ele+ ",");
        }
    }
}
