package colorpicker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import common.tabKey
import common.upDownKey
import kotlinx.coroutines.delay
import java.awt.MouseInfo
import java.awt.Robot


@Composable
fun ColorPicker(
    modifier: Modifier
) {
    val focusManager = LocalFocusManager.current
    var colorText by remember { mutableStateOf("ff000000") }
    var aText by remember { mutableStateOf( "255") }
    var rText by remember { mutableStateOf( "0") }
    var gText by remember { mutableStateOf( "0") }
    var bText by remember { mutableStateOf( "0") }
    var useMouseTracking by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(
                modifier = Modifier
                    .size(200.dp)
                    .background(color = colorText.toColor(), shape = RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.width(70.dp),
                        text = "Hex : "
                    )
                    BasicTextField(
                        modifier = Modifier.fillMaxWidth().padding(5.dp).background(color = Color.LightGray, shape = RoundedCornerShape(5.dp)).padding(5.dp)
                            .tabKey { isShiftPressed -> focusManager.moveFocus(if (isShiftPressed) FocusDirection.Previous else FocusDirection.Next) },
                        value = colorText,
                        textStyle = TextStyle.Default.copy(textAlign = TextAlign.Center, color = Color.Black),
                        onValueChange = {
                            colorText = it
                            aText = it.getAlphaHexInt().toString()
                            rText = it.getRedHexInt().toString()
                            gText = it.getGreenHexInt().toString()
                            bText = it.getBlueHexInt().toString()
                        },
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.width(70.dp),
                        text = "ARGB : "
                    )
                    BasicTextField(
                        modifier = Modifier.fillMaxWidth().padding(5.dp).background(color = Color.LightGray, shape = RoundedCornerShape(5.dp)).padding(5.dp).weight(1f)
                            .tabKey { isShiftPressed -> focusManager.moveFocus(if (isShiftPressed) FocusDirection.Previous else FocusDirection.Next) }
                            .upDownKey { isUp ->
                                aText = ((aText.toIntOrNull() ?: 0) + (if (isUp) 1 else -1)).coerceIn(0, 255).toString()
                                colorText = argbStringToHexString(aText, rText, gText, bText)
                            },
                        value = aText,
                        textStyle = TextStyle.Default.copy(textAlign = TextAlign.Center, color = Color.Black),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        onValueChange = {
                            aText = it
                            colorText = argbStringToHexString(aText, rText, gText, bText)
                        },
                    )
                    BasicTextField(
                        modifier = Modifier.fillMaxWidth().padding(5.dp).background(color = Color.LightGray, shape = RoundedCornerShape(5.dp)).padding(5.dp).weight(1f)
                            .tabKey { isShiftPressed -> focusManager.moveFocus(if (isShiftPressed) FocusDirection.Previous else FocusDirection.Next) }
                            .upDownKey { isUp ->
                                rText = ((rText.toIntOrNull() ?: 0) + (if (isUp) 1 else -1)).coerceIn(0, 255).toString()
                                colorText = argbStringToHexString(aText, rText, gText, bText)
                            },
                        value = rText,
                        textStyle = TextStyle.Default.copy(textAlign = TextAlign.Center, color = Color.Black),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        onValueChange = {
                            rText = it
                            colorText = argbStringToHexString(aText, rText, gText, bText)
                        },
                    )
                    BasicTextField(
                        modifier = Modifier.fillMaxWidth().padding(5.dp).background(color = Color.LightGray, shape = RoundedCornerShape(5.dp)).padding(5.dp).weight(1f)
                            .tabKey { isShiftPressed -> focusManager.moveFocus(if (isShiftPressed) FocusDirection.Previous else FocusDirection.Next) }
                            .upDownKey { isUp ->
                                gText = ((gText.toIntOrNull() ?: 0) + (if (isUp) 1 else -1)).coerceIn(0, 255).toString()
                                colorText = argbStringToHexString(aText, rText, gText, bText)
                            },
                        value = gText,
                        textStyle = TextStyle.Default.copy(textAlign = TextAlign.Center, color = Color.Black),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        onValueChange = {
                            gText = it
                            colorText = argbStringToHexString(aText, rText, gText, bText)
                        },
                    )
                    BasicTextField(
                        modifier = Modifier.fillMaxWidth().padding(5.dp).background(color = Color.LightGray, shape = RoundedCornerShape(5.dp)).padding(5.dp).weight(1f)
                            .tabKey { isShiftPressed -> focusManager.moveFocus(if (isShiftPressed) FocusDirection.Previous else FocusDirection.Next) }
                            .upDownKey { isUp ->
                                bText = ((bText.toIntOrNull() ?: 0) + (if (isUp) 1 else -1)).coerceIn(0, 255).toString()
                                colorText = argbStringToHexString(aText, rText, gText, bText)
                            },
                        value = bText,
                        textStyle = TextStyle.Default.copy(textAlign = TextAlign.Center, color = Color.Black),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        keyboardActions = KeyboardActions(

                        ),
                        onValueChange = {
                            bText = it
                            colorText = argbStringToHexString(aText, rText, gText, bText)
                        },
                    )
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Mouse Tracking")
            Switch(
                checked = useMouseTracking,
                onCheckedChange = {
                    useMouseTracking = it
                }
            )
        }
    }

    LaunchedEffect(useMouseTracking) {
        val robot = Robot()
        while(useMouseTracking) {
            delay(50)
            val mouse = MouseInfo.getPointerInfo()
            val pixelColor = robot.getPixelColor(mouse.location.x - 1, mouse.location.y - 1)
            aText = "255"
            rText = pixelColor.red.toString()
            gText = pixelColor.green.toString()
            bText = pixelColor.blue.toString()
            colorText = argbStringToHexString(aText, rText, gText, bText)
        }
    }
}


private fun String.toColor(): Color {
    return Color(
        alpha = getAlphaHexInt(),
        red = getRedHexInt(),
        green = getGreenHexInt(),
        blue = getBlueHexInt()
    )
}

private fun String.getAlphaHexInt(): Int {
    val ts = this.trim().lowercase()
    return when {
        (ts.length >= 8) -> ts.substring(0, 2).toHexInt()
        else -> 0xff
    }
}

private fun String.getRedHexInt(): Int {
    val ts = this.trim().lowercase()
    return when {
        (ts.length >= 8) -> ts.substring(2, 4).toHexInt()
        (ts.length >= 6) -> ts.substring(0, 2).toHexInt()
        (ts.length >= 3) ->(ts.substring(0, 1) + ts.substring(0, 1)).toHexInt()
        else -> 0xff
    }
}

private fun String.getGreenHexInt(): Int {
    val ts = this.trim().lowercase()
    return when {
        (ts.length >= 8) -> ts.substring(4, 6).toHexInt()
        (ts.length >= 6) -> ts.substring(2, 4).toHexInt()
        (ts.length >= 3) ->(ts.substring(1, 2) + ts.substring(1, 2)).toHexInt()
        else -> 0xff
    }
}

private fun String.getBlueHexInt(): Int {
    val ts = this.trim().lowercase()
    return when {
        (ts.length >= 8) -> ts.substring(6, 8).toHexInt()
        (ts.length >= 6) -> ts.substring(4, 6).toHexInt()
        (ts.length >= 3) ->(ts.substring(2, 3) + ts.substring(2, 3)).toHexInt()
        else -> 0xff
    }
}

private fun argbStringToHexString(a: String, r: String, g: String, b: String): String {
    return String.format("%02x", (a.toIntOrNull() ?: 0).coerceIn(0, 255)) +
            String.format("%02x", (r.toIntOrNull() ?: 0).coerceIn(0, 255)) +
            String.format("%02x", (g.toIntOrNull() ?: 0).coerceIn(0, 255)) +
            String.format("%02x", (b.toIntOrNull() ?: 0).coerceIn(0, 255))
}

private fun String.toHexInt(): Int = this.toIntOrNull(16) ?: 0xff
