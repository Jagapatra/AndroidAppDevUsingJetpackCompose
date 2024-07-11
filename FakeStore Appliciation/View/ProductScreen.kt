package com.example.sampleapplication1.Views

import Product
import ProductViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.TaskAlt
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter

@Composable
fun ProductScreen(productVM:ProductViewModel)
{
    val products by productVM.products.observeAsState(emptyList())
    LazyColumn {
        items(products){
            ProductItem(product = it)
        }
    }
}

@Composable
fun ProductItem(product:Product)
{
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        ),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .clickable { println("Product ${product.id} clicked")}
            //.background(color = Color.LightGray)
        ,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onTertiary,
        )
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                //.verticalScroll(rememberScrollState())
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Center
        ){
            Row(
                modifier = Modifier,
                //horizontalArrangement = Arrangement.Start
            ) {
                Icon(Icons.Outlined.Bookmark, contentDescription = null)
                Spacer(modifier =Modifier.size(40.dp))
                AsyncImage(
                    model = product.image,
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                        .padding(1.dp),
                    alignment = Alignment.Center,
                )
                //ImageWithTransparentBackground(product.image)
                Spacer(modifier =Modifier.size(25.dp))
                Column (
                    modifier = Modifier,
                    horizontalAlignment = Alignment.End
                ){
                    Row {
                        Text(text = "${product.rating.rate}\n",textAlign = TextAlign.End, fontSize = 19.sp)
                        Icon(Icons.Outlined.TaskAlt, contentDescription = null)
                    }
                    Text(text = "${product.rating.count- product.rating.count%10}+\nratings",textAlign = TextAlign.End, fontSize = 15.sp)
                }
            }

            Spacer(modifier =Modifier.size(18.dp))
            Text(text = product.title,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Normal,
                //fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally))

            Spacer(modifier =Modifier.size(16.dp))
            Row {
                Spacer(modifier =Modifier.size(50.dp))
                Text(text = "Price: Rs ${product.price} only\n", textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Black,
                    //modifier = Modifier(Alignment.CenterHorizontally)
                )
                Spacer(modifier =Modifier.size(40.dp))
                Icon(Icons.Filled.Share, contentDescription = null,Modifier.size(25.dp))

            }

        }
    }
}
    /*@Composable
    fun ImageWithTransparentBackground(imageUrl: String) {
        val imagePainter = rememberAsyncImagePainter(model = imageUrl)

        Image(
            modifier = Modifier
                .size(80.dp)
                .border(2.dp, Color.Red)
                .graphicsLayer {
                    compositingStrategy = CompositingStrategy.Offscreen
                }
                .drawWithContent {
                    val radius = 6.dp.toPx()
                    val badgeRadius = 5.dp.toPx()
                    val center = Offset(size.width - radius, size.height - radius)

                    // Destination (draw the original content)
                    drawContent()

                    // Source (draw a transparent circle to remove part of the image)
                    drawCircle(
                        color = Color.Transparent,
                        radius = radius,
                        center = center,
                        blendMode = BlendMode.Clear
                    )

                    // Optionally, draw a red circle (you can customize this)
                    drawCircle(
                        color = Color.Red,
                        radius = badgeRadius,
                        center = center
                    )
                },
            painter = imagePainter,
            contentDescription = null


        )
    }*/


