package com.kodex.myfacebook.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.kodex.myfacebook.R



private val LightColorPalette = lightColors(
    primary = BrandBlue,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = BackgroundGray

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MyFacebookTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
   content: @Composable () -> Unit,
) {
    val colors = LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}