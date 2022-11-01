package com.example.yolqoidasiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.yolqoidasiapp.R
import com.example.yolqoidasiapp.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAboutBinding.inflate(layoutInflater)

        binding.imageHome.setOnClickListener {
            findNavController().navigate(R.id.yolBelgisiListFragment)
        }


        return binding.root
    }


}