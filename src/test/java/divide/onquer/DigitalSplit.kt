package divide.onquer

/**
 * 数字拆分算法.
 * 求出相加结果为n的所有可能
 * 如，n = 3, 则 可能为： 1+1+1、1+2
 * @author: Carlos Huang
 * @Date: 5-19
 */
val result = (1..5).random()

val array = IntArray(result) {it + 1}
val digitalSplitResultList = mutableListOf<Int>()

fun digitalSplit(rest: Int) {
    if (rest == 0) {
        println(digitalSplitResultList)
        return
    }
    if (rest < 0) return
    for (n in array) {
        // 尝试值
        digitalSplitResultList.add(n)
        // 递归尝试后面的值
        digitalSplit(rest - n)
        // 还原
        digitalSplitResultList.removeAt(digitalSplitResultList.size - 1)
    }
}

fun main() {
    println("需要求出的目标值: $result")
    println("所有结果：")
    digitalSplit(result)
}