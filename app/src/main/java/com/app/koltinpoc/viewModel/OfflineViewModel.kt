package com.app.koltinpoc.viewModel

import androidx.lifecycle.*
import com.app.koltinpoc.di.DBRepository
import com.app.koltinpoc.di.Transformer
import com.app.koltinpoc.model.Article
import com.app.koltinpoc.model.NewResponse
import com.app.koltinpoc.utils.DataHandler
import com.app.koltinpoc.utils.DataHandler.LOADING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OfflineViewModel @Inject constructor(private val dbRepository: DBRepository) : ViewModel() {


    /*Transformation converts the LiveData article entity to LiveData article model class
    * and LiveData Datahandler  is observed from fragment
    */
    var article = Transformations.map(dbRepository.getAllArticles()) { list ->

        val temp = list.map {
            Transformer.convertArticleEntityToArticleModel(it)
        }
        if (temp.isNullOrEmpty()) {
            DataHandler.ERROR(null, "LIST IS EMPTY OR NULL")
        } else {
            DataHandler.SUCCESS(temp)
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

    fun getAllArticles() = dbRepository.getAllArticles()


}