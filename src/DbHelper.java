import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

   public static String Username = "root";
    public static String Password = "root1234";
    public static String url = "jdbc:mysql://localhost:3306/world_x";
    Connection _Connect;
    public Connection getConnection() {
        try {
            _Connect = DriverManager.getConnection(url, Username, Password);
            System.out.println("bağlanto Kuruldu");
        } catch (Exception e) {
            throw new RuntimeException("helper");
        }
        return _Connect;

    }


}
