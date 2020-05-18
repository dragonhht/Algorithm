package recursion

import org.junit.Test

/**
 * 递归.
 *
 * @author: Carlos Huang
 * @Date: 5-16
 */
class recursion {

    /**
     * 走楼梯问题
     */
    @Test
    fun stairProblem() {
        val size = 10
        println("到第 $size 阶共有 ${stair(size)} 中方法")
    }

    fun stair(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2
        return stair(n - 1) + stair(n - 2)
    }

}