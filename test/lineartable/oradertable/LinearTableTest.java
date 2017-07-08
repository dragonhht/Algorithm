package lineartable.oradertable;

import lineartable.ordertable.OraderList;
import org.junit.Test;

/**
 * 线性表测试.
 * User: huang
 * Date: 17-7-8
 */
public class LinearTableTest {

    @Test
    public void testOrader() {
        OraderList<String> list = new OraderList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.addElement("你好_" + i);
        }
        long end = System.currentTimeMillis();
        System.out.println("添加元素运行时间: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            list.del();
        }
        end = System.currentTimeMillis();
        System.out.println("格式:" + list.getSize());
        System.out.println("删除运行的时间: " + (end - start));

        start = System.currentTimeMillis();
        for (int i =0; i < 3000; i++) {
            list.getElement(i);
        }
        end = System.currentTimeMillis();
        System.out.println("获取运行时间: " + (end - start));

    }

}
