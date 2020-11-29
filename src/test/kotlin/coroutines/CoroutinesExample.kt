package coroutines

import classes.Parent
import io.kotest.core.spec.style.AnnotationSpec
import kotlinx.coroutines.*
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.milliseconds
import kotlin.time.seconds

class CoroutinesTests : AnnotationSpec() {
    @Test
    suspend fun `Run non blocking coroutine`() {
        val job = GlobalScope.launch {
            Parent("Parent").parentFunction()
        }

        delay(500)
        println("Main thread")
        job.join()
    }

    @Test
    fun `Blocking coroutine`() {
        runBlocking {
            delay(500)
        }

    }

    @ExperimentalTime
    @Test
    suspend fun `Check suspending (synchrounosly) functions`() {
        var one = suspendingFunction()
        var two = anotherSuspendingFunction()
        println(one + two)
    }

    @ExperimentalTime
    @Test
    suspend fun `Check suspending (async) functions`() {
        coroutineScope { }

        var one = GlobalScope.async { suspendingFunction() }
        var two = GlobalScope.async { anotherSuspendingFunction() }
        println(one.await() + two.await())
    }

    @ExperimentalTime
    suspend fun suspendingFunction(): Int {
        delay(500.milliseconds)
        return 10
    }

    @ExperimentalTime
    suspend fun anotherSuspendingFunction(): Int {
        delay(500.milliseconds)
        return 32
    }

}