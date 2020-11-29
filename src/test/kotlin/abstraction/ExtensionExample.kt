package abstraction

import classes.Parent
import io.kotest.core.spec.style.FunSpec

fun String.extensionMethod(): String {
    return "=== $this ==="
}

// generic extension
fun <T : Parent> T.someExtensionMethod() {
    println(" tada !")
}

class ExtenstionTests : FunSpec({
    test("Check extensions") {
        var str = "some string"
        println(str.extensionMethod())

        var instance = Parent("Parent")
        instance.someExtensionMethod()
    }
})