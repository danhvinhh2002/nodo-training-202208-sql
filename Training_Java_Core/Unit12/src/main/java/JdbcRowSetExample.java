import oracle.jdbc.rowset.OracleJDBCRowSet;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetMetaDataImpl;
import javax.sql.rowset.RowSetProvider;
import javax.xml.namespace.QName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcRowSetExample {
    public static void main(String[] args) throws SQLException {
        JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet();

        jdbcRs.setUrl("jdbc:oracle:thin:@27.118.22.14:1521:orcl");
        jdbcRs.setUsername("SCOTT");
        jdbcRs.setPassword("SCOTT");
        jdbcRs.setCommand("select * from danhvinh_student");
        jdbcRs.execute();
        while (jdbcRs.next()){
            System.out.println(jdbcRs.getInt(1)+"\t"+jdbcRs.getString("name"));
        }
//        jdbcRs.first();
//        jdbcRs.updateString("name","Hoang Van X");
//        jdbcRs.commit();

        jdbcRs.first();
        System.out.println(jdbcRs.getString("id")+"\t"+jdbcRs.getString(3));

        jdbcRs.absolute(8);
        System.out.println(jdbcRs.getString("name") +" : "+jdbcRs.getString(3));
        jdbcRs.close();
    }
}
