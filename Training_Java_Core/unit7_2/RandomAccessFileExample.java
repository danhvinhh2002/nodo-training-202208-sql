package unit7_2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Tem\\hanoijava2.txt");
        ByteBuffer buffer = ByteBuffer.allocate(14);
        try(FileChannel fc = FileChannel.open(path)) {
            fc.read(buffer);
            System.out.println(new String(buffer.array()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
