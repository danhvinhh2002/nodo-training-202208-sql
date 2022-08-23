import java.sql.*;

public class UpdateDataExample {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                Connection con = DriverManager.getConnection(
                        "jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
                PreparedStatement statement = con.prepareStatement("Update danhvinh_student set name = ? Where id = ?");
                statement.setString(1,"Nguyen Thi B");
                statement.setInt(2,2);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
