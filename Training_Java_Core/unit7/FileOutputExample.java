package unit7;

import java.io.*;

public class FileOutputExample {
    public static void main(String[] args) throws IOException {
        File file = new File("C:" + File.separator + "Tem" + File.separator + "hanoijava.txt");
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            String bytes = ("Hello Ha Noi java Class");
            outputStream.write(bytes.getBytes());
        } finally {
            if(outputStream !=null){
                outputStream.close();
            }
        }
        FileInputStream inputStream = null;
        try{
            inputStream = new FileInputStream(file);
//            byte[] bytes = new byte[17];
//            inputStream.read(bytes);
//            System.out.println(new String(bytes));
            byte[] bytes = new byte[4*1024];
            int read = -1;
            StringBuilder builder = new StringBuilder();
            while((read = inputStream.read(bytes)) != -1){
                builder.append(new String(bytes,0,read));
            }
            System.out.println("[ "+builder+" ]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        byte[] bytes = new byte[124];
//        System.out.println("[ "+new String(bytes)+ "]");
    }

}
