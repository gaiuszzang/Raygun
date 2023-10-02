package hextool

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
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


@Composable
fun HexTool(
    modifier: Modifier
) {
    val focusManager = LocalFocusManager.current
    var numHexToInt: String by remember { mutableStateOf("") }
    var numIntToHex: String by remember { mutableStateOf("") }
    Column(
        modifier = modifier
    ) {
        Text(text = "Int to Hex", color = MaterialTheme.colors.onBackground)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(modifier = Modifier.width(70.dp), text = "Int : ", color = MaterialTheme.colors.onBackground)
            BasicTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp).background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(5.dp)).padding(5.dp)
                    .tabKey { isShiftPressed -> focusManager.moveFocus(if (isShiftPressed) FocusDirection.Previous else FocusDirection.Next) },
                value = numIntToHex,
                textStyle = TextStyle.Default.copy(textAlign = TextAlign.End, color = MaterialTheme.colors.onSurface),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { numIntToHex = it }
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(modifier = Modifier.width(70.dp), text = "Hex : ", color = MaterialTheme.colors.onBackground)
            BasicTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp).background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(5.dp)).padding(5.dp)
                    .tabKey { isShiftPressed -> focusManager.moveFocus(if (isShiftPressed) FocusDirection.Previous else FocusDirection.Next) },
                value = "0x${Integer.toHexString(numIntToHex.toIntOrNull() ?: 0)}",
                textStyle = TextStyle.Default.copy(textAlign = TextAlign.End, color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f)),
                onValueChange = {}
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        Text(text = "Hex to Int", color = MaterialTheme.colors.onBackground)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(modifier = Modifier.width(70.dp), text = "Hex : ", color = MaterialTheme.colors.onBackground)
            BasicTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp).background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(5.dp)).padding(5.dp)
                    .tabKey { isShiftPressed -> focusManager.moveFocus(if (isShiftPressed) FocusDirection.Previous else FocusDirection.Next) },
                value = numHexToInt,
                textStyle = TextStyle.Default.copy(textAlign = TextAlign.End, color = MaterialTheme.colors.onSurface),
                onValueChange = { numHexToInt = it },
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(modifier = Modifier.width(70.dp), text = "Int : ", color = MaterialTheme.colors.onBackground)
            BasicTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp).background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(5.dp)).padding(5.dp)
                    .tabKey { isShiftPressed -> focusManager.moveFocus(if (isShiftPressed) FocusDirection.Previous else FocusDirection.Next) },
                value = "${numHexToInt.toLongOrNull(16) ?: "0"}",
                textStyle = TextStyle.Default.copy(textAlign = TextAlign.End, color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f)),
                onValueChange = {}
            )
        }
    }
}