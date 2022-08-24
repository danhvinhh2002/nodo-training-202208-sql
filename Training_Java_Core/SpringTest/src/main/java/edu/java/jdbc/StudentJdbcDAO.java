package edu.java.jdbc;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentJdbcDAO {
    DataSource dataSource;
    static Logger LOGGER;
    JdbcTemplate jdbcTemplate;
    private void setDataSouce(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    private void createTableIfNotExist() throws Exception {
        DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null,null,"DV_STUDENT",null);
        if(rs.next()){
            System.out.println("Table "+rs.getString("TABLE_NAME")+" already exists !");
            return;
        }
        jdbcTemplate.execute("CREATE TABLE DV_STUDENT(" +
                "id BIGINT PRIMARY KEY GENERATED ALWAYS " +
                "AS IDENTITY (START WITH 1,INCREMENT BY 1)," +
                "name VARCHAR(1000)," +
                "age INTEGER)");
    }

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
