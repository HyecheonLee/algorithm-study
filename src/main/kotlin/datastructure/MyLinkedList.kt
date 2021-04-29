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

    fun del(data: Int) {
        if (head == null) return
        if (data == head!!.data) {
            head = head!!.next
            return
        }
        var node = head!!
        while (node.next != null) {
            if (node.next!!.data == data) {
                if (node.next == last) {
                    last = node
                }
                node.next = node.next!!.next
                break
            }
            node = node.next!!
        }
    }

    fun desc() {
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
    myLinkedList.desc()
    println()
    myLinkedList.del(10)
    myLinkedList.desc()
    println()
    myLinkedList.add(11)
    myLinkedList.desc()
    println()
    myLinkedList.del(1)
    myLinkedList.desc()
    println()
    myLinkedList.del(5)
    myLinkedList.desc()
    println()
}