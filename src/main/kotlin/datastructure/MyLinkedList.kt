package datastructure.MyLinkedList

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/04/29
 */
class MyLinkedList {
    private var head: Node? = null
    private var last: Node? = null
    fun add(data: Int) {
        if (head == null) {
            head = Node(data)
            last = head
        } else {
            last?.next = Node(data)
            last = last?.next
        }
    }

    fun nodePrint() {
        var node = head
        while (node != null) {
            print("${node.data}, ")
            node = node.next
        }
    }

    data class Node(
        val data: Int,
        var next: Node? = null
    )
}

fun main() {
    val myLinkedList = MyLinkedList()
    for (data in 1..10) {
        myLinkedList.add(data)
    }
    myLinkedList.nodePrint()
}