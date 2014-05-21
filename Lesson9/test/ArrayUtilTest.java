import org.junit.Assert;
import org.junit.Test;
import unitTest.ArrayUtil;

/**
 * Created by tish on 18.05.2014.
 */
public class ArrayUtilTest {

    @Test
    public void testFindMax(){
        int[] inTest = {2, 7, 9, 5, 3};
        int inTestMax = 9;

        int result = ArrayUtil.findMax(inTest);

        Assert.assertEquals(inTestMax, result);


    }

    @Test
    public void testFindMin(){
        int[] inTest = {2, 7, 9, 5, 3};
        int inTestMin = 2;

        int result = ArrayUtil.findMin(inTest);

        Assert.assertEquals(inTestMin, result);

    }

}
