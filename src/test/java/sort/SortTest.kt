package sort

import org.junit.Test
import java.util.*
import kotlin.math.min

/**
 * 算法第二章，归并排序.
 *
 * @author: dragonhht
 * @Date: 2019-11-3
 */
class SortTest {

    lateinit var aux: Array<String?>

    private fun less(str1: String, str2: String): Boolean {
        return str1 < str2
    }

    /**
     * 自顶向下.
     */
    @Test
    fun test_2_2_1() {
        val arrays = arrayOf("A", "E", "Q", "S", "U", "Y", "E", "I", "N", "O", "S", "T")
        val start = System.currentTimeMillis()
        aux = arrayOfNulls<String>(arrays.size)
        sort_2_2_1(arrays, 0, arrays.size - 1)
        println("排序用时: ${System.currentTimeMillis() - start} ms")
        println(Arrays.toString(arrays))
    }

    private fun sort_2_2_1(array: Array<String>, lo: Int, hi: Int) {
        if (lo >= hi) return
        var mid = lo + (hi - lo) / 2
        sort_2_2_1(array, lo, mid)
        sort_2_2_1(array, mid + 1, hi)
        merge(array, lo, mid, hi)
    }

    private fun merge(array: Array<String>, lo: Int, mid: Int, hi: Int) {
        var i = lo
        var j = mid + 1
        for (k in lo..hi) {
            aux[k] = array[k]
        }
        for (k in lo..hi) {
            if (i > mid) {
                array[k] = aux[j++]!!
                continue
            }
            if (j > hi) {
                array[k] = aux[i++]!!
                continue
            }
            if (less(aux[j]!!, aux[i]!!))
                array[k] = aux[j++]!!
            else
                array[k] = aux[i++]!!
        }
    }

    /**
     * 自底向上.
     */
    @Test
    fun test_2_2_2() {
        val arrays = arrayOf("E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N")
        val len = arrays.size
        aux = arrayOfNulls(len)
        var k = 1
        while (k < len) {
            var lo = 0
            while (lo < len - k) {
                merge(arrays, lo, lo + k - 1, min(lo + k + k -1, len - 1))
                lo += k + k
            }
            k += k
        }
        println(Arrays.toString(arrays))
    }

}