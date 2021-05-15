package sort.QuickSort

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/05/15
 */
fun quickSort(data: List<Int>): List<Int> {
    if (data.isEmpty()) return emptyList()
    if (data.size == 1) return data
    val pivot = data[0]
    val groupBy = data.subList(1, data.size).groupBy { i: Int -> i <= pivot }
    return quickSort(groupBy[true].orEmpty()) + pivot + quickSort(groupBy[false].orEmpty())
}

suspend fun quickSort2(data: List<Int>): List<Int> {
    if (data.isEmpty()) return emptyList<Int>()
    if (data.size == 1) return data
    val pivot = data[0]
    val groupBy = data.subList(1, data.size).groupBy { i: Int -> i <= pivot }
    val left = CoroutineScope(Dispatchers.Default).async {
        quickSort2(groupBy[true].orEmpty())
    }
    val right = CoroutineScope(Dispatchers.Default).async {
        quickSort2(groupBy[false].orEmpty())
    }
    return left.await() + pivot + right.await()
}

fun main() = runBlocking {
    val data = List(100) { Random.nextInt(0, 1000000) }

    val elapsed2: Long = measureTimeMillis {
        val quickSort = quickSort2(data)
    }
    val elapsed: Long = measureTimeMillis {
        val quickSort = quickSort(data)
    }
    println(elapsed2)
    println(elapsed)
}