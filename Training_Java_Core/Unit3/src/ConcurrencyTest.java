import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ConcurrencyTest {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList,1,3,4,5,6,8,4,2,3);
        System.out.println("Before remove : size of list = "+integerList.size());
        for (int i = 0 ; i < integerList.size(); i++){
            if(integerList.get(i) == 3 ){
                integerList.remove(i);
            }
        }
        System.out.println("After remove: size of list = "+integerList.size());

        Iterator<Integer> iterator = integerList.iterator();
        while(iterator.hasNext()){
            if(iterator.next() == 3){
                iterator.remove();
            }
        }
        System.out.println("After remove: size of list = "+integerList.size());
        integerList.removeIf(item ->{
            return item ==3 ;
        });

        integerList.removeAll(Collections.singleton(3));
        System.out.println("After remove: size of list = "+integerList.size());
    }
}
