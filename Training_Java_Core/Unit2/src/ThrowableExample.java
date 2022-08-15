import java.util.logging.Level;
import java.util.logging.Logger;

public class ThrowableExample {
    public static class SaiSoException extends Exception{
        private String so;
        public  SaiSoException(String value){
            this.so=value;
        }
        public String getMessage(){
            return "Gia tri \'" +so+ "\'Khong phai so!";
        }
    }
    public  int toNumber(String value ) throws SaiSoException{
        try{
            Integer integer =  Integer.parseInt(value);
            return  integer.intValue();
        }catch (NumberFormatException e){
            throw new SaiSoException(value);
        }

    }
    private final static Logger LOGGER = Logger.getLogger(ThrowableExample.class.getName());
    public static void main(String[] args) {
        try {
            ThrowableExample th = new ThrowableExample();
            System.out.println("number" +th.toNumber(args[0]));
        }catch (SaiSoException e){
            System.err.println(e.getMessage());
            LOGGER.log(Level.WARNING, e.getMessage());
        }
    }
}
