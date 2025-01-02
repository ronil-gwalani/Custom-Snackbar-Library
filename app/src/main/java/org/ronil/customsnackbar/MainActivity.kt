package org.ronil.customsnackbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.ronil.customsnackbar.ui.theme.CustomSnackbarLibraryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomSnackbarLibraryTheme {
//                ExampleUsage()
            }

        }
    }
}


//@Composable
//fun ExampleUsage() {
//    val dialogState = rememberSnackBarState()
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
//    ) {
//        Button(onClick = { dialogState.showPositiveSnackBar("This is the Positive Snack-bar") }) {
//            Text("Show Positive SnackBar")
//        }
//        Button(onClick = { dialogState.showNegativeSnackBar("This is the Negative Snack-bar") }) {
//            Text("Show Negative SnackBar")
//        }
//    }
//}


