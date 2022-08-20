package unit7_2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.FileVisitResult;

public class FileVisitorExample {

    public static class PrintFiles extends SimpleFileVisitor<Path>{

        public FileVisitResult visitFile(Path path)  {
            System.out.println(path+"is file" );
            return FileVisitResult.CONTINUE;
        }
        public FileVisitResult postVisitDirectory() {
            System.out.println("is Directory");
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Tem\\test1");
        Files.walkFileTree(path,new PrintFiles());
    }
}
