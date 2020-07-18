package problem._1920

fun main() {
    val n = readLine()!!.toInt()
    val map =
        readLine()!!
            .split(" ")
            .fold(mutableMapOf<String, Int>()) { acc, s ->
                acc[s] = 1
                acc
            }
    val m = readLine()!!.toInt()
    readLine()!!.split(" ").forEach {
        println(map.getOrDefault(it, 0))
    }
}
