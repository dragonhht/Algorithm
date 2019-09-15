package exercise;

import org.junit.Test;

import java.util.Random;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-3-25
 */
public class OneTest {

    /**
     * 将int转为二进制字符串.
     */
    @Test
    public void testIntToBinaryString() {
        Random random = new Random();
        int num = random.nextInt(100);
        System.out.println("二进制为： " + Integer.toBinaryString(num));

        StringBuilder sb = new StringBuilder();
        for (int n = num; n > 0; n = n /2) {
            sb.insert(0, n % 2);
        }
        System.out.println("result: " + sb.toString());
    }


    @Test
    public void testBoolean() {
        Random random = new Random();
        int row = 20, col = 20;
        boolean[][] booleans = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int n = random.nextInt(2);
                if (n == 0) {
                    booleans[i][j] = false;
                } else {
                    booleans[i][j] = true;
                }
            }
        }

        printBooleans(booleans);
    }

    /**
     * 打印二维布尔数组，并打印行号和列号
     */
    private void printBooleans(boolean[][] booleans) {
        int row = booleans.length, col = booleans[0].length;
        int colIndex = 0, rowIndex = 0;
        for (int i = 0; i < row; i++) {
            if (i == 0) {
                System.out.printf("%-3s", " ");
                for (int j = 0; j < col; j++) {
                    System.out.printf("%-3d", j + 1);
                }
                System.out.println();
            }
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    System.out.printf("%-3d", i + 1);
                }
                if (booleans[i][j]) {
                    System.out.printf("%-3s", "*");
                } else {
                    System.out.printf("%-3s", " ");
                }
            }
            System.out.println();
        }
    }

    private void print(int[][] arrays) {
        int row = arrays.length, col = arrays[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%3d", arrays[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * M, N 的矩阵进行转置.
     */
    @Test
    public void test_1_1_13() {
        int row = 10, col = 11;
        Random random = new Random();
        int[][] arrays = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arrays[i][j] = random.nextInt(100);
            }
        }

        print(arrays);

        System.out.println("--------------转置-------------------------");
        int[][] result = new int[col][row];
        // 进行转置
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                result[i][j] = arrays[j][i];
            }
        }
        print(result);
    }

    /**
     * 计算log2N的最大整数
     */
    @Test
    public void bigLog2N() {
        Random random = new Random();
        int result = 0;
        int insert = random.nextInt(1000);
        int insertNum = insert;
        for (; insert / 2 > 0; insert = insert / 2) {
            result++;
        }
        System.out.println(insertNum + " 的最大正整数为: " + result);
        System.out.println(Math.log(insertNum) / Math.log(2));
    }
}
