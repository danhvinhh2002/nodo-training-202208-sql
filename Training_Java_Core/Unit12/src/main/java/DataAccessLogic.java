import javax.sql.rowset.BaseRowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.spi.SyncResolver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessLogic  {
    private final static Logger logger = Logger.getLogger(DataAccessLogic.class.getName());
    Connection connection = null;
    CachedRowSet rowSet;

    public DataAccessLogic() throws Exception{
        this.connection = DriverManager.getConnection(    "jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
        rowSet = RowSetProvider.newFactory().createCachedRowSet();
        rowSet.setCommand("Select * from danhvinh_student");
        rowSet.execute(connection);
    }
    public void disconnect() throws SQLException {
        try {
            if(connection != null){
                connection.close();
            }
        }catch (SQLException e){
            logger.log(Level.WARNING,e.toString());
        }
    }
    int pageSize = 10;
    List<String> loadNames(int page) throws SQLException {
        List<String> names = new ArrayList<>();
        rowSet.setPageSize(pageSize);
        int start = (page -1) * pageSize +1;
        if(!rowSet.absolute(start) ){
            return names;
        }
        rowSet.previous();
        while (rowSet.next()){
            names.add(rowSet.getString("name"));
            if(names.size() >= pageSize){
                break;
            }
        }
        return names;
    }
    int numberOfPage() throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select count(*) from danhvinh_student");
            if(!rs.next()){
                return 0;
            }
            int total = rs.getInt(1);
            int totalPage = total/pageSize;
            if(total%pageSize != 0){
                totalPage++;
                return totalPage;
            }
        }finally {
            statement.close();
        }
        return 0;
    }
}
