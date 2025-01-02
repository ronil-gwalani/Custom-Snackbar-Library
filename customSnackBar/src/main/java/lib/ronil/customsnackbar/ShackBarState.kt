package lib.ronil.customsnackbar

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

@Stable
class ShackBarState {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private val duration = 2500L
    var isVisible by mutableStateOf(false)
        private set

    var message: String by mutableStateOf("")

    var snackBarType by mutableStateOf(ShackBarType.POSITIVE)
        private set

    private fun show(message: String) {
        this.message = message
        isVisible = true
    }

    fun dismiss() {
        isVisible = false
    }

    fun showNegativeSnackBar(message: String) {
        snackBarType = ShackBarType.NEGATIVE
        show(message)
        coroutineScope.launch {
            delay(duration)
            dismiss()
        }
    }

    fun showPositiveSnackBar(message: String) {
        snackBarType = ShackBarType.POSITIVE
        show(message)
        coroutineScope.launch {
            delay(duration)
            dismiss()
        }
    }


}