package dataMapperDB;

import dataMapperDB.annotations.Entity;

/**
 * Created by tish on 18.05.2014.
 */
@Entity(name = "Student")
public class Student {
    private String firstName;
    private String secondName;
    private int age;
    private long id;

    public Student(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

}
