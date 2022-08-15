import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CharacterExample {
    private static int countDigit(String value){
//        int i = 0;
//        int counter = 0;
//        while(i < value.length()){
//            char c =value.charAt(i);
//            if(Character.isDigit(c)){
//                counter ++;
//
//            }
//            i++;
//
//        }
//        return counter++;
        AtomicInteger couter = new AtomicInteger(0);
        IntStream stream = value.chars();
        stream.forEach(c ->{
            if(Character.isDigit(c))couter.incrementAndGet();
        });
        return  couter.get();
    }


    public static void main(String[] args) {
        System.out.println("There are "+countDigit(args[0])+ "digits in the text");

    }
}
