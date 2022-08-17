package chuong9;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Consumer<Student> consumer = (Student student)->{
            if(student.getAge() > 23){
                student.getAge();
                students.add(student);
            }
        };
        consumer.accept(new Student(34,"Nguyen Van A"));
        System.out.println(students.get(0));
        String[] names = {"Tran Van A","Nguyen Thi C","Nguyen Van A","Nguyen Thi D"};
        Integer[] ages = {23,45,34,20};
        IntStream intStream = IntStream.rangeClosed(0,names.length-1);
        Stream<Student> stream = intStream.mapToObj(value -> new Student(ages[value], names[value]));
        Consumer<Student> c = (Student student) -> {
            System.out.println(student);
        };
//        stream.forEach(c);
     c = (Student student) ->{
        System.out.println(student);
    };
        Function<Student,String> jsonToFunction = (Student student)->{
            StringBuilder builder = new StringBuilder();
            builder.append("student{\n");
            builder.append("\tid: ").append(student.getId()).append("\n");
            builder.append("\tname: ").append(student.getName()).append("\n");
            builder.append("\tage: ").append(student.getAge()).append("\n");
            builder.append("}");
            return builder.toString();
        };
        c = (Student student) ->{
            System.out.println(jsonToFunction.apply(student));
        };
//        stream.forEach(c);

        Predicate<Student> predicate = (Student student) ->{
            return student.getAge()>30;

        };
        Stream<Student> older = stream.filter(predicate);
        older.forEach(c);
    }
}
