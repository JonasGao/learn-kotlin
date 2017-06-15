package com.jonas.test.kotlin.coroutines

import kotlin.coroutines.experimental.*

/**
 * Created by jonas on 2017/6/1.
 */
fun main(args: Array<String>) {
    println("Call main")
    runSuspend {
        suspend1()
        suspend2()
        suspend3()
        suspendCoroutine<Unit> { cont ->
            println("Sleep")
            Thread.sleep(3000)
            println("Hello Kotlin")

            cont.resume(Unit)
        }
    }
    println("after suspend")
    readLine()
}

fun runSuspend(block: suspend () -> Unit) {
    val continuation = object : Continuation<Unit> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resume(value: Unit) {
            println("resuming")
        }

        override fun resumeWithException(exception: Throwable) {
            println("what fuck!")
        }

    }
    block.startCoroutine(continuation)
    println("started coroutine")
}

suspend fun suspend1() {
    println("im suspend1")
    suspendCoroutine<Unit> { cont ->
        println("suspend the 1")
        // cont.resume(Unit)
    }
}

suspend fun suspend2() {
    println("im suspend2")
    suspendCoroutine<Unit> { }
}

suspend fun suspend3() {
    println("im suspend3")
    suspendCoroutine<Unit> { cont ->
        println("suspend the 3")
        cont.resume(Unit)
    }
}