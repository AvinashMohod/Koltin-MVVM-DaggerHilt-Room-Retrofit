package com.app.koltinpoc.view.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.app.koltinpoc.R
import com.app.koltinpoc.databinding.FragmentArticleDetailsBinding
import com.app.koltinpoc.viewModel.OfflineViewModel
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class ArticleDetailsFragment : Fragment(R.layout.fragment_article_details) {

    val viewModel: OfflineViewModel by viewModels()

    private lateinit var binding: FragmentArticleDetailsBinding
    val args: ArticleDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val article = args.articleData
        binding = FragmentArticleDetailsBinding.bind(view)
        binding.webview.apply {
            webChromeClient = WebChromeClient()
            article?.let { loadUrl(it.url) }
        }

        binding.fab.setOnClickListener {
            if (article != null) {
                viewModel.insertArticle(article)
            }
            Snackbar.make(binding.root, "Article Saved ", Snackbar.LENGTH_LONG).show()
        }

    }
}