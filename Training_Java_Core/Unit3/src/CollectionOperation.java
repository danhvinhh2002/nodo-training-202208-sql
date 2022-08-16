import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionOperation {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(4, 7, 8, 5, 2, 3));
        Comparator<Integer> comparator = Integer:: compare;
        Collections.sort(listOfIntegers,comparator);

        listOfIntegers.stream().filter(v -> v > 5).forEach(v ->{
            System.out.println(v);
        });
        Integer[] values = listOfIntegers.stream().filter(v -> v > 5).toArray(size -> new Integer[size]);
        Arrays.stream(values).forEach(v ->{
            System.out.println(v);
        });
        Collector<Integer,?,IntSummaryStatistics> collector= Collectors.summarizingInt(Integer:: intValue);
        IntSummaryStatistics summaryStatistics = listOfIntegers.stream().collect(collector);
        System.out.println("total= "+summaryStatistics.getSum());
        System.out.println("overage= "+summaryStatistics.getAverage());
        int sum = listOfIntegers.stream().reduce(0,(x,y) -> x+y);
        Consumer<Integer> myConsumer = n -> {
            System.out.println("user input value : "+n);
            if(n < 5){
                System.out.println("Invalid value!");
                return;
            }
            listOfIntegers.add(n);
            System.out.println("values: ");
            listOfIntegers.forEach(x -> System.out.println(" - "+x));
        };
        myConsumer.accept(12);
//        int value;
//        Scanner sc = new Scanner(System.in);
//        while (true){
//            System.out.print("Please input a number: ");
//            value = sc.nextInt();
//            myConsumer.accept(value);
//            System.out.println();
//            break;
//        }
        Predicate<Integer> tester = v -> v > 5;
        myConsumer = n -> listOfIntegers.add(n);
        Scanner sc1 = new Scanner(System.in);
        while (true){
            System.out.println("Please input a number: ");
            int value1 = sc1.nextInt();
            if(value1 < 0){
                break;
            }
            if(tester.test(value1)){
                myConsumer.accept(value1);
            }
            listOfIntegers.forEach(x -> {
                System.out.println(x+" -");
            });
        }
    }
}
