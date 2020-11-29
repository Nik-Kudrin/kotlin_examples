package abstraction

import classes.Child
import classes.Parent
import io.kotest.core.spec.style.FunSpec

class GenericClass<out T : Parent>(_item: T) {
    val item: T = _item

    fun returnItem(): T {
        return item
    }

    fun <R> generateStuff(someFunction: (T) -> R): R {
        return someFunction(item)
    }
}

class GenericClassTests : FunSpec({
    test("Tests for generics") {
        val instance = GenericClass(Parent("Parent"))
        println(instance.returnItem())

        val result = instance.generateStuff() { "-- ${it.toString()} --" }
        println(result)
    }

    test("Test invariance (keyword - out) of T type") {
        val instance = GenericClass<Child>(Child())
        println(instance.returnItem())

        var parentInstance = GenericClass<Parent>(Parent("Parent"))
        // Because of OUT keyword in generic class the casting is allowed
        parentInstance = instance
        println(instance.returnItem())
    }
})
