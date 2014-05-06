package arrayChecker;

/**
 * Created by tish on 12.04.2014.
 */
public class Main {
    public static void main(String[] args) {
        String [] str = new String[5];
        str[0] = "ololo";
        str[1] = "ololo";
        str[2] = "ololo";
        str[3] = null;
        str[4] = "ololo";

        Checker checker = new Checker();
        try {
            System.out.println(checker.arrayChecker(str));
        } catch (NullPointerArrayException e) {
            e.ex();
        }
    }
}
