package problem

val result = mutableListOf<String>()
fun main() {
    val N = readLine()!!.toInt()
    val data = mutableListOf<Int>()

    for (i in 0 until N) {
        data.add(readLine()!!.toInt())
    }
    val stackData = mutableListOf<Int>()
    for (i in 1..100001) {
        searchForStack(data, stackData)
        if (data.isEmpty()) {
            break
        }
        stackData.add(i)
        result.add("+")
    }
    if (data.isNotEmpty()) {
        println("NO")
    } else {
        result.forEach { println(it) }
    }
}

fun searchForStack(data: MutableList<Int>, stackData: MutableList<Int>) {
    if (stackData.size > 0 && stackData[stackData.count() - 1] == data[0]) {
        result.add("-")
        stackData.removeAt(stackData.size - 1)
        data.removeAt(0)
        searchForStack(data, stackData)
    }
}