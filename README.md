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


