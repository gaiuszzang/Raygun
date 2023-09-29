import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import colorpicker.ColorPicker
import common.AppTheme
import common.Tab
import hextool.HexTool
import java.awt.Dimension

fun main() = application {
    Window(
        title = "Raygun",
        state = WindowState(
            size = DpSize(700.dp, 500.dp)
        ),
        onCloseRequest = ::exitApplication
    ) {
        window.minimumSize = Dimension(700, 500)
        App()
    }
}


@Composable
@Preview
fun App() {
    AppTheme {
        var selectedTab by remember { mutableStateOf(0) }
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            //Tab
            Tab(
                modifier = Modifier.width(200.dp).padding(5.dp),
                list = listOf("Hex Tool", "Color Picker"),
                selectedIndex = selectedTab,
                onSelect = {
                    selectedTab = it
                }
            )

            //Content
            Box(
                modifier = Modifier.weight(1f).padding(5.dp)
            ) {
                when (selectedTab) {
                    0 -> HexTool(modifier = Modifier.fillMaxWidth())
                    1 -> ColorPicker(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}
