# 数据结构与算法

##  [排序](./test/sort/Sort.java)

-   冒泡排序

```
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
```

-   桶排序

> 存在一堆0～n的数值，则假如有(n + 1)个桶，分别将数放入对应数值的桶中，最后输出桶的数值, 代码如下

```
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
```

-   快速排序

> 以一个数为基准，小于该数的移动至左侧，大于的移动至右侧。然后有对左侧两侧的数值循环进行该操作，直到各分区只有一个数

```
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
```

-   插入排序

> 将数组分为两部分，一部分已经排序好的，一部分为排序的；依次从未排序的部分取出数据并按排序放入已排序的部分；

```
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
```

-   希尔排序

```
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
```

-   简单选择排序

> 每次在待排序的数组中选择最大的或最小的进行排序

```
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
```

## 搜索

-   二分查找

```
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
```
