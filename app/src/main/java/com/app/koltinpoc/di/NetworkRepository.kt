package com.app.koltinpoc.di

import com.app.koltinpoc.api.TopHeadlinesApi
import com.app.koltinpoc.model.NewResponse
import retrofit2.Response
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    val topHeadlinesApi: TopHeadlinesApi
) {

    suspend fun getTopHeadlines(country: String, apiKey: String): Response<NewResponse> {
        return topHeadlinesApi.getTopHeadlines(country, apiKey)
    }

}