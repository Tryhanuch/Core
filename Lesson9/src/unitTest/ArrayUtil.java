package unitTest;

/**
 * Created by tish on 18.05.2014.
 */
public class ArrayUtil {

    public static int findMax(int[] arr){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max]){
                max = i;
            }
        }
        return arr[max];
    }

    public static int findMin(int[] arr){
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[res]) res = i;
        }
        return arr[res];
    }
}
