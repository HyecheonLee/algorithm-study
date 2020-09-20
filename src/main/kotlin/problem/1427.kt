package problem

fun main() {
    readLine()?.run {
        toCharArray().run {
            sortDescending()
            forEach { print(it) }
        }
    }
}
