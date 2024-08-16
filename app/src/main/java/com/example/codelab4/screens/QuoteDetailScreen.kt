package com.example.codelab4.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.codelab4.DataManager
import com.example.codelab4.models.Quote

//@Preview
@Composable
fun QuoteDetail(modifier: Modifier = Modifier, quote: Quote) {
    BackHandler {
        DataManager.switchPages(null)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3)
                    )
                )
            )
    ){
        Card(
            modifier = Modifier.padding(32.dp) ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    //.align(Alignment.Center)
                    .padding(16.dp,24.dp)
            ){
                Image(
                    imageVector = Icons.Filled.FormatQuote,
//                        colorFilter = ColorFilter.tint(Color.White),
//                        alignment = Alignment.TopStart,
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .rotate(180F)
                    //.background(Color.Black)
                )
                Text(
                    text = quote.quote,
                    fontFamily = FontFamily.SansSerif,
                    style = MaterialTheme.typography.labelLarge
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}