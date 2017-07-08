package lineartable.linktable;

/**
 * 带头节点的单向链表.
 * User: huang
 * Date: 17-7-8
 */
public class LinkList<T> {

    /** 头结点. */
    private Node<T> head;
    /** 链表的长度. */
    private int size = 0;

    public LinkList() {
        head = new Node<>();
        size++;
    }

    /**
     * 将数据插入到链表的尾部.
     * @param node 要保存的节点
     */
    public void add(Node<T> node) {
        Node<T> n = head;
        while (n.getNext() != null) {
            n = n.getNext();
        }
        n.setNext(node);
        size++;
    }

    /**
     * 头插法.
     * @param node 要保存的节点
     */
    public void addInHead(Node<T> node) {
        Node<T> n = head.getNext();
        head.setNext(node);
        node.setNext(n);
        size++;
    }

    /**
     * 将节点插入到指定索引处.
     * @param index 要插入的索引
     * @param node 要保存的节点
     */
    public void add(int index, Node<T> node) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        int i = 0;
        Node<T> n = head;
        while (i < index) {
            n = n.getNext();
            i++;
        }
        n.setNext(node);
        size++;
    }

    /**
     * 获取指定索引处的节点.
     * @param index 要获取的节点索引
     * @return 节点
     */
    public Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        int i = 0;
        Node<T> n = head;
        while (i < index) {
            n = n.getNext();
            i++;
        }
        return n;
    }


    /**
     * 获取链表长度.
     * @return 链表长度
     */
    public int getLen () {
        int i = 0;
        Node<T> node = head;
        while (node.getNext() != null) {
            i++;
            node = node.getNext();
        }
        return i;
    }

    public int size() {
        return this.size;
    }

    /**
     * 获取 头结点.
     *
     * @return head 头结点.
     */
    public Node<T> getHead() {
        return this.head;
    }

    /**
     * 设置 头结点.
     *
     * @param head 头结点.
     */
    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * 清空链表.
     */
    public void clear() {
        head.setNext(null);
        size = 0;
    }

    /**
     * 删除链表中指定的数据. 若有多个则删除第一个
     * @param data 要删除的数据
     */
    public void del(T data) {
        Node<T> node = head;
        while (node.getNext() != null) {
            if (node.getNext().getData().equals(data)) {
                Node<T> n = node.getNext();
                node.setNext(n.getNext());
                size--;
                break;
            }
        }
    }

    /**
     * 删除链表中的指定索引位的数据.
     * @param index 索引
     */
    public void del(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        int i = 0;
        Node<T> node = head;
        while (i < index - 1) {
            node = node.getNext();
        }
        if (node.getNext() != null) {
            node.setNext(node.getNext().getNext());
        }
        size--;
    }
}
