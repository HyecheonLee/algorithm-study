package problem._2920

fun main() {
    val inputs = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    println(problem(*inputs))
}

fun problem(vararg inputs: Int): String {
    if (inputs.isSortedAsc()) {
        return "ascending"
    }
    if (inputs.isSortedDesc()) {
        return "descending"
    }
    return "mixed"
}

private fun IntArray.isSorted(p: (Int, Int) -> Boolean): Boolean {
    for ((key, value) in this.withIndex()) {
        if (key + 1 < this.size && !p(value, this[key + 1])) {
            return false
        }
    }
    return true
}

private fun IntArray.isSortedAsc(): Boolean {
    return isSorted { x, y -> x <= y }
}

private fun IntArray.isSortedDesc(): Boolean {
    return isSorted { x, y -> x >= y }
}
