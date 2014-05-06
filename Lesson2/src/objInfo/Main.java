package objInfo;

import java.io.IOException;

/**
 * Created by tish on 13.04.2014.
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, IOException {

        String str = "ololo";
        int a = 10;
        TestUser tu = new TestUser("Max", 15, 255);

        Info info = new Info();
//        info.objInfo(str);
//        info.objInfo(a);
//        info.objInfo(tu);
//        info.objInfo(info);

//        info.saveObj(tu);

        info.loadObj(tu);
        TestUser tu1 = (TestUser) info.loadObj(tu);
        System.out.println(tu1.getName());
        System.out.println(tu1.getAge());
    }
}
