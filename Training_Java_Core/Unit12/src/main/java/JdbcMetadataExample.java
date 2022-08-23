import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcMetadataExample {
    public static void main(String[] args) throws Exception {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("DB version: "+metaData.getDatabaseMajorVersion());
            System.out.println("Drive name: "+metaData.getDriverName());
        }finally {
            connection.close();
        }
    }
}
