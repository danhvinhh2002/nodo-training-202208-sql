public class TryCatchExample {
    private int toNumber(String value){
        try {
            Integer integer = Integer.parseInt(value);
            return integer.intValue();
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        TryCatchExample tr = new TryCatchExample();
        int number = tr.toNumber("34");
        System.out.println("number ="+number);
        number = tr.toNumber("as");
        System.out.println("number ="+number);
    }
}
