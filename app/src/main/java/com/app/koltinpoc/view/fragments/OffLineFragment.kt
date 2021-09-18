package com.app.koltinpoc.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.app.koltinpoc.R
import com.app.koltinpoc.databinding.FragmentOfflineBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OffLineFragment : Fragment(R.layout.fragment_online) {

    lateinit var binding: FragmentOfflineBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentOfflineBinding.bind(view)
    }

}