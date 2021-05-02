package problem._10930

import java.security.MessageDigest


fun main() {
    val input = readLine()!!
    println(hash(input))
}

fun hash(input: String): String {
    val bytes = input.toByteArray()
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(bytes)
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}