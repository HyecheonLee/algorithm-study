package problem._2798

import kotlin.math.max

var MAX_VALUE = 0
var RESULT = -1
fun main() {
    val inputs = readLine()!!.split(" ").map { it.toInt() }
    val data = readLine()!!.split(" ").map { it.toInt() }
    MAX_VALUE = inputs[1]
    problem(data, 0, 3, 0)
    println(RESULT)
}

fun problem(data: List<Int>, acc: Int, index: Int, startIndex: Int) {
    if (MAX_VALUE < acc) {
        return
    }
    if (index == 0) {
        RESULT = max(RESULT, acc);return
    }
    for (i in startIndex until data.size) {
        problem(data, acc + data[i], index - 1, i + 1)
    }
}