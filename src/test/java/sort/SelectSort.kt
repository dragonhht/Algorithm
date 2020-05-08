package sort

/**
 * 选择排序.
 *
 * @author: Carlos Huang
 * @Date: 5-08
 */
var selectArray = Array(20){(0..100).random()}

fun main() {
    println("初始数组: ${selectArray.contentDeepToString()}")
    for (i in selectArray.indices) {
        var min = i
        for (j in i until selectArray.size) {
            if (selectArray[min] > selectArray[j]) {
                min = j
            }
        }
        if (min != i) {
            val temp = selectArray[i]
            selectArray[i] = selectArray[min]
            selectArray[min] = temp
        }
    }
    println("排序后: ${selectArray.contentDeepToString()}")
}