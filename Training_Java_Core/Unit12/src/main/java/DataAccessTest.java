import java.sql.SQLException;
import java.util.List;
import java.util.stream.IntStream;

public class DataAccessTest {
    public static void main(String[] args) throws Exception {
        DataAccessLogic data = new DataAccessLogic();
//        List<String> names = data.loadNames(1);
//        names.forEach(System.out::println);
        System.out.println("Total page= "+data.numberOfPage());
        IntStream.range(1,data.numberOfPage()+1).forEach(page ->{
            System.out.println("========================");
            try {

                List<String> names = data.loadNames(1);
                System.out.println(names);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
