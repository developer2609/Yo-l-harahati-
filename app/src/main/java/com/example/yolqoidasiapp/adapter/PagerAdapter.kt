package com.example.yolqoidasiapp.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.yolqoidasiapp.fragment.ViewPagerItemFragment
import com.example.yolqoidasiapp.fragment.YolBelgisiListFragment
import com.example.yolqoidasiapp.models.Belgi
import com.example.yolqoidasiapp.models.PagerItem


class PagerAdapter(fragment: Fragment,var list:ArrayList<PagerItem>): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int =list.size

    override fun createFragment(position: Int): Fragment {
        return  ViewPagerItemFragment.newInstance(list[position].typeInt)
    }
}