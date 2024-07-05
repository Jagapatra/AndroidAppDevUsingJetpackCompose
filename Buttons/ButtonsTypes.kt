package com.example.sampleapplication1

import android.os.Bundle
import android.text.Layout
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleapplication1.ui.theme.SampleApplication1Theme

class MainActivity : ComponentActivity() {
    public override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            SampleApplication1Theme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .background(Color.LightGray),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RectangleShape
                    )
                    {

                        Text(text = "Button1(Button)")
                    }

                    ElevatedButton(
                        onClick = { /*TODO*/ },
                        shape = CircleShape
                    )
                    {
                        Text(text = "Button2(ElevatedButton)")
                    }

                    Text(text = "(FilledIconButton)")
                    FilledIconButton(
                        onClick = { /*TODO*/ },
                        shape = RectangleShape,
                        colors = IconButtonColors(contentColor = Color.White, containerColor = Color.Black, disabledContainerColor = Color.Cyan, disabledContentColor = Color.White)
                    )
                    {
                        Text(text = "Button3")
                    }

                    TextButton(
                        onClick = { /*TODO*/ },
                        shape = RectangleShape
                    ) {
                        Text("Button4(TextButton)")
                    }

                    ExtendedFloatingActionButton(
                        onClick = { /*TODO*/ },
                        shape = RectangleShape
                    )
                    {
                        Text("Button5(ExtendedFloatingActionButton)")
                    }

                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        shape = RectangleShape
                    )
                    {
                        Text(text = "Button6(FloatingActionButton)")
                    }

                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        shape = RectangleShape
                    )
                    {
                        Text("Button7(OutlinedButton)")
                    }
                }
            }
        }
    }
}


