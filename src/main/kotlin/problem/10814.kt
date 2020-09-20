package problem

data class Member(val id: Int, val age: Int, val name: String)

fun main() {
    val n = readLine()!!.toInt()
    val members = mutableListOf<Member>()
    for (i in 1..n) {
        val input = readLine()!!.split(" ")
        members.add(Member(id = i, age = input[0].toInt(), name = input[1]))
    }
    members.sortWith(Comparator { o1, o2 ->
        when {
            o1.age < o2.age -> -1
            o1.age > o2.age -> 1
            o1.age == o2.age && o1.id > o2.id -> 1
            o1.age == o2.age && o1.id < o2.id -> -1
            else -> 0
        }
    })
    println(members.joinToString("\n") { "${it.age} ${it.name}" })
}
