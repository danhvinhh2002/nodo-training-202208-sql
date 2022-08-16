import java.util.Hashtable;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer,String> map = new Hashtable<Integer,String>();
        map.put(3,"Nguyen Van A");
        map.put(1,"Nguyen Thi B");
        map.put(2,"Tran Thi C");
        map.put(5,"Vuong Danh D");

        System.out.println(map.get(3));

        map.put(3,"Nguyen Thi A");
        System.out.println(map.get(3));
    }
}
