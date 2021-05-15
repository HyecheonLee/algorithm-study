package sort.MergeSort

import kotlin.random.Random

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/05/15
 */
fun mergeSort(data: List<Int>): List<Int> {
    if (data.count() <= 1) return data
    fun merge(left: List<Int>, right: List<Int>): List<Int> {
        var lp = 0
        var rp = 0
        val resultData = mutableListOf<Int>()
        while (lp < left.count() && rp < right.count()) {
            if (left[lp] < right[rp]) {
                resultData.add(left[lp++])
            } else {
                resultData.add(right[rp++])
            }
        }
        while (lp < left.count()) {
            resultData.add(left[lp++])
        }
        while (rp < right.count()) {
            resultData.add(right[rp++])
        }
        return resultData
    }

    val left = data.subList(0, data.count() / 2)
    val right = data.subList(data.count() / 2, data.count())
    return merge(mergeSort(left), mergeSort(right))
}

fun main() {
    val data = List(10) { Random.nextInt(0, 100) }
    println(data)
    val mergeSort = mergeSort(data)
    println(mergeSort)
}