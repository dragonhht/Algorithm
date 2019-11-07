package tree.zip;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * 编码对应.
 *
 * @author: dragonhht
 * @Date: 2019-11-7
 */
@Data
@NoArgsConstructor
public class Node implements Comparable<Node> {
    /** 对应的字节. */
    private Byte code;
    /** 该对应字节出现的数量. */
    private int size;

    /** 左节点. */
    private Node leftNode;
    /** 右节点. */
    private Node rightNode;

    public Node(int size) {
        this.size = size;
    }

    public Node(Byte code, int size) {
        this.code = code;
        this.size = size;
    }

    @Override
    public int compareTo(@NotNull Node o) {
        return this.size - o.size;
    }
}
