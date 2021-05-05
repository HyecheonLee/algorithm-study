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
        val parentNode = oldNode.parentNode!!
        if (newNode == null) {
            if (parentNode.left == oldNode) parentNode.left = null
            if (parentNode.right == oldNode) parentNode.right = null
            return
        }
        newNode.parentNode = parentNode
        if (parentNode.left == oldNode) {
            parentNode.left = newNode
        }
        if (parentNode.right == oldNode) {
            parentNode.right = newNode
        }
        if (oldNode.left != newNode) {
            newNode.left = oldNode.left
            newNode.left?.parentNode = newNode
        }
        if (oldNode.right != newNode) {
            newNode.right = oldNode.right
            newNode.right?.parentNode = newNode
        }
    }

    fun delete(data: Int) {
        val searchNode = search(data) ?: return
        if (isTerminalNode(searchNode)) nodeChange(searchNode, null)
        if (isOneLeafNode(searchNode)) nodeChange(searchNode, searchNode.right ?: searchNode.left)
        if (isTwoLeafNode(searchNode)) {
            var changeNode = searchNode.right
            while (changeNode != null) {
                if (changeNode.left == null) {
                    changeNode.parentNode!!.left = null
                    break
                }
                changeNode = changeNode.left
            }
            nodeChange(searchNode, changeNode)
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


    myTree.delete(15)
    val search = myTree.search(16)
    println("${search?.parentNode?.data}  는 30이다")
    println("${search?.left?.data}  는 7이다")
    println("${search?.right?.data}  는 20이다")
    println("${search?.right?.left}  는 null이다")
    println("=================================")
    myTree.delete(6)
    val search2 = myTree.search(5)
    println("${search2?.parentNode?.data}  는 7이다")
    println("${search2?.parentNode?.left?.data}  는 5이다")
    println("${search2?.left}  는 null 이다")
    println("${search2?.right}  는 null 이다")
    println("=================================")
    myTree.delete(5)
    val search3 = myTree.search(7)
    println("${search3?.left}  는 null 이다")
    println("${search3?.right?.data}  는 8 이다")
}