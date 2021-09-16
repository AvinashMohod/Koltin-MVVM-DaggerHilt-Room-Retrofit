package com.app.koltinpoc.di

import com.app.koltinpoc.api.TopHeadlinesApi
import javax.inject.Inject

class NetworkRepository @Inject constructor(
   val topHeadlinesApi: TopHeadlinesApi
){

    suspend fun getTopHeadlines(country:String,apiKey:String) {
        topHeadlinesApi.getTopHeadlines(country,apiKey)
    }

}