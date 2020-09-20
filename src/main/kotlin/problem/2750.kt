package problem

fun main() {
    val n = readLine()?.toInt()
    val newResult = mutableListOf<Int>()
    for (i in 0 until n!!) {
        newResult.add(readLine()!!.toInt())
    }
    newResult.sort()
    newResult.forEach { println(it) }
}