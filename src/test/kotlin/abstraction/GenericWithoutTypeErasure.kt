package abstraction

import classes.Child
import classes.Parent

class GenericWithoutTypeErasure {
    // with reified (in inline function) it is possible to check type at runtime (metadata preserved)
    inline fun <reified T> checkTypeOfGeneric(): T? {
        var items = listOf<Parent>(Parent("Parent"), Child())

        items.forEach {
            if (it is T)
                return it;
        }

        return null
    }
}