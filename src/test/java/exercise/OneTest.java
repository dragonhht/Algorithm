package exercise;

import org.junit.Test;

import java.util.Random;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-3-25
 */
public class OneTest {

    /**
     * 将int转为二进制字符串.
     */
    @Test
    public void testIntToBinaryString() {
        Random random = new Random();
        int num = random.nextInt(100);
        System.out.println("二进制为： " + Integer.toBinaryString(num));

        StringBuilder sb = new StringBuilder();
        for (int n = num; n > 0; n = n /2) {
            sb.insert(0, n % 2);
        }
        System.out.println("result: " + sb.toString());
    }



}
