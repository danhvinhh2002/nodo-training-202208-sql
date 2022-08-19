package unit7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileExample {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\danhv\\Desktop\\test\\Unit9\\src\\unit7.FileExample.java");
//        if(file.isFile() == true){
//            System.out.println("This is folder!");
//        }else{
//            System.out.println("This is file");
//        }

        System.out.println("This is "+((file.isFile()? "file" : "folder")));

        System.out.println(file.getName()+" : "+file.length() + "bytes");
    }
}
