package dataMapper;

import java.io.*;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Created by tish on 11.05.2014.
 */
public class DBDataMapper implements DataMapper {
    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_CONNECTION = "jdbc:mysql://localhost/my_schema?";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "36Dkr840";
    public static final String CONF_EXT = ".conf";
    private Connection connection;

    public DBDataMapper(){
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Object o){
        String confFileName = o.getClass().getSimpleName() + CONF_EXT;

        List<String> fieldsName = loadConfigFile(confFileName);
        ArrayList<Field> fields = new ArrayList<>();

        for (int i = 0; i < fieldsName.size(); i++) {
            try {
                Field f = o.getClass().getDeclaredField(fieldsName.get(i));
                f.setAccessible(true);
                fields.add(f);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

        String sql = QueryBuilder.buildInsertSQL(o);
        PreparedStatement s = null;
        try {
            s = connection.prepareStatement(sql);
            s.setString(1, String.valueOf(fields.get(0).get(o)));
            s.setString(2, String.valueOf(fields.get(1).get(o)));
            s.setInt(3, Integer.parseInt(String.valueOf(fields.get(2).get(o))));
            s.setInt(4, Integer.parseInt(String.valueOf(fields.get(3).get(o))));
            s.executeUpdate();
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Object load(long id, Class clazz) {
        return null;
    }

    public List<Object> loadAll(Class clazz) {
        return null;
    }

    public void update(Object o) {

    }

    private List<String> loadConfigFile(String fName) {
        List<String> result = new ArrayList<>();
        File confFile = new File(getPath() + fName);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(confFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String s;
        try {
            assert br != null;
            while ((s = br.readLine()) != null) {
                String[] st = s.split(":");
                result.add(st[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private String getPath() {
        String path = null;
        Properties property = new Properties();

        try {
            property.load(new FileInputStream
                    ("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson7\\src\\dataMapper\\config.properties"));
            path = property.getProperty("dir.path");
        } catch (IOException e) {
            System.err.println("ERROR! Property file is not found!");
        }

        return path;
    }
}
