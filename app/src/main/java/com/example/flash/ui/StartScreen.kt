package com.example.flash.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import com.example.flash.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flash.data.DataSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun StartScreen(modifier: Modifier = Modifier,flashViewModel: FlashViewModel,onCategoryClicked:()-> Unit) {

    val flashUiState by flashViewModel.uiState.collectAsState()

    var context= LocalContext.current
    Column(modifier=modifier.fillMaxSize()) {

        LazyVerticalGrid(
            columns = GridCells.Adaptive(128.dp),
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            
            items(DataSource.dataLoad()) {
                ComponentScreen(
                    name = it.name, image = it.imageResource, context = context,
                    flashViewModel = flashViewModel,
                    onCategoryClicked =  {onCategoryClicked()}
                )
            }
        }
    }
}

@Composable
fun ComponentScreen(modifier: Modifier = Modifier,name: Int,image: Int,context: Context,flashViewModel: FlashViewModel,onCategoryClicked: () -> Unit) {
    val categoryName=stringResource(id=name)

    Card(modifier = Modifier.clickable{
        flashViewModel.updateStatus(categoryName)
        Toast.makeText(context, flashViewModel.uiState.value.selectedCategory, Toast.LENGTH_SHORT).show()
        onCategoryClicked()
    }) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(
                modifier = Modifier.width(150.dp),
                textAlign = TextAlign.Center,
                text = categoryName,
                fontSize = 14.sp
            )
            Image(painter = painterResource(id = image),
                contentDescription = "Image",
                modifier = Modifier.size(150.dp))
        }
    }
}