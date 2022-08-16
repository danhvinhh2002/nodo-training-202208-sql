import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample2 {
    public static void main(String[] args) {
        String[] values = {"Tu","Kien","Hai","Duong","Huy"};
        List<String> stringList = new ArrayList<String>();
        Collections.addAll(stringList,values);
        Collections.sort(stringList);
        for(int i = 0; i < stringList.size(); i++){
            System.out.println(stringList.get(i)+", ");
        }

        System.out.println("Vi tri thu : "+Collections.binarySearch(stringList,"Huy"));
    }
}
