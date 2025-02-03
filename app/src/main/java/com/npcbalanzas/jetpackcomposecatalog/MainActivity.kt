package com.npcbalanzas.jetpackcomposecatalog

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                MyButtonExample()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeCatalogTheme {
        MyButtonExample()
    }
}

@Composable
fun MyButtonExample(){
    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Button(onClick = {

        }, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.White
        ), border = BorderStroke(1.dp,Color.Green)
        ) {
            Text(text = "Hola")
        }
    }
}

@Composable
fun MyTextFieldOutlined(){
    var myText by remember { mutableStateOf("") }
    OutlinedTextField(value = myText, onValueChange = {myText = it}, modifier = Modifier.padding(all = 4.dp),
        label = { Text( text = "Holita", textAlign = TextAlign.Center) },
        colors = TextFieldDefaults.colors(focusedPlaceholderColor = Color.Magenta,
            unfocusedPlaceholderColor = Color.Blue))
}

@Composable
fun MyTextFieldAdvance(){
    var myText by remember { mutableStateOf("") }
    TextField(value = myText,
        onValueChange = {
            myText = if(it.contains("a")){
                it.replace("a","")
            }else{
                it
            }
                        },
        label = {
        Text("Introduce tu nombre")
    })

}

@Composable
fun MyTextField(name:String, onValueChanged:(String)-> Unit){
    TextField(value = name, onValueChange = onValueChanged)
}

@Composable
fun MyText(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Bold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(text = "Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text(text = "Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.Underline))
        Text(text = "Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.combine(
            listOf(TextDecoration.Underline, TextDecoration.LineThrough)
        )))
        Text(text = "Esto es un ejemplo", fontSize = 30.sp)
    }
}