package com.example.yolqoidasiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.yolqoidasiapp.R
import com.example.yolqoidasiapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater)

           binding.root.setOnClickListener {
               findNavController().navigate(R.id.action_homeFragment2_to_yolBelgisiListFragment)
           }




        return binding.root
    }


}