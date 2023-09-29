package common

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.*

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.tabKey(tabKeyHandler: (isShiftPressed: Boolean) -> Unit = {}) = onPreviewKeyEvent {
    if (it.key == Key.Tab && it.type == KeyEventType.KeyDown) {
        tabKeyHandler(it.isShiftPressed)
        true
    } else {
        false
    }
}

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.upDownKey(updownKeyHandler: (isUp: Boolean) -> Unit = {}) = onPreviewKeyEvent {
    if ((it.key == Key.DirectionUp || it.key == Key.DirectionDown) && it.type == KeyEventType.KeyDown) {
        updownKeyHandler(it.key == Key.DirectionUp)
        true
    } else {
        false
    }
}