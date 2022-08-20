package unit7_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LinkFileExample {
    public static void main(String[] args) {
        Path source = Paths.get("C:\\Tem\\hanoijava.txt");
        Path target = Paths.get("C:\\Tem\\hanoijava2.txt");
        Charset charset = Charset.forName("utf8");
        try(BufferedWriter writer = Files.newBufferedWriter(source,charset)) {
            writer.write("Java NIO 2 example \r\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(BufferedReader reader = Files.newBufferedReader(target,charset)){
            String line = null;
            while((line == reader.readLine())){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
