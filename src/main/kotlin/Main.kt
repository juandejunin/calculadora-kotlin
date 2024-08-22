import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

@Composable
fun CalculatorApp() {
    var display by remember { mutableStateOf("0") }
    var operation by remember { mutableStateOf<Char?>(null) }
    var firstOperand by remember { mutableStateOf(0.0) }
    var secondOperand by remember { mutableStateOf(0.0) }
    var resetDisplay by remember { mutableStateOf(false) }

    fun onDigitPress(digit: Int) {
        if (resetDisplay) {
            display = digit.toString()
            resetDisplay = false
        } else {
            display = if (display == "0") digit.toString() else display + digit
        }
    }

    fun onOperationPress(op: Char) {
        firstOperand = display.toDouble()
        operation = op
        resetDisplay = true
    }

    fun onEqualPress() {
        secondOperand = display.toDouble()
        display = when (operation) {
            '+' -> (firstOperand + secondOperand).toString()
            '-' -> (firstOperand - secondOperand).toString()
            '*' -> (firstOperand * secondOperand).toString()
            '/' -> if (secondOperand != 0.0) (firstOperand / secondOperand).toString() else "Error"
            else -> display
        }
        resetDisplay = true
        operation = null
    }

    fun onClearPress() {
        display = "0"
        firstOperand = 0.0
        secondOperand = 0.0
        operation = null
        resetDisplay = false
    }

    fun onBackspacePress() {
        if (display.isNotEmpty() && display != "0") {
            display = display.dropLast(1).ifEmpty { "0" }
        }
    }

    fun onPercentPress() {
        display = (display.toDouble() / 100).toString()
    }

    fun onNegatePress() {
        display = (display.toDouble() * -1).toString()
    }

    fun onDecimalPress() {
        if (!display.contains(".")) {
            display += "."
        }
    }

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Display area
            Text(
                text = display,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                style = MaterialTheme.typography.h4
            )

            // Box to wrap the buttons
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 0.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // First Column
                    Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = { onClearPress() }, modifier = Modifier.fillMaxWidth()) { Text("AC") }
                        Button(onClick = { onDigitPress(7) }, modifier = Modifier.fillMaxWidth()) { Text("7") }
                        Button(onClick = { onDigitPress(4) }, modifier = Modifier.fillMaxWidth()) { Text("4") }
                        Button(onClick = { onDigitPress(1) }, modifier = Modifier.fillMaxWidth()) { Text("1") }

                        Button(onClick = { onPercentPress() }, modifier = Modifier.fillMaxWidth()) { Text("%") }


                    }
                    // Second Column
                    Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = { onBackspacePress() }, modifier = Modifier.fillMaxWidth()) { Text("<") }
                        Button(onClick = { onDigitPress(8) }, modifier = Modifier.fillMaxWidth()) { Text("8") }
                        Button(onClick = { onDigitPress(5) }, modifier = Modifier.fillMaxWidth()) { Text("5") }
                        Button(onClick = { onDigitPress(2) }, modifier = Modifier.fillMaxWidth()) { Text("2") }
                        Button(onClick = { onDigitPress(0) }, modifier = Modifier.fillMaxWidth()) { Text("0") }

                    }
                    // Third Column
                    Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = { onNegatePress() }, modifier = Modifier.fillMaxWidth()) { Text("+/-") }
                        Button(onClick = { onDigitPress(9) }, modifier = Modifier.fillMaxWidth()) { Text("9") }
                        Button(onClick = { onDigitPress(6) }, modifier = Modifier.fillMaxWidth()) { Text("6") }
                        Button(onClick = { onDigitPress(3) }, modifier = Modifier.fillMaxWidth()) { Text("3") }
                        Button(onClick = { onDecimalPress() }, modifier = Modifier.fillMaxWidth()) { Text(".") }

                    }
                    // Fourth Column
                    Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = { onOperationPress('/') }, modifier = Modifier.fillMaxWidth()) { Text("/") }
                        Button(onClick = { onOperationPress('*') }, modifier = Modifier.fillMaxWidth()) { Text("*") }
                        Button(onClick = { onOperationPress('-') }, modifier = Modifier.fillMaxWidth()) { Text("-") }
                        Button(onClick = { onOperationPress('+') }, modifier = Modifier.fillMaxWidth()) { Text("+") }
                        Button(onClick = { onEqualPress() }, modifier = Modifier.fillMaxWidth()) { Text("=") }
                    }
                }
            }
        }
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Calculator",
        state = WindowState(width = 300.dp, height = 500.dp) // Ajusta el tamaño de la ventana aquí
    ) {
        CalculatorApp()
    }
}
