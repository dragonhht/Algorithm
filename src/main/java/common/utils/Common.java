package common.utils;

import java.util.Arrays;

/**
 * 基本工具类.
 *
 * @author: huang
 * @Date: 2019-9-15
 */
public final class Common {

    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static void printf(String str) {
        System.out.printf(str);
    }

    public static void printArray(Object[] objects) {
        Arrays.toString(objects);
    }

}
