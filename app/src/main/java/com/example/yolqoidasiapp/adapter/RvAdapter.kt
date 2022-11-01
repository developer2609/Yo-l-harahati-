package com.example.yolqoidasiapp.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.os.persistableBundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.yolqoidasiapp.databinding.ItemLayoutBinding
import com.example.yolqoidasiapp.models.Belgi

class RvAdapter (var list: List<Belgi>,val onItemClik:OnItemClik) : RecyclerView.Adapter<RvAdapter.VP_Vh>() {

    inner class VP_Vh(var itemListBinding: ItemLayoutBinding):
        RecyclerView.ViewHolder(itemListBinding.root) {
        fun onBind(belgi: Belgi,position: Int) {
            itemListBinding.textView.text=belgi.name
            itemListBinding.imageKorish.setImageURI(Uri.parse(belgi.imagePath))

            itemListBinding.linerRasm.setOnClickListener {
           onItemCllik.onItemCliked(list[position],position)
            }

            itemListBinding.editBelgi.setOnClickListener {
                onItemClik.editClik(belgi,position)
            }
            itemListBinding.deleteCard.setOnClickListener {
                onItemClik.delete(belgi,position)
            }

            itemListBinding.heart.setOnClickListener {
                onItemClik.like(belgi)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VP_Vh {
        return VP_Vh(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    }

    override fun onBindViewHolder(holder: VP_Vh, position: Int) {
        holder.onBind(list[position],position)
    }

    override fun getItemCount(): Int = list.size

    interface   OnItemClik{
        fun onItemCliked(belgi: Belgi,position: Int)
        fun editClik(belgi: Belgi,position: Int)
        fun delete(belgi: Belgi,position: Int)
        fun like(belgi: Belgi)
        fun itemClik(belgi: Belgi)
    }




}
