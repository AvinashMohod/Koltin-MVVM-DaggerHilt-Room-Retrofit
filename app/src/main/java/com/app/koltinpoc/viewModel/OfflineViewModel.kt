package com.app.koltinpoc.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.koltinpoc.di.DBRepository
import com.app.koltinpoc.model.Article
import com.app.koltinpoc.model.NewResponse
import com.app.koltinpoc.utils.DataHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OfflineViewModel @Inject constructor(private val dbRepository: DBRepository) : ViewModel() {

    private val _topHeadlines = MutableLiveData<DataHandler<List<Article>>>()
    val topHeadlines: LiveData<DataHandler<List<Article>>> = _topHeadlines

    fun getArticlesFromDB() {

        _topHeadlines.postValue(DataHandler.LOADING())
        val data = dbRepository.getAllArticles().value
        if (data != null) {
            _topHeadlines.postValue(DataHandler.SUCCESS(data))
        } else {
            _topHeadlines.postValue(
                DataHandler.ERROR(
                    null,
                    "SOME THING WRONG IN FETCHING DATA FROM DB"
                )
            )
        }

    }

    fun insertArticle(article: Article) {
        viewModelScope.launch {

            dbRepository.insertArticle(article)
        }
    }

    fun deleteArticle(article: Article) {
        viewModelScope.launch {

            dbRepository.delete(article)
        }
    }

}