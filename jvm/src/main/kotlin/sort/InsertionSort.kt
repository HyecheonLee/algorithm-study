package sort

import kotlin.random.Random

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/05/08
 */
class InsertionSort {
    companion object {
        fun sort(data: List<Int>): MutableList<Int> {
            fun findInsertIndex(data: List<Int>, index: Int): Int {
                var insertIndex = index
                for (i in index - 1 downTo 0) {
                    if (data[i] > data[index]) {
                        insertIndex = i
                    }
                }
                return insertIndex
            }

            val result = data.toMutableList()

            for (index in 1 until result.size) {
                val insertIndex = findInsertIndex(result, index)
                val temp = result[index]
                for (j in index downTo insertIndex + 1) {
                    result[j] = result[j - 1]
                }
                result[insertIndex] = temp
            }
            return result
        }
    }
}

fun main() {
    val data = List(10) { Random.nextInt(0, 100) }
    val sort = InsertionSort.sort(data)
    println(data)
    println(sort)
}