package objInfo;

import java.io.Serializable;

/**
 * Created by tish on 13.04.2014.
 */
public class TestUser implements Serializable{
    private String name;
    private int age;
    private int salary;

    public TestUser(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
