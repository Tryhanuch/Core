package dataMapperDB;

import java.sql.*;

/**
 * Created by tish on 11.05.2014.
 */
public class Car {
    private String mark;
    private String model;
    private int price;
    private long id;

    public Car(String mark, String model, int coast) {
        id = setId();
        this.mark = mark;
        this.model = model;
        this.price = coast;
    }

    public String getMark() {

        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    private long setId() {
        long result = 0;
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/my_schema?", "root", "36Dkr840");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Car.class.getSimpleName());

            while (resultSet.next()) {
                if (resultSet.equals(null)){
                    result = 1;
                }else {
                    result = resultSet.getLong(1) + 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
