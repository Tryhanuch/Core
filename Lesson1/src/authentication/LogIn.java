package authentication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tish on 12.04.2014.
 */
public class LogIn {

    public void logIn(String login, String pass) throws FileNotFoundException, OutAuthenticationException {
        File file = new File("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson1\\src\\authentication\\logFile.txt");
        Scanner sc = new Scanner(file);
        ArrayList<String> lines = new ArrayList<String>();

        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        for (int i = 0; i < lines.size(); i++) {
            String[] str = lines.get(i).split(" ");
            if (str[0].equals(login) && str[1].equals(pass)) {
                System.out.println("Authentication success!");
                return;
            }
        }

        throw new OutAuthenticationException();

    }
}
