package lineartable.linktable;

/**
 * 链表节点.
 * User: huang
 * Date: 17-7-8
 */
public class Node<T> {

    /** 保存的数据. */
    private T data;
    /** 下一节点. */
    private Node<T> next;

    /**
     * 创建一个空的链表.
     */
    public Node() {

    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }


    /**
     * 获取 下一节点.
     *
     * @return next 下一节点.
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * 设置 下一节点.
     *
     * @param next 下一节点.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * 获取 保存的数据.
     *
     * @return data 保存的数据.
     */
    public T getData() {
        return this.data;
    }

    /**
     * 设置 保存的数据.
     *
     * @param data 保存的数据.
     */
    public void setData(T data) {
        this.data = data;
    }
}
