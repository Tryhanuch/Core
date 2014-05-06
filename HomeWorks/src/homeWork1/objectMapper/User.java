package homeWork1.objectMapper;

/**
 * Created by tish on 22.04.2014.
 */

public class User {
    private int id;
    private String name;
    private int salary;
    private static int nextId = 1;

    public User(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    {
        id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }
}
