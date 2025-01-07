import com.android.build.api.dsl.LibraryExtension
import com.sun5066.convention.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            val extensions = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extensions)
        }
    }
}