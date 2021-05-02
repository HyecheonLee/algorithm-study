package problem

fun main() {
    val testCase = readLine()!!.toInt()
    for (i in 1..testCase) {
        val input = readLine()!!.split(" ").map { it.toInt() }
        val M = input[1]
        val data =
            readLine()!!.split(" ").withIndex()
                .map { (key, value) -> value.toInt() to key }
                .toMutableList()
        var cnt = 0
        var index: Int
        while (true) {
            val max = data.maxBy { pair -> pair.first }!!
            while (true) {
                if (data[0].first == max.first) {
                    cnt++
                    index = data[0].second
                    data.removeAt(0)
                    break
                }
                val temp = data.removeAt(0)
                data.add(temp)
            }
            if (index == M) {
                println(cnt)
                break
            }
        }
    }
}