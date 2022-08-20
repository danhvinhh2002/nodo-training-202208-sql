package unit7_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopingAndMovingExample {
    public static void main(String[] args) {
        Path source = Paths.get("C:\\Tem\\hanoijava.txt");
        Path target = Paths.get("C:\\Tem\\hanoijava2.txt");
        try {
            Files.delete(target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Files.createLink(target,source);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Files.copy(source,target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
