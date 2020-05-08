package sort

/**
 * 插入排序.
 *
 * @author: Carlos Huang
 * @Date: 5-08
 */
var insertArray = Array(20){(0..100).random()}

fun main() {
    println("初始数组: ${insertArray.contentDeepToString()}")
    for (i in 1 until insertArray.size) {
        val key = insertArray[i]
        var j = i
        while (j > 0 && insertArray[j - 1] > key) {
            insertArray[j] = insertArray[j - 1]
            j--
        }
        insertArray[j] = key
    }
    println("排序后: ${insertArray.contentDeepToString()}")
}