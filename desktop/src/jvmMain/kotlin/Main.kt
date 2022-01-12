import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.common.App
import com.example.common.loadJsonSample
import kotlinx.coroutines.runBlocking

fun main() = application {
	val textToShow = runBlocking {
		loadJsonSample()
	}
	Window(onCloseRequest = ::exitApplication) {
		MaterialTheme {
			App(textToShow)
		}
	}
}