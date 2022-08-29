package edu.java.spring.dao.impl;

import edu.java.spring.dao.StudentDAO;
import edu.java.spring.jdbc.StudentJdbcDAO;
import edu.java.spring.model.Student;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDAOImpl implements StudentDAO, DisposableBean {

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    DataSource dataSource;
    @PostConstruct
    public void createTableIfNotExist() throws SQLException {
        DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "DV_STUDENT", null);
        if (rs.next()) {
            System.out.println("Table " + rs.getString("TABLE_NAME") + " already exists !");
            return;
        }
        String sql = "create table DV_STUDENT"
                + "("
                + "id int primary key ,"
                + "name varchar(255),"
                + "age int"
                + ")";
//        jdbcTemplate.execute(sql);
    }

    JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Student student) {
        jdbcTemplate.update("INSERT INTO DV_STUDENT(ID,NAME,AGE) VALUES (DV_STUDENT_SEQ.NEXTVAL,?,?)",student.getName(),student.getAge());
        System.out.println("Created Record Name = "+student.getName());
    }

    @Override
    public List<Student> list() {
     List<Student> studentList = new ArrayList<Student>();
     String sql ="SELECT * FROM DV_STUDENT";
     studentList = jdbcTemplate.query(sql,new StudentRowMapper());
     return  studentList;
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.execute("DELETE FROM DV_STUDENT WHERE ID="+id);
    }

    @Override
    public Student getById(Integer id) {
        StudentRowMapper mapper = new StudentRowMapper();
        return jdbcTemplate.queryForObject("SELECT * FROM DV_STUDENT WHERE ID= "+id,mapper);
    }

    @Override
    public void destroy() throws Exception {
        DriverManager.getConnection("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
    }
    private final static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            try {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                return student;
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
    }
}
