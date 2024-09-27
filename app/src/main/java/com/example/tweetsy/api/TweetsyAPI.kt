package com.example.tweetsy.api

import com.example.tweetsy.model.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyAPI {

 @GET("/v3/b/66f5687ce41b4d34e43839b0?meta=false")
 suspend fun getTweets(@Header("X-JSON-path") category : String) : Response<List<TweetListItem>>

 @GET("/v3/b/66f5687ce41b4d34e43839b0?meta=false")
 @Headers("X-JSON-path:tweets..category")
 suspend fun  getCategories() : Response<List<String>>
}