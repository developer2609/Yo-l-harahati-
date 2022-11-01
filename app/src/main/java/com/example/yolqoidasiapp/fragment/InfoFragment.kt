package com.example.yolqoidasiapp.fragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.yolqoidasiapp.R
import com.example.yolqoidasiapp.databinding.FragmentInfoBinding
import com.example.yolqoidasiapp.models.Belgi


class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding
    private lateinit var belgiInfo:Belgi

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding=FragmentInfoBinding.inflate(layoutInflater)
        belgiInfo=arguments?.getSerializable("belgi") as Belgi
        binding.textName.text=belgiInfo.name
        binding.textAbout.text=belgiInfo.matn
        binding.imageGet.setImageURI(Uri.parse(belgiInfo.imagePath))

        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }


        return binding.root

    }


}