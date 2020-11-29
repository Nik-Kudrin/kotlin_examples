package data

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

// == operator by default for data class compare parameters of main constructor
data class DataClassExample(
    val _name: String,
    val value: BigDecimal,
    var count: Int
) {
    var name = _name
        private set(value) {
            field = value.trim()
        }

    init {
        require(name.trim().length > 0)
    }

    val isOk = name.trim().length > 42

    fun calculateThings() {}
}

class DataTests : FunSpec({
    test("Check functionality of data classes") {
        val firstData = DataClassExample("one", BigDecimal(0.234), 34)
        val secondData = DataClassExample("one", BigDecimal(0.234), 34)

        firstData.shouldBe(secondData)

        // copying by default copy all the fields for data classes
        var thirdData = firstData.copy()
        thirdData.equals(firstData).shouldBe(true)
        (thirdData == firstData).shouldBe(true)
    }

    test("Destructuring example") {
        val firstData = DataClassExample("one", BigDecimal(0.234), 34)
        // destructuring data class
        val (name, value, count) = firstData

        println("$name $value $count")
    }
})