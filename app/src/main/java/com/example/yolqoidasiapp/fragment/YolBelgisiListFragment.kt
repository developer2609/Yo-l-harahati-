package com.example.yolqoidasiapp.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.yolqoidasiapp.R
import com.example.yolqoidasiapp.adapter.PagerAdapter
import com.example.yolqoidasiapp.databinding.FragmentYolBelgisiListBinding
import com.example.yolqoidasiapp.databinding.TabItemBinding
import com.example.yolqoidasiapp.models.Belgi
import com.example.yolqoidasiapp.models.PagerItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
private const val ARG_PARAM1 = "param1"


class YolBelgisiListFragment : Fragment() {
    private val list=ArrayList<PagerItem>()
    private lateinit var pagerAdapter: PagerAdapter
    private lateinit var binding: FragmentYolBelgisiListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        list.add(PagerItem("Ogohlanturuvchi",0))
        list.add(PagerItem("Imtiyozli",1))
        list.add(PagerItem("Ta'qiqlovchi",2))
        list.add(PagerItem("Buyuruvchi",3))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentYolBelgisiListBinding.inflate(layoutInflater)

       binding.infoTab.setOnClickListener {
           findNavController().navigate(R.id.action_yolBelgisiListFragment_to_aboutFragment)
       }


        binding.add.setOnClickListener {
            findNavController().navigate(R.id.action_yolBelgisiListFragment_to_yolBelgisiQoshishFragment)
        }

        binding.myTablayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                 val customView=tab?.customView
//                customView?.findViewById<TextView>(R.id.tab_item)!!.setTextColor(Color.parseColor("#005CA1"))
//
//                customView.findViewById<TextView>(R.id.tab_item_tv)!!.setBackgroundColor(Color.WHITE)

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val tabItem=TabItemBinding.inflate(layoutInflater)
                tabItem.tabTxtItem.background=
                    resources.getDrawable(R.drawable.untab_fon)
                tabItem.tabTxtItem.setTextColor(resources.getColor(R.color.white))

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })


           pagerAdapter = PagerAdapter(this,list )
         binding.viewpager.adapter=pagerAdapter

        TabLayoutMediator(binding.myTablayout,binding.viewpager){tab,position->
            val tabItem=TabItemBinding.inflate(layoutInflater)
               tabItem.tabTxtItem.text=list[position].type

               tab.customView=tabItem.root



        }.attach()

        return binding.root


    }



    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            InfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }






    }



