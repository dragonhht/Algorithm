package sort

/**
 * 快速排序.
 *
 * @author: Carlos Huang
 * @Date: 5-10
 */
var quickArray = Array(20){(0..100).random()}

fun quickSort(array: Array<Int>, begin: Int, end: Int) {
    if (begin >= end) return
    val key = array[begin]
    var i = begin
    var j = end
    while (i < j) {
        while (i < j && array[j] > key) {
            j--
        }
        if (i < j) {
            array[i] = array[j]
            i++
        }
        while (i < j && array[i] < key) {
            i++
        }
        if (i < j) {
            array[j] = array[i]
            j--
        }
    }
    array[i] = key
    quickSort(array, begin, i - 1)
    quickSort(array, i + 1, end)
}

fun main() {
    println("初始数组: ${quickArray.contentDeepToString()}")
    quickSort(quickArray, 0, quickArray.size - 1)
    println("排序后: ${quickArray.contentDeepToString()}")
}