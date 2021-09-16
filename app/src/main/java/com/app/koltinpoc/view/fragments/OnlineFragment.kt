package com.app.koltinpoc.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.app.koltinpoc.R
import com.app.koltinpoc.databinding.FragmentOnlineBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnlineFragment :Fragment(R.layout.fragment_online){

    lateinit var binding: FragmentOnlineBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentOnlineBinding.bind(view)

    }
}