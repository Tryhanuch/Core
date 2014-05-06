package homeWork1.objectMapper;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tish on 22.04.2014.
 */
public class Main {
    public static void main(String[] args) {
        User u0 = new User("Alex", 5500);
        User u1 = new User("Pit", 8800);
        User u2 = new User("Max", 7200);
        User u3;

        ArrayList<Object> users = new ArrayList<>();
        users.add(u0);
        users.add(u1);
        users.add(u2);

        try {
            ObjectMapper.save(users);
            u3 = (User) ObjectMapper.load(3);
            System.out.println(u3.getId() + " " + u3.getName() + " " + u3.getSalary());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
