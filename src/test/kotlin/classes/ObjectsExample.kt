package classes

import Variables
import io.kotest.core.spec.style.AnnotationSpec

object SingletonObject {
    private val state: Variables

    init {
        state = Variables()
    }

    fun doStuff() {
        println("Stuff done")
    }

}

class ObjectChecks : AnnotationSpec() {
    @Test
    fun `Singleton examples`() {
        SingletonObject.doStuff()
    }

    @Test
    fun `Object expression`() {
        val str = "bla bla"

        // using object keyword to create anonymous class
        var anotherObj = object {
            val strProp: String = str
            fun doAnotherStuff() {
                println(strProp)
            }
        }
        anotherObj.doAnotherStuff()
        anotherObj.strProp

        var obj = object : Parent("some name") {
            override fun getFormattedName(): String {
                return ""
            }
        }

        obj.parentFunction()
    }
}