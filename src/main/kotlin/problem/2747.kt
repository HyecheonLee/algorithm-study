package problem

fun main() {
    val br = System.`in`.bufferedReader()
    println(fibo(br.readLine().toInt()))
}

fun fibo(n: Int): Long {
    fun go(a: Long, b: Long, n: Int): Long {
        return if (n == 0) {
            a
        } else {
            go(b, a + b, n - 1)
        }
    }
    return when (n) {
        0 -> {
            0
        }
        1 -> {
            1
        }
        else -> {
            go(0L, 1L, n)
        }
    }
}