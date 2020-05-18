package divide.onquer

/**
 * 全排序问题.
 * (计算出数组所有的排序可能)
 * @author: Carlos Huang
 * @Date: 5-18
 */

var counter = 0

val fullSortArray = IntArray(4) {it}
val fullSortList = fullSortArray.toMutableList()
val resultList = mutableListOf<Int>()

fun fullSort(step: Int, list: MutableList<Int>) {
    if (step == fullSortList.size) {
        println("打印结果: $resultList")
        // 计算累计结果数
        counter++
        return
    }
    for (it in list) {
        // 尝试值
        resultList.add(it)
        // 递归后面的步骤
        val tempList = list.toMutableList()
        tempList.remove(it)
        fullSort(step + 1, tempList)
        // 还原
        resultList.removeAt(resultList.size - 1)
    }
}

fun main() {
    fullSort(0, fullSortList)
    println("=======================================")
    println("共计结果 $counter 种")
}