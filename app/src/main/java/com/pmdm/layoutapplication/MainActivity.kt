package com.pmdm.layoutapplication

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.pmdm.layoutapplication.ui.theme.LayoutApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.width(120.dp) ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(
            text = "blabla",
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            modifier = Modifier
                .background(androidx.compose.ui.graphics.Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LayoutApplicationTheme {
        Greeting("Android", Modifier.height(100.dp))//Este código está desarrollado bajo la licencia (GPL DE KARIM).

    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    LayoutApplicationTheme {
        //Este código está desarrollado bajo la licencia (GPL DE KARIM).
        ConstraintExample()
    }
}

@Preview(showBackground = true)
@Composable
fun MyNewPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text (text = "Holaaa",
            modifier = Modifier.background(androidx.compose.ui.graphics.Color.Green))
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterEnd) {
        Box(modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .background(androidx.compose.ui.graphics.Color.Cyan)
            .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center) {
            Text("Esto es un EJEMPLO")
        }
    }
}


@Composable
fun ConstraintExample(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxYellow, boxMagenta, boxGreen, boxOrange, boxGrey, boxPink, boxPurple) = createRefs()
        Box(modifier = Modifier.size(75.dp).background(androidx.compose.ui.graphics.Color.Black).constrainAs(boxRed){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        })
        Box(modifier = Modifier.size(75.dp).background(androidx.compose.ui.graphics.Color.Cyan).constrainAs(boxBlue){
            bottom.linkTo(boxRed.top)
            end.linkTo(boxRed.start)
        })
        Box(modifier = Modifier.size(75.dp).background(androidx.compose.ui.graphics.Color.Cyan).constrainAs(boxYellow){
            top.linkTo(boxRed.bottom)
            start.linkTo(boxRed.end)
        })
        Box(modifier = Modifier.size(75.dp).background(androidx.compose.ui.graphics.Color.Cyan).constrainAs(boxMagenta){
            end.linkTo(boxRed.start)
            top.linkTo(boxRed.bottom)
        })
        Box(modifier = Modifier.size(75.dp).background(androidx.compose.ui.graphics.Color.Cyan).constrainAs(boxGreen){
            start.linkTo(boxRed.end)
            bottom.linkTo(boxRed.top)
        })
        Box(modifier = Modifier.size(75.dp).background(androidx.compose.ui.graphics.Color.Magenta).constrainAs(boxOrange){
            start.linkTo(boxBlue.end)
            bottom.linkTo(boxBlue.top)
        })
        Box(modifier = Modifier.size(75.dp).background(androidx.compose.ui.graphics.Color.Magenta).constrainAs(boxGrey){
            end.linkTo(boxMagenta.start)
            top.linkTo(boxMagenta.bottom)
        })
        Box(modifier = Modifier.size(75.dp).background(androidx.compose.ui.graphics.Color.Magenta).constrainAs(boxPink){
            start.linkTo(boxMagenta.end)
            top.linkTo(boxMagenta.bottom)
        })
        Box(modifier = Modifier.size(75.dp).background(androidx.compose.ui.graphics.Color.Magenta).constrainAs(boxPurple){
            start.linkTo(boxYellow.end)
            top.linkTo(boxMagenta.bottom)
        })
    }
}

//Este código está desarrollado bajo la licencia (GPL DE KARIM).


