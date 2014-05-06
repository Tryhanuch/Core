package dataMapper;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by tish on 22.04.2014.
 */
public class FileDataMapper implements DataMapper {
    public static final String DATA_EXT = ".txt";
    public static final String CONF_EXT = ".conf";
    private HashMap<String, Integer> idMap = new HashMap<>();

    public void save(Object o) {
        String className = o.getClass().getSimpleName();
        String confFileName = className + CONF_EXT;
        String dataFileName = className + DATA_EXT;
        File dataFile = new File(getPath() + dataFileName);
        FileWriter fw = null;
        try {
            fw = new FileWriter(dataFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> fieldsName = loadConfigFile(confFileName);
        ArrayList<Field> fields = new ArrayList<>();

        for (int i = 0; i < fieldsName.size(); i++) {
            try {
                Field f = o.getClass().getDeclaredField(fieldsName.get(i));
                f.setAccessible(true);
                fields.add(f);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < fields.size(); i++) {
            try {
                fw.write(String.valueOf(fields.get(i).get(o)) + ":");
            } catch (IllegalAccessException | IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fw.write("\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object load(long id, Class clazz) {
        try {
            Object result = clazz.newInstance();
            String confFileName = clazz.getSimpleName() + CONF_EXT;
            String dataFileName = clazz.getSimpleName() + DATA_EXT;
            String[] strFields = findLineWithId(id, dataFileName);
            List<String> fieldsName = loadConfigFile(confFileName);

            return getObject(fieldsName, strFields, result);

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void loadAll(Class clazz) {

//        Object result = clazz.newInstance();

        String dataFileName = clazz.getSimpleName() + DATA_EXT;
        String confFileName = clazz.getSimpleName() + CONF_EXT;
        File dataFile = new File(getPath() + dataFileName);
        List<String> fieldsName = loadConfigFile(confFileName);
        Scanner sc = null;
        try {
            sc = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (sc != null) {
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(":");
            }
        }
    }

    public void update(Object o) {

    }

//    //конструктор с id

//    public FileDataMapper() throws FileNotFoundException {
//        File f = new File("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson4\\src\\dataMapper\\id.conf");
//        Scanner sc = new Scanner(f);
//        while (sc.hasNextLine()) {
//            String[] strs = sc.nextLine().split(" ");
//            idMap.put((strs[0]), Integer.parseInt(strs[1]));
//        }
//    }

    private String[] findLineWithId(long id, String fName) {
        String[] result = null;
        File dataFile = new File(getPath() + fName);
        Scanner sc = null;
        try {
            sc = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(":");
            if (Long.parseLong(line[0]) == id) {
                result = line;
            }
        }

        return result;
    }

    private List<String> loadConfigFile(String fName) {
        List<String> result = new ArrayList<>();
        File confFile = new File(getPath() + fName);
        Scanner sc = null;
        try {
            sc = new Scanner(confFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (sc != null) {
            while (sc.hasNext()) {
                result.add(sc.next());
            }
        }

        return result;
    }

    private Object getObject(List<String> fieldsName, String[] strFields, Object o) throws IllegalAccessException {
        for (int i = 0; i < fieldsName.size(); i++) {
            Field f = null;
            try {
                f = o.getClass().getDeclaredField(fieldsName.get(i));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            f.setAccessible(true);

            if (f.getType().equals(String.class)) {
                f.set(o, strFields[i]);
            } else if (f.getType().equals(int.class)) {
                f.set(o, Integer.parseInt(strFields[i]));
            } else if (f.getType().equals(long.class)) {
                f.set(o, Long.parseLong(strFields[i]));
            } else if (f.getType().equals(byte.class)) {
                f.set(o, Byte.parseByte(strFields[i]));
            } else if (f.getType().equals(double.class)) {
                f.set(o, Double.parseDouble(strFields[i]));
            } else if (f.getType().equals(float.class)) {
                f.set(o, Float.parseFloat(strFields[i]));
            } else if (f.getType().equals(short.class)) {
                f.set(o, Short.parseShort(strFields[i]));
            } else if (f.getType().equals(boolean.class)) {
                f.set(o, Boolean.parseBoolean(strFields[i]));
            }
        }

        return o;
    }

    private String getPath() {
        String path = null;
        Properties property = new Properties();

        try {
            property.load(new FileInputStream
                    ("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson4\\src\\dataMapper\\config.properties"));
            path = property.getProperty("dir.path");
        } catch (IOException e) {
            System.err.println("ERROR! Property file is not found!");
        }

        return path;
    }
}
