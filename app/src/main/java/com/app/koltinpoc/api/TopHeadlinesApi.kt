package com.app.koltinpoc.api

import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlinesApi {

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country:String,
        @Query("apiKey") apiKey:String,
    )
}