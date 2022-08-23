import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BatchProcessingExample {
    public static void main(String[] args) throws Exception {
        Connection connection = null;

        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Statement statement = connection.createStatement();
        connection.setAutoCommit(false);
        for(int i = 0 ; i < 20 ; i++){
            int id = i +5;
            int genereted = i+5 ;
            String name ="Tran Van "+i;
            int age = 10 + i ;
            String sql ="insert into danhvinh_student (id,genereted,name,age) values " +
                    "("+id+","+genereted+",'"+name+"',"+age+")";
            statement.addBatch(sql);
        }
        statement.executeBatch();
        ResultSet rs = statement.executeQuery("select count(*) from danhvinh_student");
        if(rs.next()){
            System.out.println("total records = "+rs.getInt(1));
            connection.close();
        }

    }
}
