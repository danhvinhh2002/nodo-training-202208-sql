import java.io.File;
import java.sql.*;

public class JdbcFirstExample {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                Connection con = DriverManager.getConnection(
                        "jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM DANHVINH_SACH");
//                while (resultSet.next()){
//                    System.out.println(resultSet.getString(3));
//                }
                String sql = "create table danhvinh_student(\n" +
                        "    id number(4) primary key,\n" +
                        "    genereted int unique ,\n" +
                        "    name varchar2(100),\n" +
                        "    age int default (20)\n" +
                        ")";

                System.out.println(statement.execute(sql));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
