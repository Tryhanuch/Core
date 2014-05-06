package pathName;

import java.io.File;

/**
 * Created by tish on 13.04.2014.
 */
public class FormatPath {

    public void fileName(File pathName, String prefix){
        String[] fileName = pathName.list();

        for (int i = 0; i < fileName.length; i++) {
            if (fileName[i].startsWith(prefix)){
                System.out.println(fileName[i]);
            }
        }
    }

}
