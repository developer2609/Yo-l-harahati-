package com.example.yolqoidasiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yolqoidasiapp.R
import com.example.yolqoidasiapp.adapter.RvAdapter
import com.example.yolqoidasiapp.databinding.FragmentLikeBinding
import com.example.yolqoidasiapp.db.DbHelper
import com.example.yolqoidasiapp.models.Belgi

class LikeFragment : Fragment() {
    private lateinit var binding: FragmentLikeBinding
    private lateinit var dbHelper: DbHelper
    private lateinit var rvAdapter: RvAdapter
    private lateinit var likelist:ArrayList<Belgi>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLikeBinding.inflate(layoutInflater)

           likelist=ArrayList()



        




        return  binding.root
    }

}