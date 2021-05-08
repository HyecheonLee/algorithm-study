package sort

import java.util.ArrayList
import kotlin.random.Random

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/05/08
 */
class BubbleSort {
    companion object {
        fun sort(data: List<Int>): List<Int> {
            val result = data.toMutableList()
            for (index in 0 until result.size - 2) {
                for (index2 in 0 until (result.size - 1 - index)) {
                    if (result[index2] > result[index2 + 1]) {
                        val temp = result[index2]
                        result[index2] = result[index2 + 1]
                        result[index2 + 1] = temp
                    }
                }
            }
            return result
        }
    }
}

fun main() {

    val data = List(10) { Random.nextInt(0,100) }
    val sort = BubbleSort.sort(data)
    println(data)
    println(sort)
}