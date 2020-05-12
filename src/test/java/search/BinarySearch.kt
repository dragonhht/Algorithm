package search

/**
 * 二分查找.
 *
 * @author: Carlos Huang
 * @Date: 5-12
 */
val binaryArray = Array<Int>(20){(0..100).random()}

fun initBinary() {
    // 使用快速排序对数组进行排序
    sort.quickSort(binaryArray, 0, binaryArray.size - 1)
    println("数组: ${binaryArray.contentDeepToString()}")
}

fun binarySearch(array: Array<Int>, key: Int) {
    var low = 0
    var height = array.size - 1
    while (low <= height) {
        val mid = low + (height - low) / 2
        if (array[mid] == key) {
            println("已查找到目标 $key, 下标为 $mid")
            return
        }
        if (array[mid] < key) {
            low = mid + 1
        } else {
            height = mid - 1
        }
    }
    println("未查找到目标 $key")
}

fun main() {
    initBinary()
    binarySearch(binaryArray, binaryArray[12])
}