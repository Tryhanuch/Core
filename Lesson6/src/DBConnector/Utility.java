package DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tish on 10.05.2014.
 */
public class Utility {

    private Connection getConnection(String db) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(db);
            return connect;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> loadAll(String db, String table) {
        Connection con = getConnection(db);
        List<User> result = new ArrayList<>();

        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + table);

            assert resultSet != null;
            while (resultSet.next()) {
                User temp = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                result.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void save(String db, String table, User user){
        Connection con = getConnection(db);


    }
}
