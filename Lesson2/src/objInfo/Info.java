package objInfo;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tish on 13.04.2014.
 */
public class Info {

    public void objInfo(Object o) throws IllegalAccessException {
        System.out.println(o.getClass().getSimpleName());
        System.out.println();

        Field[] fields = o.getClass().getDeclaredFields();
//
//        for (int i = 0; i < fields.length; i++) {
//            System.out.println(fields[i].getName());
//        }
//        System.out.println();
//
//        // запись через лямбда выражение
//        Arrays.asList(fields).forEach(f -> System.out.println(f.getName()));
//        System.out.println();

        // запись через лямбда выражение
        List<Field> lf = Arrays.asList(fields);
        lf.forEach(f -> {
            try{
                f.setAccessible(true);
                System.out.println(f.getName() + " " + f.get(o));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public void saveObj(Object o) throws IOException {
        File file = new File("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson2\\src\\objInfo\\info.txt");
        FileWriter fw = new FileWriter(file);

        fw.write(o.getClass().getSimpleName() + "\n");
        fw.write("\n");

        Field[] fields = o.getClass().getDeclaredFields();
        List<Field> lf = Arrays.asList(fields);
        lf.forEach(f -> {
            try{
                f.setAccessible(true);
                fw.write(f.getName() + " " + f.get(o) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        fw.write("\n");

        Method[] methods = o.getClass().getDeclaredMethods();
        List<Method> lm = Arrays.asList(methods);
        lm.forEach(m -> {
            try {
                fw.write(m.getName() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fw.write("\n");

        fw.close();
    }

    public Object loadObj(Object o) throws IOException {
        File file = new File("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson2\\src\\objInfo\\stream.txt");
        Object result = null;

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(o);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        try {
            result = ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ois.close();

        return result;
    }

}
