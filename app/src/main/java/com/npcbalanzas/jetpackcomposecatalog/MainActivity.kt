package com.npcbalanzas.jetpackcomposecatalog

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.npcbalanzas.jetpackcomposecatalog.ui.theme.JetPackComposeCatalogTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeCatalogTheme {
                MyProgressAdvance()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeCatalogTheme {
        MyProgressAdvance()
    }
}

@Composable
fun MyProgressAdvance(){
    var progressStatus by rememberSaveable { mutableFloatStateOf(0f) }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        CircularProgressIndicator(
            progress = { progressStatus },
            color = Color.Red
        )

        Row(modifier = Modifier.fillMaxWidth().padding(20.dp), Arrangement.Center) {
            Button(onClick = {
                if(progressStatus < 1){
                    progressStatus += 0.1f
                }
            }) {
                Text("Incrementar")
            }

            Button(onClick = {
                if(progressStatus > 0){
                    progressStatus -= 0.1f
                }
            }) {
                Text("Reducir")
            }
        }
    }
}

@Composable
fun MyProgress(){
<<<<<<< HEAD
    var showLoading by rememberSaveable { mutableStateOf(false) }
=======

    var showLoading by rememberSaveable { mutableStateOf(false) }

>>>>>>> f65d4c3a67736e26718bb79de247a50e62155aef
    Column(
        modifier = Modifier.padding(24.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        if(showLoading){
            CircularProgressIndicator(color = Color.Red,
                strokeWidth = 5.dp)

            LinearProgressIndicator(color = Color.Red,
                trackColor = Color.Green,

                modifier = Modifier.padding(top = 32.dp))
        }
<<<<<<< HEAD

        Button(onClick = {
            showLoading = !showLoading;
        }) {
            Text(text = "Cargar perfil")
        }
=======
>>>>>>> f65d4c3a67736e26718bb79de247a50e62155aef
    }
}

@Composable
fun MyIcon(){
    Icon(imageVector = Icons.Rounded.Star,
        contentDescription = "CC",
        tint = Color.Green)
}

@Composable
fun MyImageAdvance(){
    Image(
        modifier = Modifier.clip(shape = CircleShape).border(5.dp,Color.Red, shape = CircleShape),
        contentDescription = "Ejercicio",
        painter = painterResource(id = R.drawable.ic_launcher_background)
    )
}

@Composable
fun MyImage() {

}

@Composable
fun MyButtonExample() {

    var enabled by rememberSaveable { mutableStateOf(true) };

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(colors = ButtonDefaults.buttonColors(
            containerColor = Color.Magenta,
            contentColor = Color.White
        ), enabled = enabled,
            border = BorderStroke(1.dp, Color.White),
            onClick = {
                enabled = false
            }) {
            Text(text = "Hola")
        }

        OutlinedButton(
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color.Red,
                contentColor = Color.Black,
                containerColor = Color.Magenta
            ),
            enabled = enabled, modifier = Modifier.padding(top = 8.dp),
            onClick = {

            },
        ) {
            Text(text = "Hola")
        }

        TextButton(onClick = {}) {
            Text(text = "Hola")
        }
    }
}

@Composable
fun MyTextFieldOutlined() {
    var myText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = myText, onValueChange = { myText = it }, modifier = Modifier.padding(all = 4.dp),
        label = { Text(text = "Holita", textAlign = TextAlign.Center) },
        colors = TextFieldDefaults.colors(
            focusedPlaceholderColor = Color.Magenta,
            unfocusedPlaceholderColor = Color.Blue
        )
    )
}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }
    TextField(value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        },
        label = {
            Text("Introduce tu nombre")
        })

}

@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {
    TextField(value = name, onValueChange = onValueChanged)
}

@Composable
fun MyText() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Bold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto es un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough)
                )
            )
        )
        Text(text = "Esto es un ejemplo", fontSize = 30.sp)
    }
}