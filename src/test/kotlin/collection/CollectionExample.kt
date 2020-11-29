package collection

import io.kotest.core.spec.style.AnnotationSpec

class CollectionExample : AnnotationSpec() {
    @Test
    fun listExamples() {
        val immutableList = listOf<String>("str", "another string")
        var mutableList = mutableListOf<String>()
        mutableList.add("one")
        mutableList = mutableList
            .distinct()
            .filter { item -> item.startsWith('a') }
            .toMutableList()

        for (item in mutableList) {
            println(item)
        }

        val length = 10;

        for (item in 0..length) {
            println(item)
        }

        for (item in 0 until length step 2) {
            println(item)
        }
    }

    @Test
    fun mapExamples() {
        var map = mutableMapOf<String, Int>()

        map.put("one", 1)
        map.put("two", 2)

        for (item in map) {
            val pair = Pair(item.key, item.value)
        }
    }
}
