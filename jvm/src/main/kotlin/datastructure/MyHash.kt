package datastructure

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/05/04
 */
class MyHash {
    private val map = Array<MutableList<Node>>(10) { mutableListOf() }
    fun put(key: String, data: String) {
        val (hashKey, index) = hashKeyAndIndex(key)
        map[index].find { it.key == hashKey }?.also { it.data = data } ?: map[index].add(Node(hashKey, data))
    }

    fun get(key: String): String? {
        val (hashKey, index) = hashKeyAndIndex(key)
        return map[index].find { it.key == hashKey }?.data
    }

    private fun hashKeyAndIndex(key: String): Pair<Int, Int> {
        val hashKey = key.hashCode()
        val index = if (hashKey < 0) (hashKey % 10) + 10 else (hashKey % 10)
        return Pair(hashKey, index)
    }

    data class Node(val key: Int, var data: String)
}

fun main() {
    val hashMap = MyHash()
    hashMap.put("hello", "world")
    println(hashMap.get("hello"))
    hashMap.put("hello2", "world2")
    println(hashMap.get("hello2"))
    hashMap.put("hello2", "world3")
    hashMap.put("Dd", "world11111")
    hashMap.put("Data", "world3")
    println(hashMap.get("hello2"))
}