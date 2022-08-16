import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList,args);
//        for (int i = 0 ; i < stringList.size(); i++){
//            System.out.println("Element at "+i+" is"+stringList.get(i));
//        }
        IntStream.range(0,stringList.size()).forEach(i -> {
            System.out.println("Element at "+i+" is "+stringList.get(i));
        });
    }
}
