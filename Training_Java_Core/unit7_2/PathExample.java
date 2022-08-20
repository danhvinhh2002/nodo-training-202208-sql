package unit7_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

    public static void main(String[] args) throws  Exception{
        Path path = Paths.get("C:\\Tem");
        System.out.println("This is "+(Files.isDirectory(path)?"file": "folder"+"!"));
        System.out.println(Files.exists(path));

        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            for(Path p : directoryStream){
                System.out.println(p.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Path path2 = path.resolve("hanoijava.txt");
        Charset charset = Charset.forName("utf8");
        try(BufferedReader reader = Files.newBufferedReader(path2,charset)){
            String line = null;
            while(line == reader.readLine()){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}