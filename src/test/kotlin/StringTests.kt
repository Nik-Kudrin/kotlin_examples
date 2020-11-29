import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec

class StringTests : AnnotationSpec() {

    @Test
    fun `Check string methods`() {
        val sourceStr = "Some string example" 
        shouldThrow<StringIndexOutOfBoundsException> { sourceStr.substring(0 until 20) }
    }
}