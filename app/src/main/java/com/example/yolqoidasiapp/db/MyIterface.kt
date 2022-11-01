package com.example.yolqoidasiapp.db

import com.example.yolqoidasiapp.models.Belgi

interface MyIterface {
    fun addQoida(belgi: Belgi)
    fun getQoida():ArrayList<Belgi>
    fun deleteBelgi(belgi: Belgi)
    fun editBelgi(belgi: Belgi)


}