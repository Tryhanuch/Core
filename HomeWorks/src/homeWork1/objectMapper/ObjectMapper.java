package homeWork1.objectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tish on 22.04.2014.
 */
public class ObjectMapper {

    public static void save(ArrayList<Object> users) throws IOException {

        File file = new File("C:\\Users\\tish\\IdeaProjects\\Core\\HomeWorks\\src\\homeWork1\\info.txt");
        FileWriter fw = new FileWriter(file);

        for (int j = 0, usersSize = users.size(); j < usersSize; j++) {
            Object user = users.get(j);
            Field[] fields = user.getClass().getDeclaredFields();
            for (int i = 0, fieldsLength = fields.length; i < fieldsLength; i++) {
                Field field = fields[i];
                try {
                    field.setAccessible(true);
                    fw.write(field.getName() + ":" + field.get(user) + ":");
                } catch (IOException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            fw.write("\n");
        }

        fw.close();
    }

    public static Object load(int id) throws FileNotFoundException {

        Object result = null;
        String name;
        int salary;

        File file = new File("C:\\Users\\tish\\IdeaProjects\\Core\\HomeWorks\\src\\homeWork1\\info.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            String[] str = sc.nextLine().split(":");
            for (int i = 0; i < str.length; i++) {
                if (str[i].equals("id")) {
                    if (Integer.parseInt(str[i + 1]) == (id)) {
                        name = str[i + 3];
                        salary = Integer.parseInt(str[i + 5]);
                        result = new User(name, salary);
                    }
                }
            }
        }

        return result;
    }
}
