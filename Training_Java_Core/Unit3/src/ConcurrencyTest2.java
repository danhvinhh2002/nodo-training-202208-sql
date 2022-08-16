import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrencyTest2 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList,1,3,4,5,6,8,4,2,3);
        System.out.println("Before remove : size of list = "+integerList.size());
        integerList.forEach(v -> {
            if(v == 3){
                integerList.remove(v);
            }
        });
        System.out.println("After remove: size of list = "+integerList.size());
    }
}
