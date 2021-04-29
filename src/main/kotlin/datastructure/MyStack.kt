package datastructure.MyStack

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/04/28
 */
class MyStack {
    private val stackData = mutableListOf<Int>()

    fun pop(): Int {
        val last = stackData.last()
        stackData.remove(stackData.size - 1)
        return last
    }

    fun push(data: Int) {
        stackData.add(data)
    }
}

fun main() {
    val myStack = MyStack()
    for (index in 1..10) {
        myStack.push(index)
    }
    println(myStack.pop())
}