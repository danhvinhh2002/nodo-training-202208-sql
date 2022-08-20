package unit7_2;

import java.io.IOException;
import java.nio.file.*;

public class FileFinderExample {
    static class Finder extends SimpleFileVisitor<Path> {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt}");

        public FileVisitResult visitFile(Path path) {
            if (matcher.matches(path.getFileName())) {
                System.out.println("found: " + path);

            }
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        Finder finder = new Finder();
        Files.walkFileTree(Path.of("C:\\Tem"), finder);
    }
}