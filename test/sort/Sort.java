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

    /**
     * 快速排序.
     */
    @Test
    public void testQuickSort() {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int key = arr[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && arr[j] > key) {
                    j--;
                }
                if(i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] < key) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = key;
            quickSort(arr, begin, i-1);
            quickSort(arr, i + 1, end);
        }
    }

    /**
     * 插入排序.
     */
    @Test
    public void testInsertSort() {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            for (; j > 0 && array[j - 1] > temp; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

    /**
     * 希尔排序.
     */
    @Test
    public void testShellSort() {
        for (int k = array.length / 2; k > 0; k /= 2) {
            for (int i = k; i < array.length; i++) {
                for (int j = i; j >= k; j -= k) {
                    if (array[j - k] > array[j]) {
                        int temp = array[j - k];
                        array[j - k] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }

    /**
     * 简单选择排序.
     */
    @Test
    public void testSelectSort() {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

}
