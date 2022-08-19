package unit7;

import java.awt.*;
import java.io.*;

public class ReaderWriterExample {
    public static void main(String[] args) throws Exception{
//        File file = new File("C:\\Tem\\test1\\sample.txt");
//        try{
//            FileWriter writer = new FileWriter(file);
//            writer.write("\r\n");
//            writer.write("Tran Thi B");
//            writer.close();
//            Desktop.getDesktop();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try {
            File file = new File("C:\\Tem\\test1\\sample.txt");
            FileReader fd= new FileReader(file);
            char[] buffer= new char[4*1024];
            int read=-1;
            StringBuilder builder= new StringBuilder();
            while ((read= fd.read(buffer))!=-1){
                builder.append(buffer,0,read);
            }
            System.out.println(builder);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
