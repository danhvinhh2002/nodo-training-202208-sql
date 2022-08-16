import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(1);
        numbers.add(4);
        numbers.add(5);
        numbers.add(8);
        numbers.add(3);
        numbers.add(7);

        System.out.println("Size of set: "+numbers.size());
    }
}
