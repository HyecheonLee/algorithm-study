package problem

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val n = readLine()!!.toInt()
    val array = IntArray(10001)
    repeat(n) {
        val index = br.readLine().toInt()
        array[index]++
    }
    for (i in array.indices) {
        bw.write("$i\n".repeat(array[i]))
    }
    bw.flush()
    br.close()
    bw.close()
}