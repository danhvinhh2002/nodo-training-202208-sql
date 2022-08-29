package edu.java.spring.jdbc;

import edu.java.spring.model.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class JdbcApp {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
//        jdbc.LOGGER.info("created bean "+jdbc);
//        jdbc.insert(3,"Nguyen Danh Vinh",20);

//        jdbc.loadStudent("A").forEach(student -> {
//            System.out.println(student);
//        });
//        jdbc.update(15,"Tran Van A");
//        jdbc.delete(2);
//        students.add(new Student(4,"Nguyen Tien Hai",20));
//        students.add(new Student(5,"Hà Trung Kiên",20));
//        students.add(new Student(6,"Viết Tiến Vương",20));
//        int[] values = jdbc.add(students);
//        for(int i = 0 ;i< values.length;i++){
//            System.out.println("Add record "+i+" : "+(values[i] ==0 ? "false" : "success"));
//        }
//        System.out.println("Total students is: "+jdbc.totalRecord());

        jdbc.save(8,"Ha Viet Anh",20);
    }
}
