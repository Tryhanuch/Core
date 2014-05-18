package dynamicClassLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by tish on 17.05.2014.
 */
public class MainThread implements Runnable {

    private Algorithm alg; //TODO load from dir
    private Properties props;

    @Override
    public void run() {
        String dirTxt = props.getProperty("dir_txt");
        String dirClasses = props.getProperty("dir_classes");
        while (true){
            if(checkNewClass(dirClasses)) try {
                alg = loadAlgorithm(dirClasses);
            } catch (ClassNotFoundException | MalformedURLException e) {
                e.printStackTrace();
            }

            int[] arr = alg.sort(readFromTxt(dirTxt));

            System.out.println(Arrays.toString(arr));

            try {
                Thread.sleep(Long.parseLong(props.getProperty("sleep_time")));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int[] readFromTxt(String path){
        return null;
    }

    private boolean checkNewClass(String path){
        return false;
    }

    private Algorithm loadAlgorithm(String path) throws ClassNotFoundException, MalformedURLException {
        String newClassName = ""; //TODO

        File file = new File(path + newClassName);

        ClassLoader classLoader = new URLClassLoader(new URL[]{file.toURI().toURL()});
        classLoader.loadClass("test.MyAlgorythm");

        return null;
    }

    public Algorithm getAlg() {
        return alg;
    }

    public void setAlg(Algorithm alg) {
        this.alg = alg;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }
}
