package com.app.koltinpoc.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.koltinpoc.model.Article
import kotlinx.coroutines.launch

class OnlineViewModel :ViewModel() {

    private val _article = MutableLiveData<Article>()
    val article : LiveData<Article> = _article

    fun getTopHeadlines(){
        viewModelScope.launch {

        }
    }
}