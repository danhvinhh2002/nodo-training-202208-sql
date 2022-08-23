import java.sql.*;

public class InsertDataExample {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                Connection con = DriverManager.getConnection(
                        "jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
                Statement statement = con.createStatement();
//                statement.execute("insert into danhvinh_student(id,genereted,name,age) values (1,1,N'Nguyễn Danh Vinh',20)");
//                statement.execute("insert into danhvinh_student(id,genereted,name,age) values (2,2,N'Nguyễn Van A',20)");
//                statement.execute("insert into danhvinh_student(id,genereted,name,age) values (3,3,N'Tong Van C',21)");
                statement.execute("insert into danhvinh_student(id,genereted,name,age) values (4,4,N'Trần Văn A',20)");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
