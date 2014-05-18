package dataMapperDB;

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
        this.firstName = firstName;
        this.lastName = secondName;
        this.age = age;
        this.salary = salary;
    }

    public User(){

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
}
