import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer,String> treeMap = new TreeMap<>() ;
        treeMap.put(3,"Nguyen Van A");
        treeMap.put(1,"Nguyen Thi B");
        treeMap.put(2,"Tran Thi C");
        treeMap.put(5,"Vuong Danh D");

        Iterator<Map.Entry<Integer,String>> iterator = treeMap.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<Integer,String> entry = iterator.next();
//            System.out.println(entry.getKey()+ ":" +entry.getValue());
//        }
        treeMap.descendingKeySet().forEach(key -> {
            System.out.println("key ="+key+ ":" +treeMap.get(key));
        });
    }
}
