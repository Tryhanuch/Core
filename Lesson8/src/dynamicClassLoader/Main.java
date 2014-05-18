package dynamicClassLoader;

import temp.User;

/**
 * Created by tish on 17.05.2014.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        User u = (User) Class.forName("temp.User").newInstance();


    }
}
