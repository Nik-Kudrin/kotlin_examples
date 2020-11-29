import adb.CustomConfig
import adb.AdbOutputParser
import io.kotest.core.spec.style.AnnotationSpec

class AdbDevices : AnnotationSpec() {

    @Test
    fun `Check loading list of devices`() {
//        Processor().readFromConfig()
        AdbOutputParser().parse()


        val config = CustomConfig.settings.devices
        println(config)
    }
}