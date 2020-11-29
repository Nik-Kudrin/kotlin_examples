package adb

import com.sksamuel.hoplite.ConfigLoader

/**
 * Синглтон инициализации конфига
 */
object Config {
    val settings = ConfigLoader().loadConfigOrThrow<RootConfig>("/config.yaml")
}

/**
 * Корневой элемент конфига
 */
data class RootConfig(val testrail: TestRailConfigSection)

/**
 * Секция testrail в конфиге
 */
data class TestRailConfigSection(
    val isIntegrationEnabled: Boolean,
    val baseUrl: String,
    val user: String,
    val password: String,
    val runForSync: String
)