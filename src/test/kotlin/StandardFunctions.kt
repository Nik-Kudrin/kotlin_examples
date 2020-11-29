import java.io.File

fun applyAttributesToFile() {
    val pathToFIle = "bla bla"

    // apply
    val file = File(pathToFIle).apply {
        setExecutable(true)
        setReadable(true)
    }

    // run
    val isContainsText = file
        .run {
            readText().contains("ololo")
        }
        .run { println() }

    // with (the same, as run, but takes 1 parameter - receiver)
    val containsText = with(file) {
        readText().contains("ololo")
    }

    // also
    val content: List<String>
    file.also {
        println("File name is '$it'")
    }.also {
        content = it.readLines()
    }

    // takeIf
    var lines = file.takeIf {
        it.canRead()
    }?.readLines()
}