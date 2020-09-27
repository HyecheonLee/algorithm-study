package problem

fun main() {
    var N = 0
    var result: MutableList<String> = mutableListOf()
    fun calc(index: Int, text: String) {
        if (N < index) {
            val replace = text.replace(" ", "")
            val toRegex = "([+-]?\\d+)".toRegex()
            val findAll = toRegex.findAll(replace)
            val sum = findAll.map { matchResult ->
                matchResult.value.toInt()
            }.sum()
            if (sum == 0) {
                result.add(text)
            }
            return
        }
        calc(index + 1, "${text}+$index")
        calc(index + 1, "${text}-$index")
        calc(index + 1, "$text $index")
    }

    val br = System.`in`.bufferedReader()
    val input = br.readLine().toInt()
    for (i in 1..input) {
        N = br.readLine().toInt()
        result = mutableListOf()
        calc(2, "1")
        result.sort()
        result.forEach { println(it) }
        println()
    }
}
