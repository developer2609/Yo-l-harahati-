package com.example.yolqoidasiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.whenResumed
import androidx.navigation.fragment.findNavController
import com.example.yolqoidasiapp.R
import com.example.yolqoidasiapp.adapter.RvAdapter
import com.example.yolqoidasiapp.databinding.FragmentViewPagerItemBinding
import com.example.yolqoidasiapp.databinding.ItemLayoutBinding
import com.example.yolqoidasiapp.db.Data
import com.example.yolqoidasiapp.db.DbHelper
import com.example.yolqoidasiapp.models.Belgi

private const val ARG_PARAM1 = "param1"

class ViewPagerItemFragment : Fragment(),RvAdapter.OnItemClik {
    private var param1: Int? = null
    private lateinit var lists: ArrayList<Belgi>
    private lateinit var rvAdapter: RvAdapter
    private lateinit var belgi: Belgi
    private lateinit var binding: FragmentViewPagerItemBinding
    private lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerItemBinding.inflate(layoutInflater)

        dbHelper = DbHelper(binding.root.context)

        lists = ArrayList()


        if (param1 == 0) {
            dbHelper.getQoida().forEach {
                if (it.category == param1) {
                    lists.add(it)
                }
            }
            rvAdapter = RvAdapter(lists,this)
            binding.rv.adapter = rvAdapter
        }
        if (param1 == 1) {
            dbHelper.getQoida().forEach {
                if (it.category == param1) {
                    lists.add(it)
                }
            }
            rvAdapter = RvAdapter(lists,this)
            binding.rv.adapter = rvAdapter
        }
        if (param1 == 2) {
            dbHelper.getQoida().forEach {
                if (it.category == param1) {
                    lists.add(it)
                }
            }
            rvAdapter = RvAdapter(lists,this)
            binding.rv.adapter = rvAdapter
        }
        if (param1 == 3) {
            dbHelper.getQoida().forEach {
                if (it.category == param1) {
                    lists.add(it)
                }
            }
            rvAdapter = RvAdapter(lists,this)
            binding.rv.adapter = rvAdapter
        }






        var item=ItemLayoutBinding.inflate(layoutInflater)
          item.heart.setOnClickListener {
              findNavController().navigate(R.id.action_yolBelgisiListFragment_to_likeFragment)
          }


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
            ViewPagerItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }

    override fun onItemCliked(belgi: Belgi, position: Int) {

        findNavController().navigate(R.id.action_yolBelgisiListFragment_to_infoFragment, bundleOf("belgi" to belgi))

    }

    override fun editClik(belgi: Belgi, position: Int) {
        Data.belgi=belgi
        Toast.makeText(context, "button", Toast.LENGTH_SHORT).show()

        findNavController().navigate(R.id.action_yolBelgisiListFragment_to_editFragment, bundleOf("belgi" to belgi))
    }

    override fun delete(belgi: Belgi, position: Int) {


           dbHelper.deleteBelgi(belgi)
            lists.remove(belgi)
            rvAdapter.notifyDataSetChanged()
        Toast.makeText(context, "delete", Toast.LENGTH_SHORT).show()
//
//        val dialog=AlertDialog.Builder(binding.root.context)
//          dialog.setTitle("Rozimisz")
//           dialog.setMessage("${belgi.name}ochirilsinmi?")
//            dialog.setPositiveButton("ha"){
//                dialog,which->
//                dbHelper.deleteBelgi(belgi)
//                onResume()
//            }
//          dialog.setNegativeButton("Yo'q")
//          {
//              dialog,which->
//              dialog.cancel()
//          }
//        dialog.show()
//        dialog


    }

    override fun like(belgi: Belgi) {



        Toast.makeText(context, "this", Toast.LENGTH_SHORT).show()
        if (belgi.like==0){
            belgi.like=1
        }else{
            belgi.like=0
        }


    }

    override fun itemClik(belgi: Belgi) {
        findNavController().navigate(R.id.yolBelgisiListFragment, bundleOf("belgi" to belgi))
    }


}