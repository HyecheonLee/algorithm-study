package datastructure.MyTree

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/05/05
 */
class MyTree {
    private var rootNode: Node? = null

    fun insert(data: Int) {
        if (rootNode == null) {
            rootNode = Node(data = data)
            return
        }
        var node = rootNode
        while (node != null) {
            if (node.data < data) {
                if (node.right == null) {
                    node.right = Node(data = data, parentNode = node)
                    return
                }
                node = node.right
            } else {
                if (node.left == null) {
                    node.left = Node(data = data, parentNode = node)
                    return
                }
                node = node.left
            }
        }
    }

    private fun nodeChange(oldNode: Node, newNode: Node?) {
        if (newNode != null) {
            oldNode.left?.parentNode = newNode
            oldNode.right?.parentNode = newNode
            if (oldNode.left?.data != newNode.data) {
                newNode.left = oldNode.left
            }
            if (oldNode.right?.data != newNode.data) {
                newNode.right = oldNode.right
            }
            newNode.parentNode = oldNode.parentNode
            if (oldNode.parentNode != null) {
                if (oldNode.parentNode!!.data < newNode.data) {
                    oldNode.parentNode!!.right = newNode
                } else {
                    oldNode.parentNode!!.left = newNode
                }
            }
        }
    }

    fun delete(data: Int) {
        val searchNode = search(data) ?: return
        val parentNode = searchNode.parentNode!!
        if (isTerminalNode(searchNode)) {
            nodeChange(searchNode, null)

        }
        if (isOneLeafNode(searchNode)) {
            nodeChange(searchNode, searchNode.right ?: searchNode.left)
        }
        if (isTwoLeafNode(searchNode)) {
            var node = searchNode.right
            while (node != null) {
                if (node.left == null) {
                    node.parentNode!!.left = null
                    break
                }
                node = node.left
            }
            nodeChange(searchNode, node)
        }
    }

    private fun nodeChange(parentNode: Node, data: Int, node: Node?) {
        if (parentNode.data < data) {
            parentNode.right = node
        } else {
            parentNode.left = node
        }
    }

    private fun isOneLeafNode(node: Node?): Boolean {
        if (node != null) {
            if (node.left != null && node.right == null) {
                return true
            }
            if (node.left == null && node.right != null) {
                return true
            }
        }
        return false
    }

    private fun isTwoLeafNode(node: Node?): Boolean {
        if (node != null) {
            if (node.left != null && node.right != null) {
                return true
            }
        }
        return false
    }

    private fun isTerminalNode(node: Node?): Boolean {
        return node != null && node.left == null && node.right == null
    }

    fun desc() {
        printNode(rootNode)
    }

    fun search(data: Int): Node? {
        tailrec fun loop(node: Node?): Node? {
            if (node == null) return null
            return when {
                data == node.data -> node
                data > node.data -> loop(node.right)
                data < node.data -> loop(node.left)
                else -> null
            }
        }
        return loop(rootNode)
    }

    private fun printNode(node: Node?) {
        if (node != null) {
            println(node.data)
            if (node.left != null) {
                println(" left =>")
                printNode(node.left)
            }
            if (node.right != null) {
                println("right =>")
                printNode(node.right)
            }
        }
    }

    data class Node(var left: Node? = null, var data: Int, var right: Node? = null, var parentNode: Node? = null) {
        override fun toString(): String {
            return "Node(left=$left, data=$data, right=$right)"
        }
    }
}

fun main() {
    val myTree = MyTree()
    myTree.insert(30)
    myTree.insert(15)
    myTree.insert(60)
    myTree.insert(7)
    myTree.insert(20)
    myTree.insert(6)
    myTree.insert(5)
    myTree.insert(8)
    myTree.insert(16)
    myTree.insert(23)
    myTree.insert(25)
//    myTree.desc()
    myTree.delete(15)
    val search = myTree.search(16)
    println(search)
    myTree.delete(8)
    val search1 = myTree.search(7)
    println(search1)
    myTree.delete(6)
    val search2 = myTree.search(7)
    println(search2)
}