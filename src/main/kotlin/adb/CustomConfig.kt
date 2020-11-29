package adb

import com.sksamuel.hoplite.ConfigLoader

class AdbOutputParser {
    val consoleOut = """List of devices attached
emulator-5554          device product:sdk_gphone_x86 model:Android_SDK_built_for_x86 device:generic_x86 transport_id:1
emulator-5556          device product:sdk_gphone_x86 model:Android_SDK_built_for_x86 device:generic_x86 transport_id:2"""

    fun parse() {
        //  пропускаем первую строку
        for (line in consoleOut.split(System.lineSeparator()).drop(1)) {

            // тут надо написать хитрый алгоритм для выкусывания 'emulator-5554          device' из строки
            var endOfDeviceNameIndex = line.indexOf(" ")

            // пока 29 - хардкод - см. выше причину
            endOfDeviceNameIndex = 29
            val deviceName = line.substring(0, endOfDeviceNameIndex)

            val deviceParameters = line.substring(endOfDeviceNameIndex).trim()
            val splitParams = deviceParameters.split(" ").toMutableList()

            val map = mutableMapOf<String, String>()
            map.put("name", deviceName)

            val paramsMap = splitParams.associate {
                val (key, value) = it.split(":")
                key to value
            }

            map.putAll(paramsMap)

            val device = Device.initialize(map)
//            map.forEach { println(it) }
            println("======== $device")
        }
    }

    fun readYamlFromConfig() {
//        val configText = Processor::class.java.classLoader.getResource("config.yaml").readText()
//
//        println(configText)
//        val result = Yaml.default.parse(Root.serializer(), configText)
    }

}


//@Serializable
object CustomConfig {
    val settings = ConfigLoader().loadConfigOrThrow<Root>("/config.yaml")
}

//@Serializable
data class Root(var devices: List<Device>)

//@Serializable
data class Device(
    var name: String,
    var product: String,
    var model: String,
    var device: String,
    var transportId: Int
) {
    companion object {
        fun initialize(deviceParameters: MutableMap<String, String>): Device {
            val name = deviceParameters.get("name").orEmpty()
            val product = deviceParameters.get("product").orEmpty()
            val model = deviceParameters.get("model").orEmpty()
            val device = deviceParameters.get("device").orEmpty()
            val transportId = deviceParameters.get("transport_id").orEmpty().toInt()

            return Device(name, product, model, device, transportId)
        }
    }

}