import com.github.kittinunf.fuel.Fuel
import io.kotest.core.spec.style.AnnotationSpec
import java.io.File

class TempFIleExample : AnnotationSpec() {

    val url =
        "http://jenkins.dev.ivi.ru/job/android_ui_autotest/628/artifact/develop-ru.ivi.client-12.1-11945-appversions-25110-25114-mobile-uiTest.apk"

    @Test
    fun createTempFile() {
        val file = File.createTempFile("ivi", ".apk")
        // возможно в него нужно сначала что-то записать, хз как работают временные файлы
        file.writeText(" 1 2 4")

        println("File path: ${file.absolutePath}")
        file
    }

    @Test
    fun downloadFileIntoTempFile() {
        val downloadRequest = Fuel.download(url)
            .fileDestination { response, request ->
                val file = File.createTempFile("ivi", ".apk")
                file
            }
            .progress { readBytes, totalBytes ->
                val progress = readBytes.toFloat() / totalBytes.toFloat() * 100
                println("Bytes downloaded $readBytes / $totalBytes ($progress %)")
            }
            .response { result -> }

        downloadRequest.join()
    }
}