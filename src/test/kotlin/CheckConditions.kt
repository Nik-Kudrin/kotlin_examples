import io.kotest.core.spec.style.FunSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.beOfType
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe

class CheckConditions : FunSpec({
    context("Test group name") {
        test("Check conditions in Kotlin") {
            checkIfElseConditions()
        }
    }

    test("Check switch behaviour") {
        forAll(
            row("", 0.0),
            row("ololo", "ololo"),
            row("2", 23)
        )
        { input, expected ->
            switchExample(input) shouldBe expected
        }
    }

    test("Check switch behaviour for type") {
        forAll(
            row("minus", Variables())
        )
        { input, expected ->
            switchExample(input) should beOfType<Variables>()
        }
    }
})