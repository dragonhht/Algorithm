package stack.orader;

/**
 * 顺序栈.
 * User: huang
 * Date: 17-7-10
 */
public class OraderStack<T> {
    /** 栈保存的数据. */
    private T[] data;
    /** 栈能保存的数据个数. */
    private int size;
    /** 栈顶指针. */
    private int top = -1;
    /** 栈的默认大小. */
    private static final int DEFAULT_SIZE = 500;

    public OraderStack() {
        this(DEFAULT_SIZE);
    }

    public OraderStack(int size) {
        if (size >= 0) {
            this.size = size;
            data = (T[]) new Object[size];
        } else {
            throw new RuntimeException("栈初始的大小不能小于0");
        }
    }

    /**
     * 获取栈顶元素.
     * @return 栈顶元素
     */
    public T pop() {
        if (top == -1) {
            throw new RuntimeException("栈为空");
        } else {
            return data[top--];
        }
    }

    /**
     * 添加数据到栈中.
     * @param element 添加的数据
     */
    public void push(T element) {
        if (top == size - 1) {
            throw new RuntimeException("栈已满");
        }
        data[++top] = element;
    }

    /**
     * 栈是否为空.
     * @return true为栈为空
     */
    public boolean isEmpty() {
        return top == -1 ? true : false;
    }

    /**
     * 获取栈保存的数据个数.
     * @return 数据的个数
     */
    public int size() {
        return top + 1;
    }

    public int top() {
        return top;
    }
}
