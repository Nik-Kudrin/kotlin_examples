import io.kotest.core.spec.style.FunSpec

class SomeClassWithStaticMethod private constructor() {
    companion object {
        fun method1(): String {
            return ""
        }
    }
}


val Extension: SomeClassWithStaticMethod? = null

fun SomeClassWithStaticMethod?.extensionMethod(inputString: String): String {
    return SomeClassWithStaticMethod.method1() + inputString
}


class CheckStaticExtensionWorking : FunSpec({
    test("Check static extensoin") {
        println(Extension.extensionMethod("ololo"))
    }
})
