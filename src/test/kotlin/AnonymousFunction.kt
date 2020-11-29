import io.kotest.core.spec.style.FunSpec

val anonymousFunctionExample: (Int, Double) -> String = { integer, double ->
    "Some string $integer, $double";
}

val functionWithOneParameter: (String) -> Unit = {
    println(it + " additional text ")
}

val functionWithTypeInference = { param: Int, paramDouble: Double ->
    "Returned string"
}


public class AnonymousFunctionTest : FunSpec({
    test("Test anonymous function") {
        println(anonymousFunctionExample(1, 3.3))
        functionWithOneParameter("TEXT ");
    }

    test("Anonymous function: count symbols") {
        var countOfChars = this.testCase.name.count { it.toLowerCase() == 't' }
        print("Count of T or t in test name is '$countOfChars'")
    }
}
)

