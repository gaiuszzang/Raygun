package common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

val PrimaryColor = Color(0xff0086fc)
val PrimaryColorVariant = Color(0xff2332b3)
val OnPrimaryColor = Color(0xffd0d0d0)
val BackgroundColor = Color(0xff2a2a2a)
val OnBackgroundColor = Color(0xffd0d0d0)
val SurfaceColor = Color(0xff3c3f41)
val OnSurfaceColor = Color(0xffd0d0d0)

val AppDarkColors = darkColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryColorVariant,
    secondary = PrimaryColor,
    secondaryVariant = PrimaryColorVariant,
    onPrimary = OnPrimaryColor,
    background = BackgroundColor,
    onBackground = OnBackgroundColor,
    surface = SurfaceColor,
    onSurface = OnSurfaceColor
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = AppDarkColors
    ) {
        Box(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.background)
        ) {
            content()
        }
    }
}