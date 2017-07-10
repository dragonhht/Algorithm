package lineartable.oradertable;

import lineartable.linktable.LinkList;
import node.Node;
import org.junit.Test;

/**
 * 链表测试类.
 * User: huang
 * Date: 17-7-8
 */
public class LinkListTest {

    @Test
    public void linkTest() {
        LinkList<String> linkList = new LinkList<>();
        for (int i = 0; i < 1000; i++) {
            Node<String> node = new Node<>();
            node.setData("date: " + i);
            linkList.add(node);
        }
        linkList.del(8);
        Node<String> n = linkList.getHead();
        while (n.getNext() != null) {
            n = n.getNext();
            System.out.println(n.getData());
        }
    }
}
