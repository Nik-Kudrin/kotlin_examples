package classes

import io.kotest.core.spec.style.AnnotationSpec

// cannot be inherited
class ClosedParent {
}

open class Parent(protected val name: String) {

    protected open val level = 0

    protected open fun getFormattedName(): String {
        return "Name is $name"
    }

    fun parentFunction() {
        println("Parent function")
    }
}

open class Child : Parent("Child") {

    override val level = super.level + 10

    // subclasses of Child class cannot override this function
    final override fun getFormattedName(): String {
        return "Child override"
    }
}

class TestsForInheritance : AnnotationSpec() {
    @Test
    fun `Check inheritance features`() {
        val child = Child()
        // isn't accessible
        // child.name
        // child.getFormattedName
        child.parentFunction()
    }
}