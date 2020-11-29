package classes

import io.kotest.core.spec.style.AnnotationSpec
import java.util.*

class ClassWithParametrizedConstructor(
    _name: String,
    _number: Int = 10,
    var someStringProp: String = "",
    val someDoubleProp: Double = 0.0,
    private val somePrivateReadonlyString: String = ""
) {
    val number = _number;
    val name = _name
    var generatedName: String
        get() {
            return UUID.randomUUID().toString()
        }
        private set(value) {}

    private val someNewString: String

    constructor() : this("-")

    init {
        require(number > 0)
        require(name.isNotBlank())
        // ... and other assertions

        // initialization of variables
        someNewString = ""
    }
}

class Tests : AnnotationSpec() {
    @Test
    fun `Check constructor with parameters`() {
        var example = ClassWithParametrizedConstructor("bla", 23)
        var eg2 = ClassWithParametrizedConstructor()
    }
}