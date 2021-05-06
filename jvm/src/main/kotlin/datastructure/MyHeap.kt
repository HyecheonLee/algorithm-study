package datastructure

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/05/07
 */
class MyHeap {
    private val heap = arrayListOf<Int>()
    private var size: Int = 0

    init {
        heap.add(-1)
    }

    fun insert(data: Int) {
        heap.add(data)
        insertSortHeap()
    }

    fun delete() {
        delete(heap[1])
    }

    fun delete(data: Int) {
        val searchIndex = searchIndex(data)
        val lastIndex = heap.size - 1
        swap(searchIndex, lastIndex)
        heap.removeAt(lastIndex)
        sort()
    }

    private fun searchIndex(data: Int, index: Int = 1): Int {
        val size = heap.size
        if (index >= size) return -1
        if (heap[index] == data) return index
        if (index + 1 >= size) return -1
        if (heap[index + 1] == data) return index + 1
        if (heap[index] < data || heap[index + 1] < data) return -1
        val search1 = searchIndex(data, index * 2)
        val search2 = searchIndex(data, index * 2 + 1)
        return if (search1 != -1) search1
        else search2
    }

    private fun sort(index: Int = 1) {
        val max = heap.size
        val left = index * 2
        val right = index * 2 + 1
        if (right < max) {
            sort(left)
            sort(right)
            if (heap[index] < heap[right] || heap[index] < heap[left]) {
                if (heap[left] < heap[right]) {
                    swap(index, right)
                    sort(right)
                } else {
                    swap(index, left)
                    sort(left)
                }
            }
        } else if (left < max) {
            sort(left)
            if (heap[index] < heap[left]) {
                swap(index, left)
                sort(left)
            }
        }
    }

    private fun insertSortHeap() {
        var index = heap.size - 1
        while (index > 1) {
            if (heap[index] > heap[index / 2]) {
                swap(index, index / 2)
            }
            index /= 2
        }
    }

    private fun swap(index: Int, index2: Int) {
        val temp = heap[index]
        heap[index] = heap[index2]
        heap[index2] = temp
    }

    fun desc() {
        println(heap.filterIndexed { index: Int, _: Int -> index != 0 }.joinToString(",", "[", "]"))
    }
}

fun main() {
    val myHeap = MyHeap()
    myHeap.insert(10)
    myHeap.insert(5)
    myHeap.insert(4)
    myHeap.insert(11)
    myHeap.insert(15)
    myHeap.insert(6)
    myHeap.delete(11)
    myHeap.desc()
    myHeap.delete()
    myHeap.desc()
}
