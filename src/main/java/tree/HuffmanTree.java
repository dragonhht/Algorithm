package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 哈夫曼树.
 *
 * @author: dragonhht
 * @Date: 2019-11-6
 */
public class HuffmanTree {

    /**
     * 构造哈夫曼树.
     * @param arrays
     * @return
     */
    public static Node buildHuffmanTree(int[] arrays) {
        List<Node> nodes = new LinkedList<>();
        for (int n : arrays) {
            nodes.add(new Node(n));
        }
        while (nodes.size() > 1) {
            // 获取两个最小的值
            int m1, m2 ;
            int index1, index2;
            m1 = nodes.get(0).getValue();
            m2 = nodes.get(1).getValue();
            index1  = 0;
            index2 = 1;
            // 取出最小权的两颗树
            for (int i = 2; i < nodes.size(); i++) {
                if (nodes.get(i).getValue() < m1) {
                    if (m1 < m2) {
                        m2 = m1;
                        index2 = index1;
                    }
                    m1 = nodes.get(i).getValue();
                    index1 = i;
                    continue;
                }
                if (nodes.get(i).getValue() < m2) {
                    m2 = nodes.get(i).getValue();
                    index2 = i;
                }
            }

            // 两个最小权构造成一颗树
            Node newNode = new Node(m1 + m2);
            newNode.setLeftNode(nodes.get(index1));
            newNode.setRightNode(nodes.get(index2));
            nodes.add(newNode);

            if (index1 > index2) {
                nodes.remove(index1);
                nodes.remove(index2);
                continue;
            }
            nodes.remove(index1);
            nodes.remove(index2 - 1);
        }
        return nodes.get(0);
    }

    public static void main(String[] args) {
        Random random = new Random();
        int size = 10;
        int[] arrays = new int[size];
        for (int i = 0; i < size; i++) {
            arrays[i] = random.nextInt(30);
        }
        System.out.println(Arrays.toString(arrays));
        System.out.println(buildHuffmanTree(arrays));
    }

}
