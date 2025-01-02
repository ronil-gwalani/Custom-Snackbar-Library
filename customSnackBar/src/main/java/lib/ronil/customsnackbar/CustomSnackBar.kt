package lib.ronil.customsnackbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex


@Composable
fun rememberSnackBarState(): ShackBarState {
    val state = remember { ShackBarState() }
    // Automatically render the dialog when it becomes visible
    AnimatedVisibility(
        visible = state.isVisible,
        enter = slideInVertically(initialOffsetY = { -it }) + fadeIn(),
        exit = slideOutVertically(targetOffsetY = { -it }) + fadeOut(),
        modifier = Modifier
            .fillMaxWidth()
            .zIndex(Float.MAX_VALUE) // Ensure it stays on top
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp, vertical = 35.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(if (state.snackBarType == ShackBarType.POSITIVE) Color.Green else Color.Red)
                .padding(17.dp)
                .zIndex(Float.MAX_VALUE) // Ensure it stays on top
        ) {

            Text(
                text = state.message,
                style = TextStyle(
                    color = if (state.snackBarType == ShackBarType.POSITIVE) Color.Black else Color.White,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontWeight = MaterialTheme.typography.bodyLarge.fontWeight
                ),
                modifier = Modifier
            )


        }
    }

    return state
}

