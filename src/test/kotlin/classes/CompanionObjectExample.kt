package classes

import io.kotest.core.spec.style.AnnotationSpec

class CompanionObjectExample {
    // Companion object will be singleton
    companion object {
        const val CONSTANT_STR = "constant"
        fun doSomething() {}
    }
}


class CompanionObjectTests : AnnotationSpec() {
    @Test
    fun `Companion object checks`() {
        var const = CompanionObjectExample.CONSTANT_STR
        CompanionObjectExample.doSomething() // call a function like a static method

    }
}