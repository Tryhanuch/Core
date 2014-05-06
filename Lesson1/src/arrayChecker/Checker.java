package arrayChecker;

/**
 * Created by tish on 12.04.2014.
 */
public class Checker {

    public int arrayChecker(Object[] objects) throws NullPointerArrayException {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null){
                throw new NullPointerArrayException();
            }
        }
        return objects.length;
    }
}
