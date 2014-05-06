package fileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by tish on 12.04.2014.
 */
public class FileReadeR {

    public void toRead() throws FileNotFoundException, KirkorovException, NumbException {
        File f = new File("C:\\Users\\tish\\IdeaProjects\\Core\\Lesson1\\src\\fileReader\\file.txt");
        Scanner sc = new Scanner(f);

        while (sc.hasNext()) {
            String [] str = sc.nextLine().split(":");

            if (str[0].equals("Philip") && str[1].equals("Kirkorov")){
                throw new KirkorovException();
            } else if (Integer.parseInt(str[2]) < 0 || Integer.parseInt(str[3]) < 0);{
                throw new NumbException();
            }
        }



    }
}
