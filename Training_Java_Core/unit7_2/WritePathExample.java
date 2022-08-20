package unit7_2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritePathExample {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Tem\\hanoijava.txt");
        Charset charset = Charset.forName("utf8");
        try(BufferedWriter writer =Files.newBufferedWriter(path,charset)) {
            for (int i = 0; i< 10; i++){
                writer.write("Nguyen van "+i+"\r\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
