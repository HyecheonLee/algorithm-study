package problem

import kotlin.math.pow

fun main() {
    solve()
}

private fun solve() {
    val br = System.`in`.bufferedReader()
    val input = br.readLine().split(" ")
    var n: Int = input[0].toInt()
    val r: Int = input[1].toInt()
    val c: Int = input[2].toInt()
    var ans = 0
    var y = 2.0.pow(n.toDouble()).toInt() / 2
    var x = y
    while (n-- > 0) {
        val temp = 2.0.pow(n.toDouble()).toInt() / 2
        val skip = 4.0.pow(n.toDouble()).toInt()
        if (r < y && c < x) {
            // 1
            x -= temp
            y -= temp
        } else if (r < y && x <= c) {
            // 2
            x += temp
            y -= temp
            ans += skip
        } else if (y <= r && c < x) {
            // 3
            x -= temp
            y += temp
            ans += skip * 2
        } else {
            // 4
            x += temp
            y += temp
            ans += skip * 3
        }
    }
    println(ans)
}
