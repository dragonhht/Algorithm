import org.junit.Before;

import java.util.Arrays;
import java.util.Random;

/**
 * 搜索.
 *
 * @author: huang
 * @Date: 18-11-24
 */
public class Search {

    private int[] array;

    @Before
    public void before() {
        array = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(array));
    }



}
