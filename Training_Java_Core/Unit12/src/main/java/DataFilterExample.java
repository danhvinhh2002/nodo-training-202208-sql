import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataFilterExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        FilteredRowSet frs = RowSetProvider.newFactory().createFilteredRowSet();
        frs.setUsername("SCOTT");
        frs.setPassword("SCOTT");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        frs.setUrl("jdbc:oracle:thin:@27.118.22.14:1521:orcl");

        frs.setCommand("Select * from danhvinh_student");
        frs.setFilter(new DataFilter());
        frs.execute();

        System.out.println("ID\t Name\t Age");
        while (frs.next()){
            System.out.println(frs.getInt(1)+"\t"+frs.getString("name")+"\t"+frs.getInt(4));
        }
    }
}
