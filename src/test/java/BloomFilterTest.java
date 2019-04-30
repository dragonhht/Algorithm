import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * 实现一个简单的布隆过滤器.
 *
 * @author: huang
 * @Date: 2019-4-30
 */
public class BloomFilterTest {

    public List<String> urls = new ArrayList<>();
    private static final int INDEX_SIZE = 10, COUNT_SIZE = 10000;
    // 初始化布隆过滤器
    private BitSet bitSet = new BitSet(COUNT_SIZE);

    @Before
    public void init() {
        urls.add("gitee.com");
        urls.add("www.oschina.net");
        urls.add("blog.csdn.net");
        urls.add("www.google.com");
        urls.add("www.baidu.com");
    }

    private int[] getIndex(String url) {
        // 记录10个位置
        int[] indexs = new int[INDEX_SIZE];
        int h = Math.abs(url.hashCode());
        for (int i = 0; i < INDEX_SIZE; i++) {
            indexs[i] = h % COUNT_SIZE;
            h = hash(h);
        }
        return indexs;
    }

    // hash函数
    private int hash(int h) {
        return Math.abs(h^(h >>> 16));
    }

    /**
     * 像BloomFilter中添加值.
     * @param url
     */
    private void add(String url) {
        int[] indexs = getIndex(url);
        for (int index : indexs) {
            bitSet.set(index, true);
        }
    }

    /**
     * 判断是否存在指定的值.
     * @param url
     * @return
     */
    private boolean contains(String url) {
        int[] indexs = getIndex(url);
        for (int index : indexs) {
            if (!bitSet.get(index)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testBloomFilter() {
        // 像bloomFilter中添加值
        for (String url : urls) {
            add(url);
        }
        // 校验是否存在
        System.out.println(contains("www.baidu.com"));
    }

}
