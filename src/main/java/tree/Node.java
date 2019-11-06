package tree;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 树节点.
 *
 * @author: dragonhht
 * @Date: 2019-11-6
 */
@Data
@ToString
@NoArgsConstructor
public class Node {

    private int value;
    private Node leftNode;
    private Node rightNode;

    public Node(int value) {
        this.value = value;
    }

}
