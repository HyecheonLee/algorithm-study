package problem


data class Comma(val x: Int, val y: Int)

fun main() {
    val n = readLine()!!.toInt()
    val members = mutableListOf<Comma>()
    for (i in 1..n) {
        val input = readLine()!!.split(" ")
        members.add(Comma(x = input[0].toInt(), y = input[1].toInt()))
    }
    members.sortWith(Comparator { o1, o2 ->
        when {
            o1.x > o2.x -> 1
            o1.x < o2.x -> -1
            o1.x == o2.x && o1.y > o2.y -> 1
            o1.x == o2.x && o1.y < o2.y -> -1
            else -> 0
        }
    })
    println(members.joinToString("\n") { "${it.x} ${it.y}" })
}
