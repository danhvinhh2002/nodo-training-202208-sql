package unit7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriterExample {
    public static void main(String[] args) throws IOException {
        File folder = new File("C:\\Tem\\test1\\sample.txt");
        ObjectOutputStream output ;

        FileOutputStream fileOutput = new FileOutputStream(folder, Boolean.parseBoolean("my_object"));
        output = new ObjectOutputStream(fileOutput);
        PrintMessage message;
        output.writeObject(new PrintMessage("Can Noi noi"));
//        output.close();
    }
}
