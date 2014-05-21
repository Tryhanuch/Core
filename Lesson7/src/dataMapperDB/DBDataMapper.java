package dataMapperDB;

import java.io.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Created by tish on 11.05.2014.
 */
public class DBDataMapper implements DataMapper {
    //TODO to property file
    public static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_CONNECTION = "jdbc:mysql://localhost/my_schema?";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "36Dkr840";
    public static final String CONF_EXT = ".conf";
    private Connection connection;

    public DBDataMapper(){

    }

    //Connection setting!
    {
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
        PreparedStatement s;
        try {
            s = connection.prepareStatement(sql);
            int x = 1;
            for (int i = 0; i < fields.size(); i++) {
                if (fields.get(i).getType().equals(String.class)){
                    s.setString(x, String.valueOf(fields.get(i).get(o)));
                }else if (fields.get(i).getType().equals(int.class)){
                    s.setInt(x, Integer.parseInt(String.valueOf(fields.get(i).get(o))));
                }else if (fields.get(i).getType().equals(long.class)){
                    s.setLong(x, Long.parseLong(String.valueOf(fields.get(i).get(o))));
                }else if (fields.get(i).getType().equals(byte.class)){
                    s.setByte(x, Byte.parseByte(String.valueOf(fields.get(i).get(o))));
                }else if (fields.get(i).getType().equals(double.class)){
                    s.setDouble(x, Double.parseDouble(String.valueOf(fields.get(i).get(o))));
                }else if (fields.get(i).getType().equals(float.class)){
                    s.setFloat(x, Float.parseFloat(String.valueOf(fields.get(i).get(o))));
                }else if (fields.get(i).getType().equals(short.class)){
                    s.setShort(x, Short.parseShort(String.valueOf(fields.get(i).get(o))));
                }else if (fields.get(i).getType().equals(boolean.class)){
                    s.setBoolean(x, Boolean.parseBoolean(String.valueOf(fields.get(i).get(o))));
                }
                x++;
            }
            s.executeUpdate();

        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Object load(long id, Class clazz) {
        String confFileName = clazz.getSimpleName() + CONF_EXT;

        try {
            Object result = clazz.newInstance();

            String sql = QueryBuilder.buildSelectByIdSQL(result, id);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<String[]> line = parseLine(resultSet, confFileName);
            List<String> fieldsName = loadConfigFile(confFileName);

            for (int i = 0; i < line.size(); i++) {
                String[] strFields = line.get(i);
                result = getObject(fieldsName, strFields, result);
            }

            return result;
        } catch (InstantiationException | IllegalAccessException | SQLException e1) {
            e1.printStackTrace();
        }

        return null;
    }

    public List<Object> loadAll(Class clazz) {
        List<Object> result = new ArrayList<>();
        String confFileName = clazz.getSimpleName() + CONF_EXT;

        try {
            String sql = QueryBuilder.buildSelectAllSQL(clazz.newInstance());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<String[]> line = parseLine(resultSet, confFileName);
            List<String> fieldsName = loadConfigFile(confFileName);

            for (int i = 0; i < line.size(); i++) {
                Object object = clazz.newInstance();
                String[] strFields = line.get(i);
                object = getObject(fieldsName, strFields, object);
                result.add(object);
            }
        } catch (InstantiationException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }

        return result;
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

    private List<String[]> parseLine(ResultSet rs, String fName){
        List<String[]> result = new ArrayList<>();
        File confFile = new File(getPath() + fName);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(confFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int count = 0;
        String s;
        try {
            assert br != null;
            while ((s = br.readLine()) != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()){
                String[] line = new String[count];
                for (int i = 0; i < line.length; i++) {
                    line[i] = rs.getString(i + 1);
                }

                result.add(line);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private Object getObject(List<String> fieldsName, String[] strFields, Object o) throws IllegalAccessException {
        for (int i = 0; i < fieldsName.size(); i++) {
            Field f = null;
            try {
                f = o.getClass().getDeclaredField(fieldsName.get(i));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            assert f != null;
            f.setAccessible(true);

            if (f.getType().equals(String.class)) {
                f.set(o, strFields[i]);
            } else if (f.getType().equals(int.class)) {
                f.set(o, Integer.parseInt(strFields[i]));
            } else if (f.getType().equals(long.class)) {
                f.set(o, Long.parseLong(strFields[i]));
            } else if (f.getType().equals(byte.class)) {
                f.set(o, Byte.parseByte(strFields[i]));
            } else if (f.getType().equals(double.class)) {
                f.set(o, Double.parseDouble(strFields[i]));
            } else if (f.getType().equals(float.class)) {
                f.set(o, Float.parseFloat(strFields[i]));
            } else if (f.getType().equals(short.class)) {
                f.set(o, Short.parseShort(strFields[i]));
            } else if (f.getType().equals(boolean.class)) {
                f.set(o, Boolean.parseBoolean(strFields[i]));
            }
        }

        return o;
    }

    private String getPath() {
        String path = null;
        Properties property = new Properties();

        try {
            property.load(new FileInputStream
                    ("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson7\\src\\dataMapperDB\\files\\config.properties"));
            path = property.getProperty("dir.path");
        } catch (IOException e) {
            System.err.println("ERROR! Property file is not found!");
        }

        return path;
    }

}
