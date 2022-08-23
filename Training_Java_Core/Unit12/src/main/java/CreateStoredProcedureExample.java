import java.sql.*;

public class CreateStoredProcedureExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("CREATE PROCEDURE danhvinh_GETAGE(STREAM_NAME VARCHAR(255),OUT AGE INT)"+
                    "PARAMETER STYLE JAVA READS "+
                    "SQL DATA LANGUAGE JAVA EXTERNAL NAME"+
                    "'jdbc.DbFunction.getAge'");
            System.out.println("done");
        }finally {
            connection.close();
        }
    }
}
