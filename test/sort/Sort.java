package sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 排序.
 *
 * @author: huang
 * @Date: 18-11-15
 */
public class Sort {

    private int[] array;

    @Before
    public void before() {
        array = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            array[i] = random.nextInt(100);
        }
    }

    @After
    public void print() {
        System.out.println(Arrays.toString(array));
    }

    /**
     * 桶排序.
     */
    @Test
    public void testBucketSort() {
        // 创建对应个数的桶
        int[] buckers = new int[100];
        assert array != null;
        // 将数值放入对应的桶中
        for (int i = 0; i < array.length; i++) {
            buckers[array[i]]++;
        }
        // 从桶中取出排序结果
        int index = 0;
        for (int i = 0; i < buckers.length; i++) {
            for (int j = 0; j < buckers[i]; j++) {
                array[index++] = i;
            }
        }
    }

    /**
     * 冒泡排序.
     */
    @Test
    public void testBubbleSort() {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

}
