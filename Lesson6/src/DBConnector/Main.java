package DBConnector;

import java.util.List;

/**
 * Created by tish on 10.05.2014.
 */
public class Main {
    public static void main(String[] args) {
        String db = "jdbc:mysql://localhost/my_schema?" + "user=root&password=36Dkr840";
        String table = "user";

        Utility utility = new Utility();
        List<User> users = utility.load(db, table);

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getFirstName() + " " +
                    users.get(i).getLastName() + " " +
                    users.get(i).getAge() + " " +
                    users.get(i).getSalary());
        }

    }
}
