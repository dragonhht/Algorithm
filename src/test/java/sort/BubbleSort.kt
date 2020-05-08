package sort

/**
 * 冒泡排序.
 *
 * @author: Carlos Huang
 * @Date: 5-07
 */

var bubbleArray = Array(20) {(0..100).random()}

fun main() {
    println("初始数组：${bubbleArray.contentToString()}")
    for (i in 1..bubbleArray.size step 1) {
        for (j in 0 until bubbleArray.size - i) {
            if (bubbleArray[j] > bubbleArray[j + 1]) {
                val temp = bubbleArray[j]
                bubbleArray[j] = bubbleArray[j + 1]
                bubbleArray[j + 1] = temp
            }
        }
    }
    println("排序后: ${bubbleArray.contentDeepToString()}")
}