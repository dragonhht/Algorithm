package tree.zip;

import java.util.*;

/**
 * 通过哈夫曼树进行编码.
 *
 * @author: dragonhht
 * @Date: 2019-11-7
 */
public class Zip {

    /**
     * 构造哈夫曼树.
     * @param bytes 需编码的字节
     * @return
     */
    public static Node createHuffmanTree(byte[] bytes) {
        List<Node> nodes = createNodes(bytes);
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node node1 = nodes.get(0);
            Node node2 = nodes.get(1);
            Node newNode = new Node(node1.getSize() + node2.getSize());
            newNode.setLeftNode(node1);
            newNode.setRightNode(node2);
            nodes.remove(node1);
            nodes.remove(node2);
            nodes.add(newNode);
        }
        return nodes.get(0);
    }

    /**
     * 获取编码表.
     * @param treeRoot 哈夫曼树根节点.
     * @return
     */
    public static Map<Byte, String> getCodeMap(Node treeRoot) {
        Map<Byte, String> map = new HashMap<>();
        visit(treeRoot, "", map);
        return map;
    }

    /**
     * 通过编码表获取解码表
     * @param codeMap
     * @return
     */
    public static Map<String, Byte> getDecodeMap(Map<Byte, String> codeMap) {
        Map<String, Byte> map = new HashMap<>();
        codeMap.forEach((key, value) -> {
            map.put(value, key);
        });
        return map;
    }

    /**
     * 通过前序遍历获取编码
     * @param node
     * @param code
     * @param map
     */
    private static void visit(Node node, String code, Map<Byte, String> map) {
        if (node.getCode() != null) {
            map.put(node.getCode(), code);
        }
        if (node.getLeftNode() != null) {
            code += "0";
            visit(node.getLeftNode(), code, map);
        }
        if (node.getRightNode() != null) {
            // 去除左节点
            code = code.substring(0, code.length() - 1);
            code += "1";
            visit(node.getRightNode(), code, map);
        }

    }

    /**
     * 构建节点.
     * @param bytes
     * @return
     */
    public static List<Node> createNodes(byte[] bytes) {
        Map<Byte, Integer> map = new HashMap<>();
        for (byte bt : bytes) {
            Integer size = map.get(bt);
            if (size == null) {
                map.put(bt, 1);
                continue;
            }
            map.put(bt, ++size);
        }
        List<Node> nodes = new LinkedList<>();
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            nodes.add(node);
        }
        return nodes;
    }

    /**
     * 编码(压缩)
     * @param bytes
     * @return
     */
    public static ZipMessage zip(byte[] bytes) {
        ZipMessage message = new ZipMessage();
        Node root = createHuffmanTree(bytes);
        Map<Byte, String> codeMap = getCodeMap(root);
        StringBuilder sb = new StringBuilder();
        for (byte bt : bytes) {
            sb.append(codeMap.get(bt));
        }
        String str = sb.toString();
        int len, index = 0;
        if (str.length() % 8 == 0) {
            len = str.length() / 8;
        } else {
            len = str.length() / 8 + 1;
        }
        byte[] newBytes = new byte[len];
        // 每8位为一个byte
        for (int i = 0; i < str.length(); i += 8) {
            String byteStr;
            if (i + 8 > str.length()) {
                byteStr = str.substring(i);
            } else {
                byteStr = str.substring(i, i + 8);
            }
            // 将8位二进制字符串转成byte
            newBytes[index++] = (byte) Integer.parseInt(byteStr, 2);
            if (index >= len) {
                message.setLastLen(byteStr.length());
            }
        }
        message.setBytes(newBytes);
        message.setCodeMap(codeMap);
        return message;
    }

    /**
     * byte转8位二进制字符串.
     * @param bt
     * @return
     */
    private static String byteToString(byte bt, int len) {
        int n = bt;
        n |= 256;
        String str = Integer.toBinaryString(n);
        if (len == 8) {
            return str.substring(str.length() - 8);
        }
        return str.substring(str.length() - len);
    }

    /**
     * 解码(解压)
     * @param bytes
     * @return
     */
    public static byte[] unZip(byte[] bytes, Map<Byte, String> codeMap, int lastLen) {
        Map<String, Byte> decodeMap = getDecodeMap(codeMap);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if (i == bytes.length - 1) {
                sb.append(byteToString(bytes[i], lastLen));
                continue;
            }
            sb.append(byteToString(bytes[i], 8));
        }
        List<Byte> byteList = new ArrayList<>();
        String str = sb.toString();
        int index = 0;
        while (index < str.length()) {
            int count = 1;
            boolean flag = true;
            while (flag) {
                String s = str.substring(index, index + count);
                Byte bt = decodeMap.get(s);
                if (bt != null) {
                    byteList.add(bt);
                    flag = false;
                } else {
                    count++;
                }
            }
            index += count;
        }
        byte[] result = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            result[i] = byteList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "Good body, you are good student, hi hi hi, one two three, *(H}]]}";
        Node root = createHuffmanTree(str.getBytes());
        ZipMessage zipMessage = zip(str.getBytes());
        byte[] result = unZip(zipMessage.getBytes(), zipMessage.getCodeMap(), zipMessage.getLastLen());
        System.out.println(new String(result));
    }

}
