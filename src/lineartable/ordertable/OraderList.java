package lineartable.ordertable;

import java.util.Arrays;

/**
 * 顺序表的结构.
 * User: huang
 * Date: 17-7-8
 */
public class OraderList<T> {

    /** 数组默认长度. */
    private static final int DEFAULT_LEN = 10;
    /** 存储的数组. */
    private Object[] elements;
    /** 线性表的长度. */
    private int currentLen;
    /** 当前存储的元素个数. */
    private int saveSize = 0;

    /**
     * 创建一个空的顺序表.
     */
    public OraderList() {
        currentLen = DEFAULT_LEN;
        elements = new Object[currentLen];
    }

    /**
     * 创建有一个元素的顺序表.
     * @param element 保存的元素
     */
    public OraderList(T element) {
        this();
        elements[0] = element;
        saveSize++;
    }

    /**
     * 获取顺序表存储的元素个数.
     * @return 存储的个数
     */
    public int getSize() {
        return saveSize;
    }

    /**
     * 获取指定位置的元素.
     * @param index 元素的索引
     * @return 指定位置的元素
     */
    public T getElement(int index) {
        if (index < 0 || index >= saveSize) {
            throw new IndexOutOfBoundsException("查找的索引越界");
        }
        return (T)elements[index];
    }

    /**
     * 查找指定元素的索引, 若有多个, 则返回顺序表中的第一个该元素.
     * @param element 要查找的元素
     * @return 元素的索引, 若为-1则没有该元素
     */
    public int getElementIndex(T element) {

        for (int i = 0; i < saveSize; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 在指定位置上插入元素.
     * @param index 要插入位置的索引
     * @param element 要插入的元素
     */
    public void addElement(int index, T element) {
        boolean ok = false;
        if (index < 0 || index >= currentLen) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        ensureCapacity(saveSize++);
        for (int i = saveSize - 1; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
    }

    /**
     * 在顺序表的最后添加元素.
     * @param element 要添加的元素
     */
    public void addElement(T element) {
        ensureCapacity(saveSize++);
        elements[saveSize - 1] = element;
    }


    /**
     * 改变顺序表的大小.
     * @param size 当前要使用的长度
     */
    private void ensureCapacity(int size) {
        if (size < currentLen) {
            return;
        }
        Object[] old = elements;
        elements = new Object[2 * size];
        for (int i = 0; i < saveSize - 1; i++) {
            elements[i] = old[i];
        }
        currentLen = 2 * size;
    }

    /**
     * 删除指定的元素. 若存在多个则删除第一个.
     * @param element 要删除的元素
     */
    public void delElement(T element) {
        for (int i = 0; i < saveSize; i++) {
            if (elements[i].equals(element)) {
                for (int j = i; j < saveSize - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                saveSize--;
                elements[saveSize] = null;
                break;
            }
        }
    }

    /**
     * 删除指定索引位置上的元素.
     * @param index 指定的元素
     */
    public void del(int index) {
        if (index < 0 || index >= saveSize) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        for (int i = index; i < saveSize - 1; i++) {
            elements[i] = elements[i + 1];
        }
        saveSize--;
        elements[saveSize] = null;
    }

    /**
     * 删除最后一个元素.
     */
    public void del() {
        saveSize--;
        elements[saveSize] = null;

    }

    /**
     * 修改指定索引位上的元素.
     * @param index 要修改元素的索引
     * @param element 修改后的元素
     */
    public void setElement(int index, T element) {
        if (index < 0 || index >= saveSize) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        elements[index] = element;
    }

    /**
     * 判断顺序表是否为空.
     * @return true为空
     */
    public boolean isEmpty() {
        boolean ok = false;
        if (saveSize == 0) {
            ok = true;
        }
        return ok;
    }

    /**
     * 清空顺序表.
     */
    public void clear() {
        Arrays.fill(elements, null);
    }

}
