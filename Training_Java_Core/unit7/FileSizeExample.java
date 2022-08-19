package unit7;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class FileSizeExample {
    private static long getSize(File file){
        if(file.isFile() == true){
            return file.length();
        }
        AtomicLong length = null;
        Arrays.stream(file.list()).forEach(f ->{
            length.getAndSet(length.longValue()+ (!file.isFile()? getSize(file) : file.length()));
        });
        return length.longValue();
//        File[] files = file.listFiles();
//        int length = 0;
//        for(int i = 0 ; i< files.length; i++){
//            if(files[i].isFile()){
//                length += getSize(files[i]);
//                continue;
//            }
//            length += files.length;
////        }
//        return length;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\danhv\\Desktop\\test\\Unit9\\src\\unit7.FileSizeExample.java");
        System.out.println("Size: "+getSize(file)/(1024*1024) + "MB");
    }
}

