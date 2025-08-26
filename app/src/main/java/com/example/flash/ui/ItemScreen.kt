package com.example.flash.ui

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flash.data.DataSource
import com.example.flash.R

@Composable
fun ItemScreen(modifier: Modifier = Modifier, flashViewModel: FlashViewModel) {
    val flashUiState by flashViewModel.uiState.collectAsState()
//    Text(text = flashUiState.selectedCategory)
    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(DataSource.itemLoad()) {
            ItemCard(it.stringResourceId,it.itemQuantityId,it.itemPrice,it.imageResource)
        }
    }
}

@Composable
fun ItemCard( stringResourceId:Int,
              itemQuantityId: String="1kg",
              itemPrice:Int=200,
               imageResource: Int
){
    var context= LocalContext.current
    Column(modifier = Modifier.width(150.dp)){
        Card(
            modifier = Modifier.background(Color.White)
        ) {
            Box {
                Image(
                    painter = painterResource(id=imageResource), contentDescription = "Hello",
                    modifier = Modifier.fillMaxWidth().height(110.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.End
                ) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color(244,67,54,255)
                        )
                    ) {
                        Text(text = "25% off",
                            color = Color.White,
                            fontSize = 8.sp,
                            modifier = Modifier.padding(
                                horizontal = 5.dp,
                                vertical=2.dp
                            ))

                    }
                }
            }
            Text(
                text = stringResource(id=stringResourceId),
                modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                fontSize = 12.sp,
                textAlign = TextAlign.Left
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp)
            ){
                Column {
                    Text(text = itemPrice.toString(),
                        fontSize = 6.sp,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.LineThrough)

                    Text(text ="Rs. ${itemPrice * 3 / 4}",
                        fontSize = 9.sp,
                        textAlign = TextAlign.Center,
                        color = Color(255,116,105,255))
                }
                Text(text =itemQuantityId,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize=15.sp,
                    textAlign = TextAlign.End,
                    maxLines = 1)
            }
            Card(modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
                .clickable{
                    Toast.makeText(context,"Clicked", Toast.LENGTH_SHORT).show()
                },
                colors = CardDefaults.cardColors(
                    containerColor = Color(108,194,111,255)
                )) {
                Row(modifier = Modifier.fillMaxWidth()
                    .height(24.dp)
                    .padding( 5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically){
                    Text(text="Add To Cart",
                        fontSize = 11.sp,
                        color = Color.White)
                }
            }
//            Button(
//                onClick = {
//
//                },
//                modifier = Modifier.fillMaxWidth(),
//                colors = ButtonDefaults.buttonColors(Color.Green)
//            ) {
//                Text(text = "Add to Cart")
//            }
        }
    }
}