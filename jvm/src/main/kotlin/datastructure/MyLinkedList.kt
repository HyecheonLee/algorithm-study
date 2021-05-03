package datastructure.MyLinkedList

import java.security.MessageDigest

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/04/29
 */
class MyLinkedList {
    private var head: Node? = null
    private var tail: Node? = null
    fun add(data: Int) {
        if (head == null) {
            head = Node(data)
            tail = head
        } else {
            val currentLastNode = tail
            tail = Node(data, prev = currentLastNode)
            currentLastNode?.next = tail
        }
    }

    fun addAfter(data: Int, beforeData: Int) {
        val searchNode = searchNode(beforeData)
        if (searchNode == null) add(data)
        else {
            val newNode = Node(9, prev = searchNode, next = searchNode.next)
            searchNode.next = newNode
            newNode.next?.prev = newNode
        }
    }

    fun addBefore(data: Int, afterData: Int) {
        val searchNode = searchNode(afterData)
        if (searchNode == null) add(data)
        else {
            val newNode = Node(9, prev = searchNode.prev, next = searchNode)
            searchNode.prev = newNode
            newNode.prev?.next = newNode
        }
    }

    private fun searchNode(data: Int): Node? {
        var node = head
        while (node != null) {
            if (node.data == data) {
                return node
            }
            node = node.next
        }
        return null
    }


    fun del(data: Int) {
        if (head == null) return
        if (data == head!!.data) {
            head = head!!.next
            head?.prev = null
            return
        }
        var node = head!!
        while (node.next != null) {
            if (node.next!!.data == data) {
                if (node.next == tail) {
                    tail = node
                }
                node.next = node.next!!.next
                node.next?.prev = node
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
        println()
    }

    fun reversDesc() {
        var node = tail
        while (node != null) {
            print("${node.data}, ")
            node = node.prev
        }
    }

    data class Node(
        val data: Int,
        var prev: Node? = null,
        var next: Node? = null
    ) {
        override fun toString(): String {
            return "Node(data=$data)"
        }
    }
}

fun main() {
    val myLinkedList = MyLinkedList()
    for (data in 1..10) {
        myLinkedList.add(data)
    }
//    myLinkedList.desc()
    myLinkedList.del(10)
//    myLinkedList.desc()
    myLinkedList.add(11)
//    myLinkedList.desc()
    myLinkedList.del(1)
//    myLinkedList.desc()
    myLinkedList.del(5)
//    myLinkedList.desc()
//    println()
//    myLinkedList.reversDesc()
    println("===========================")
    myLinkedList.addAfter(13, 6)
    myLinkedList.desc()
    myLinkedList.addAfter(14, 1)
    myLinkedList.desc()
    myLinkedList.addBefore(16, 11)
    myLinkedList.desc()
    myLinkedList.addBefore(17, 120)
    myLinkedList.desc()
}