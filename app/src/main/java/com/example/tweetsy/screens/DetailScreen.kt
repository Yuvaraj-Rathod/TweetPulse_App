package com.example.tweetsy.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsy.model.TweetListItem
import com.example.tweetsy.viewmodels.DetailViewModel

@Composable
fun DetailScreen(){
    val detailViewModel: DetailViewModel = viewModel()
    val tweets: State<List<TweetListItem>> = detailViewModel.tweets.collectAsState()
    
   LazyColumn {
       items(tweets.value){
           TweetListItem(tweet = it.text)
       }
   }
}

@Composable
fun TweetListItem(tweet : String) {
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(),
        border = BorderStroke(1.dp, Color(0XFFCCCCCC)),
        elevation = CardDefaults.elevatedCardElevation(10.dp) 
    ) {
        Text(text = tweet,
            modifier = Modifier
                .padding(16.dp),
            style = MaterialTheme.typography.bodySmall)
    }
}