package problem

fun main() {
    println(fibo(System.`in`.bufferedReader().readLine().toInt()))
}

fun fibo(n: Int): Long {
    tailrec fun go(a: Long, b: Long, n: Int): Long = if (n == 0) a else go(b, a + b, n - 1)
    return go(0L, 1L, n)
}