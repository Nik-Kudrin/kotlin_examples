import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import java.io.BufferedReader
import java.io.FileReader
import java.io.Reader
import java.lang.Exception

class NullChecking : AnnotationSpec() {
    fun getNullableInt(getNull: Boolean = false): Int? {
        if (getNull) return null
        else return 10
    }

    @Test
    fun `Null checking example`() {
        var nullableInt = getNullableInt(true)
        var result = nullableInt?.plus(5)
        result shouldBe null

        println(result)
    }

    @Test
    fun `Null checking with let`() {
        var nullableInt = getNullableInt(true)
        var result = nullableInt?.let {
            if (it > 10)
                it
            else
                it * 100
        }

        result shouldBe null
    }

    @Test
    fun `Null coalescing operator`() {
        val nullable = getNullableInt(true)
        val result = nullable ?: 6
        result shouldNotBe null
    }

    @Test
    fun `Exceptions handling`() {
        try {
            var reader = BufferedReader(FileReader("file path"))
            reader.lines()
        } catch (e: Exception) {
            // exception handling
        } finally {
            // finally block
        }

    }
}
