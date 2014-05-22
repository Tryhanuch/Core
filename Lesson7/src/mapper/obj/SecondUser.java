package mapper.obj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by tish on 22.04.2014.
 */

public class SecondUser {
    private long id;
    private String name;
    private int salary;
    private static long nextId = 1;

    public SecondUser() {

    }

    public SecondUser(String name, int salary) {

        // id setting!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        {
            File fId = new File("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson7\\src\\mapper\\files\\id.txt");
            FileWriter fw = null;
            Scanner sc = null;
            try {
                fw = new FileWriter(fId);
                sc = new Scanner(fId);
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (sc.hasNextLine()) {
                String[] str = sc.nextLine().split(" ");
                for (int i = 0; i < str.length; i++) {
                    if (str[i].equals("User")) {
                        nextId = Integer.parseInt(str[i + 1]);
                    }
                }
            }

            id = nextId;
            nextId++;

            try {
                fw.write("User " + nextId);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public static long getNextId() {
        return nextId;
    }
}
