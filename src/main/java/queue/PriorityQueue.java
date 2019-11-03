package queue;

import java.util.Arrays;
import java.util.Random;

/**
 * 优先队列, 最大的值优先（使用二叉堆）.
 *
 * @author: dragonhht
 * @Date: 2019-11-3
 */
public class PriorityQueue {
    
    private int[] list;
    private int size;

    public PriorityQueue(int size) {
        // 0索引位置不使用
        this.list = new int[++size];
    }

    public PriorityQueue() {
        this(10);
    }

    /**
     * 比较大小.
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return list[i] < list[j];
    }

    /**
     * 交换
     * @param i
     * @param j
     */
    private void exchange(int i, int j) {
        int t = list[i];
        list[i] = list[j];
        list[j] = t;
    }

    /**
     * 上浮(与父节点比较，大于父节点则上浮).
     * @param index
     */
    private void swim(int index) {
        while (index > 1 && less(index / 2, index)) {
            exchange(index / 2, index);
            index /= 2;
        }
    }

    /**
     * 下沉(与最大的子节点比较，若小于子节点则交换)
     * @param index
     */
    public void sink(int index) {
        while (2 * index <= size) {
            int child = 2 * index;
            if (child + 1 <= size) {
                if (less(child, child + 1)) child++;
            }
            if (!less(index, child)) break;
            exchange(index, child);
            index = child;
        }
    }

    /**
     * 改变顺序表的大小.
     * @param size 当前要使用的长度
     */
    private void ensureCapacity(int size) {
        if (size < list.length - 1) {
            return;
        }
        int[] old = list;
        list = new int[2 * size];
        for (int i = 0; i < old.length; i++) {
            list[i] = old[i];
        }
    }

    /**
     * 插入数据
     * @param val
     */
    public void push(int val) {
        if (size + 1 >= list.length) ensureCapacity(size + 1);
        list[++size] = val;
        swim(size);
    }

    /**
     * 获取并删除最大值
     * @return
     */
    public int pop() {
        if (size < 1) throw new RuntimeException("队列为空");
        int max = list[1];
        exchange(1, size--);
        sink(1);
        return max;
    }

    public int[] getList() {
        if (size > 0) {
            int[] temp = new int[size];
            for (int i = 0; i < size; i++) {
                temp[i] = list[i+1];
            }
            return temp;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Random random = new Random();
        PriorityQueue queue = new PriorityQueue();
        for (int i = 0; i < 20; i++) {
            queue.push(random.nextInt(1000));
        }
        System.out.println(Arrays.toString(queue.getList()));
        for (int i = 0; i < 20; i++) {
            System.out.println(queue.pop());
        }
    }
    
}
