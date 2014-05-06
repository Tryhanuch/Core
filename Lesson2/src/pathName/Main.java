package pathName;

import java.io.File;

/**
 * Created by tish on 13.04.2014.
 */
public class Main {
    public static void main(String[] args) {

        File path = new File("D:\\test");
        String prefix = "a";

        FormatPath fp = new FormatPath();
        fp.fileName(path, prefix);
        System.out.println();

        //-------------------------------------
        // Паттерн стратегия!
        String[]res = path.list((dir, name) -> name.startsWith("i"));

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
