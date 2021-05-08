package sort

import kotlin.random.Random

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/05/08
 */
class SelectSort {
    companion object {
        fun sort(data: List<Int>): MutableList<Int> {
            fun findMinDataIndex(data: List<Int>, index: Int): Int {
                var min = data[index]
                var minIndex = index
                for (i in index + 1 until data.size) {
                    if (min > data[i]) {
                        minIndex = i
                        min = data[i]
                    }
                }
                return minIndex
            }

            val result = data.toMutableList()
            for (index in 0 until result.size) {
                val minIndex = findMinDataIndex(result, index)
                val temp = result[index]
                result[index] = result[minIndex]
                result[minIndex] = temp
            }
            return result
        }
    }
}

fun main() {
    val data = List(10) { Random.nextInt(0, 100) }
    val sort = SelectSort.sort(data)
    println(data)
    println(sort)
}