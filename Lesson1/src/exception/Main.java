package exception;

import java.io.File;
import java.util.Scanner;

/**
 * Created by tish on 12.04.2014.
 */
public class Main {
    public static void main(String[] args) {
        File f = new File("");
        Scanner sc = null;

        try {
            Worker worker = new Worker();
            System.out.println("-----------------");
            worker.test2();
            sc = new Scanner(f);

        } catch (ControlException e) {
            System.out.println("1");
        } catch (Exception e) {
            System.out.println("2");
            return;
        } finally {
            //выполняется в любом случае
            if (sc != null){
                sc.close();
            }
        }

        System.out.println("+++++++++++++++++");
    }
}
