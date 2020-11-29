fun checkIfElseConditions() {

    var result = if (1 > 2) {
        "--"
    } else {
        "=="
    }

    println(result)
}

/**
 *
 */
fun switchExample(value: String = ""): Any {
    val result = when (value) {
        "" -> 0.0
        "ololo" -> "ololo"
        in "".."233" -> {
            23;
        }

        else -> Variables()
    }

    return result;
}