package edu.java.spring.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "clazz")
public class JavaClazz {
    private List<Student> students;

    public JavaClazz(List<Student> list) {
        students = list;
    }


    @XmlElements(@XmlElement(name = "student",type = Student.class))
    public List<Student> getStudents() {
        return students;
    }
}
