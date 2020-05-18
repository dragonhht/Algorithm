package divide.onquer

import org.junit.Test

/**
 * 八皇后问题.
 * ------> y
 *  0, 0, 0, 0, 0, 0, 0, 0
 *  0, 0, 0, 0, 0, 0, 0, 0
 *  0, 0, 0, 0, 0, 0, 0, 0
 *  0, 0, 0, 0, 0, 0, 0, 0
 *  0, 0, 0, 0, 0, 0, 0, 0
 *  0, 0, 0, 0, 0, 0, 0, 0
 *  0, 0, 0, 0, 0, 0, 0, 0
 *  0, 0, 0, 0, 0, 0, 0, 0
 *
 * @author: Carlos Huang
 * @Date: 5-17
 */
class EightQueens {

    private val eightQueensArray = Array(8) {IntArray(8)}

    /**
     * 判断当前位置是否可放置
     */
    fun canPlace(x: Int, y: Int): Boolean {
        // 判断y轴
        for (i in 0 until y) {
            if (eightQueensArray[x][i] == 1) return false
        }
        // 判断x轴
        for (i in 0 until x) {
            if (eightQueensArray[i][y] == 1) return false
        }
        // 判断 / 方向, 该方向的横、纵坐标之和等于 x+y
        for (i in 0 until x) {
            if (x + y - i <= 7 && eightQueensArray[i][x + y - i] == 1) return false
        }
        // 判断 \ 反向
        for (i in 1..x) {
            if (x - i >= 0 && y - i >= 0 && eightQueensArray[x - i][y - i] == 1) return false
        }
        for (i in 1..(7 - x)) {
            if (x + i <= 7 && y + i <= 7 && eightQueensArray[x + i][y + i] == 1) return false
        }
        return true
    }

    /**
     * 格式化打印
     */
    fun printQueens() {
        for (item in eightQueensArray) {
            println(item.contentToString())
        }
    }

    /**
     * 反治法放置皇后
     */
    fun put_queen(index: Int) {
        if (index == 8) {
            println("------------------------ 打印结果 start ------------------------")
            printQueens()
            println("------------------------ 打印结果 end --------------------------")
            return
        }
        for (i in 0..7) {
            // 如果可以放置
            if (canPlace(index, i)) {
                // 尝试设置
                eightQueensArray[index][i] = 1
                // 递归计算后面的步骤
                put_queen(index + 1)
                // 还原
                eightQueensArray[index][i] = 0
            }
        }
    }

    @Test
    fun eightQueens() {
        put_queen(0)
    }

}