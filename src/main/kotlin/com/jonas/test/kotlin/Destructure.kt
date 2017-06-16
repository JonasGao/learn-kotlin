package com.jonas.test.kotlin

/**
 * Created by jonas on 2017/6/15.
 */
fun main(args: Array<String>) {
    val match = "(\\w\\w)(\\w\\w)(\\w\\w)".toRegex().matchEntire("ffffff")
    val (_, red, green, blue) = match!!.groupValues
    println("$red, $green, $blue")
    println(red.toInt(16))

    val person = Person("Jonas", 18)
    val (age, name) = person

    println(name)
    println(age)
}

data class Person(val name: String, val age: Int)