package edu.java.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
        jdbc.LOGGER.info("created bean "+jdbc);
    }
}
