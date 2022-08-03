import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static DbHelper helper;
    static Statement _State;
    static ResultSet ResultSet;

    public static void main(String[] args) throws SQLException {
        Connection _Connect = DriverManager.getConnection(helper.url, helper.Username, helper.Password);
        try {
            ExecuteAndReadData(_Connect);
           // InsertData();
         //   UpdateData();
            DeleteData();
        } catch (Exception ERR) {
            System.out.println(ERR);
        } finally {
            _Connect.close();
        }

    }


    private static void InsertData( ) {
        try {
            _State.executeUpdate("insert  into city(Id,Name,CountryCode,District,Info) values(12222,'duzce','tur','duzce','5000') ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    private static void DeleteData( ) {
        try {
            _State.executeUpdate( "delete from city where Id = 12222");
            System.out.println("data delete ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private static void UpdateData( ) {
        try {
            _State.executeUpdate("update city set Info ='2000' where  Id = 12222");
            System.out.println("data update oldu");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void ExecuteAndReadData(Connection _Connect)   {
        DbHelper helper = new DbHelper();

        helper.getConnection();
        try {
            _State = _Connect.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException("e1");
        }
        try {
            ResultSet = _State.executeQuery("select * from city");
        } catch (SQLException e) {
            throw new RuntimeException("e2");
        }
        ArrayList<City> _cty = new ArrayList<>();
        while (true) {
            try {
                if (!ResultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException("e3");
            }
            try {
                _cty.add(new City(ResultSet.getString(2)));
            } catch (SQLException e) {
                throw new RuntimeException("e4");
            }

        }
        System.out.println(_cty.size());
    }
}