import classes.Child
import classes.ClassExample
import classes.Parent
import io.kotest.core.spec.style.FunSpec

enum class EnumerationExample {
    NORTH,
    SOUTH,
    WEST,
    EAST
}

enum class EnumWithConstructor(private var variable: Parent) {
    NORTH(Child()),
    SOUTH(Parent("south"));

    fun doSomethingWithVariables() {
        variable = Child()
    }
}


class CheckEnums : FunSpec({
    test("Enumeration examples") {
        val north = EnumWithConstructor.NORTH
        north.doSomethingWithVariables()
    }
})