package classes

class CastingExample {

    fun castingVariables(any: Any) {
        if (any is Child) {
            // smart casting
            any.parentFunction()
        }

        var castedToParent = (any as Parent)
        castedToParent.parentFunction()
    }
}