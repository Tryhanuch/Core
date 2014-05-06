package fileReader;

import java.io.FileNotFoundException;

/**
 * Created by tish on 12.04.2014.
 */
public class Main {
    public static void main(String[] args) {
        FileReadeR fr = new FileReadeR();
        try {
            fr.toRead();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (KirkorovException e) {
            e.opacha();
//            System.out.println("Опача... Киркоров!");
        } catch (NumbException e) {
            System.out.println("Да ну на...");
        }
    }
}
