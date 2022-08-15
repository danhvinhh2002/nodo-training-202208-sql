public class MethodExample {
    private static int add(int number1 , int number2){
        return number1 + number2;
    }
//    private static int add1() {
//        int total = 0;
//        for(){
//            total += element;
//        }
//        return total;
//    }
    public static void main(String[] args) {
        System.out.println("5 + 6 ="+add(5,6));
        int value1 = Integer.parseInt(args[0]);
        int value2 = Integer.parseInt(args[1]);

        System.out.println(value1 +"+"+ value2 + "=" +add(value1,value2));

    }

}
