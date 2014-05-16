package dataMapperDB;

import java.sql.*;

/**
 * Created by tish on 11.05.2014.
 */
public class User {
    private String firstName;
    private String lastName;
    private int age;
    private int salary;
    private long id;

    public User(String firstName, String secondName, int age, int salary) {
        id = setId();
        this.firstName = firstName;
        this.lastName = secondName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    private long setId(){
        long result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/my_schema?", "root", "36Dkr840");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + User.class.getSimpleName());

            while (resultSet.next()) {
                result = resultSet.getLong(1) + 1;
//                if (resultSet.equals(null)){
//                    result = 1;
//                }else {
//                    result = resultSet.getLong(1) + 1;
//                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
