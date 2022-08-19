package unit7;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessExample {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Tem\\test1\\sample.txt");
        try{
            RandomAccessFile randomAccess= new RandomAccessFile(file,"rw");
            randomAccess.seek(1);
            byte[] bytes = new byte[4 * 102];
            int read = randomAccess.read(bytes);
            System.out.println(new String(bytes,0,read,"utf8"));
            
            randomAccess.seek(file.length());
            randomAccess.write("\r\n".getBytes());
            randomAccess.writeChars("Hello java");
            Desktop.getDesktop();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
