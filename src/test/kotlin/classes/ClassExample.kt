package classes

import io.kotest.core.spec.style.AnnotationSpec

class ClassExample {
    // Kotlin automatically generate getter and setter for var (property)
    // ... for val - only getter
    var text = "Default value"

    var anotherProperty: String = ""
        get() {
            println("Getter called")
            return field.capitalize()
        }
        private set(value) {
            println("Setter called")
            field = value.trim()
        }

    private fun xxx() {}
    protected fun zzz() {}
    internal fun yyy() {}
    public fun ttt() {}
}

class CheckClassFeatures() : AnnotationSpec() {

    @Test
    fun checkClassFeatures() {
        val example = ClassExample()
        var str = example.text
        example.text = "some text"

        str = example.anotherProperty
        // cannot access private setter
        // example.anotherProperty = "some new text"
    }
}

