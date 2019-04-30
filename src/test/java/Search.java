import org.junit.Before;
import org.junit.Test;

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
    private int key;

    @Before
    public void before() {
        array = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            array[i] = random.nextInt(100);
        }
        // 进行排序
        quickSort(array, 0, array.length - 1);
        int index = random.nextInt(20);
        key = array[index];
        System.out.println(Arrays.toString(array));
        System.out.println("key is: " + key + " and index is: " + index);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int flag = arr[start];
            int i = start, j = end;
            while (i < j) {
                while (i < j && arr[j] > flag) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] < flag) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = flag;
            quickSort(arr, start, i - 1);
            quickSort(arr, i + 1, end);
        }
    }

    /**
     * 二分查找法.
     */
    @Test
    public void testBinarySearch() {
        int low = 0, height = array.length - 1;
        int mid;
        while (low <= height) {
            mid = low + (height - low) / 2;
            if (array[mid] == key) {
                System.out.println(mid);
                return;
            }
            if (array[mid] > key) {
                height = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("未查询到目标: " + key);
    }

}
