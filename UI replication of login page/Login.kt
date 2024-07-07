package com.example.sampleapplication1

import android.graphics.drawable.*
import android.os.Bundle
import android.text.Layout
import android.text.style.BackgroundColorSpan
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ChipColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.*
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleapplication1.ui.theme.SampleApplication1Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            SampleApplication1Theme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                        //.background(Color.LightGray),
                    horizontalAlignment = Alignment.CenterHorizontally ,
                    //verticalArrangement = Arrangement.SpaceAround
                ) {
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 1.5.dp
                        ),
                        modifier = Modifier
                            .size(width = 500.dp, height = 635.dp)
                            .padding(20.dp),
                        colors = CardColors(containerColor = colorResource(id = R.color.Light_Blue),
                            contentColor = Color.Blue, disabledContentColor = Color.Blue, disabledContainerColor = Color.Blue)
                    )
                    {
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(5.dp),
                            //.background(Color.LightGray),
                            horizontalAlignment = Alignment.Start ,
                            //verticalArrangement = Arrangement.SpaceAround
                        ) {
                        Text(
                            text = "Jetpack Compose",
                            modifier = Modifier
                                .padding(horizontal = 50.dp, vertical = 20.dp),
                            color = colorResource(R.color.Blue_563),
                            fontSize = 27.sp,
                            textAlign = TextAlign.Center
                        )
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Jetpack logo",
                            Modifier.padding(horizontal = 115.dp)
                        )
                                Text(
                                    text = "Login",
                                    modifier = Modifier
                                        .padding(horizontal = 20.dp, vertical = 30.dp),
                                    color = colorResource(R.color.Dark_green),
                                    fontSize = 29.sp,
                                    //textAlign = TextAlign.Center
                                )

                                var text by remember { mutableStateOf("") }
                                OutlinedTextField(
                                    value = text,
                                    modifier = Modifier
                                        .padding(horizontal = 20.dp, vertical = 1.dp)
                                        .size(width = 450.dp, height = 50.dp),
                                    onValueChange = { text = it },
                                    label = { Text("Email ID or Mobile Number") }
                                )

                                var text1 by remember { mutableStateOf("") }
                                OutlinedTextField(
                                    value = text1,
                                    modifier = Modifier
                                        .padding(horizontal = 20.dp, vertical = 40.dp)
                                        .size(width = 450.dp, height = 50.dp),
                                    onValueChange = { text1 = it },
                                    label = { Text("Password") },
                                    trailingIcon = {
                                        Icon(
                                            imageVector = Icons.Default.Lock,
                                            contentDescription = null
                                        )
                                    }
                                )
                            TextButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .padding(horizontal = 10.dp)
                                    .align(Alignment.End)
                            ) {
                                Text(
                                    text = "Forgot Password?",
                                    color = colorResource(R.color.Dark_green)
                                )
                            }
                            Button(onClick = { /*TODO*/ }, modifier = Modifier
                                .padding(horizontal = 20.dp)
                                .align(Alignment.Start)
                                .size(width = 120.dp, height = 55.dp),
                                colors = ButtonDefaults.buttonColors(colorResource(R.color.Blue_563)),
                                shape = RoundedCornerShape(50.dp)
                            )
                            {
                                Text(text = "Login")

                            }
                        }
                    }
                    Row {
                        Text(text = "Don't have an account?",
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                                .align(Alignment.CenterVertically)
                        )
                        TextButton(onClick = { /*TODO*/ },
                            modifier = Modifier
                                .align(Alignment.CenterVertically)) {
                            Text(text = "Register",
                                color = colorResource(R.color.Blue_563))
                        }

                    }


                }

            }
        }
    }
}
/*Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                .padding(horizontal = 20.dp),
                                shape = RoundedCornerShape(4.dp),
                                colors = ButtonDefaults.buttonColors(Color.LightGray)
                            )
                            {
                                Text("Email ID or Mobile Number",color=Color.Black, modifier = Modifier
                                    .padding(horizontal = 5.dp),
                                    textAlign = TextAlign.Start)
                            }
                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .padding(horizontal = 20.dp),
                                shape = RoundedCornerShape(4.dp),
                                colors = ButtonDefaults.buttonColors(Color.LightGray)
                            )
                            {
                                Text("Password",color=Color.Black, modifier = Modifier
                                    .padding(horizontal = 5.dp),
                                    textAlign = TextAlign.Start)
                            }*/


