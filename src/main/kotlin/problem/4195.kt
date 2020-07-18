package problem._4195

fun main() {
    var N = readLine()!!.toInt()
    while (N-- > 0) {
        var cnt = readLine()!!.toInt()
        val networks = Networks()
        while (cnt-- > 0) {
            val split = readLine()!!.split(" ")
            networks.addConnection(split[0], split[1])
        }
    }
}

class Networks {
    private val parent = mutableMapOf<String, String>()
    private val number = mutableMapOf<String, Int>()
    private val v2 = mutableMapOf<String, String>()
    fun addConnection(my: String, friend: String) {
        if (!parent.containsKey(my)) {
            parent[my] = my
            number[my] = 1
        }
        if (!parent.containsKey(friend)) {
            parent[friend] = friend
            number[friend] = 1
        }
        union(my, friend)
        println(number[find(my)])
    }

    private fun union(_x: String, _y: String) {
        val x = find(_x)
        val y = find(_y)
        if (x != y) {
            parent[y] = x
            number[x] = (number[x] ?: 0) + (number[y] ?: 0)
        }
    }

    private fun find(x: String): String {
        return if (x == parent[x]) {
            x
        } else {
            parent[x] = find(parent[x]!!)
            parent[x]!!
        }
    }
}