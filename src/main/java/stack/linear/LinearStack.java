package stack.linear;

import node.Node;

/**
 * Java链式栈.
 * User: huang
 * Date: 17-7-10
 */
public class LinearStack<T> {
    /** 栈顶指针. */
    private Node<T> top;
    /** 栈的大小. */
    private int size;

    public LinearStack() {

    }

    /**
     * 保存元素.
     * @param date 要保存的数据
     */
    public void push(T date) {
        Node<T> node = new Node<>();
        node.setData(date);
        node.setNext(top);
        top = node;
        size++;
    }

    /**
     * 获取栈顶元素.
     * @return 栈顶元素
     */
    public T pop() {
        if (top == null) {
            throw new RuntimeException("栈已空");
        } else {
            T date = top.getData();
            top = top.getNext();
            size--;
            return date;
        }
    }

    /**
     * 获取栈的大小.
     * @return 栈中元素的个数
     */
    public int size() {
        return size;
    }
}
