import oracle.jdbc.rowset.OracleJDBCRowSet;

import javax.sql.rowset.RowSetMetaDataImpl;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class WebRowSetExample {
    public static void main(String[] args) throws SQLException, IOException {
        Statement statement = null;
        Connection connection = null;
        try {

            connection = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from danhvinh_student");

            File file = new File("output.xml");
            FileWriter fileWriter = new FileWriter(file);
            WebRowSet wrs = RowSetProvider.newFactory().createWebRowSet();
            wrs.writeXml(rs, fileWriter);
            Desktop.getDesktop().open(file);
        } finally {
            connection.close();
        }
    }
}

