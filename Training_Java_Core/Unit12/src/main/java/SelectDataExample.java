import java.sql.*;

public class SelectDataExample {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                Connection con = DriverManager.getConnection(
                        "jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM danhvinh_student");
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    int genereted = resultSet.getInt("genereted");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");

                    System.out.println(id+"\t"+name+"\t"+age);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

