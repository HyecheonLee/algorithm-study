package problem


fun main() {
    var N = readLine()!!.toInt()
    while (N-- > 0) {
        val data = readLine()!!
        val leftStack = mutableListOf<Char>()
        val rightStack = mutableListOf<Char>()
        for (i in data) {
            if (i == '-') {
                if (leftStack.isNotEmpty()) {
                    leftStack.removeAt(leftStack.size - 1)
                }
            } else if (i == '<') {
                if (leftStack.isNotEmpty()) {
                    rightStack.add(leftStack.removeAt(leftStack.size - 1))
                }
            } else if (i == '>') {
                if (rightStack.isNotEmpty()) {
                    leftStack.add(rightStack.removeAt(rightStack.size - 1))
                }
            } else {
                leftStack.add(i)
            }
        }
        leftStack.addAll(rightStack.reversed())
        println(leftStack.joinToString(""))
    }
}