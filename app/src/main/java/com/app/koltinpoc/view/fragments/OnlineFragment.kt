package com.app.koltinpoc.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.koltinpoc.R
import com.app.koltinpoc.databinding.FragmentOnlineBinding
import com.app.koltinpoc.utils.DataHandler
import com.app.koltinpoc.view.adapter.NewsAdapter
import com.app.koltinpoc.viewModel.OnlineViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnlineFragment : Fragment(R.layout.fragment_online) {

    private val TAG = "OnlineFragment"
    lateinit var binding: FragmentOnlineBinding

    @Inject
    lateinit var newsAdapter: NewsAdapter

    val viewModel: OnlineViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOnlineBinding.bind(view)
        init()

        viewModel.topHeadlines.observe(viewLifecycleOwner, { dataHandler ->

            when (dataHandler) {
                is DataHandler.SUCCESS -> {

                    binding.progressBar.visibility = View.GONE

                    newsAdapter.differ.submitList(dataHandler.data?.articles)

                }
                is DataHandler.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d(TAG, "onViewCreated: ERROR " + dataHandler.message)
                }
                is DataHandler.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Log.d(TAG, "onViewCreated: LOADING..")
                }
            }

        })
        viewModel.getTopHeadlines()


    }

    fun init() {
        binding.recyclerView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}