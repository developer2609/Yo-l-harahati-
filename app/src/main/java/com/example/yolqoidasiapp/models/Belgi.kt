package com.example.yolqoidasiapp.models

import java.io.Serializable

class Belgi:Serializable {
    var id:Int? = null
    var name:String? = null
    var matn:String? = null
    var imagePath:String? = null
    var like : Int= 0
    var category:Int = 0


    constructor(
        id: Int?,
        name: String?,
        matn: String?,
        imagePath: String?,
        like: Int,
        category: Int
    ) {
        this.id = id
        this.name = name
        this.matn = matn
        this.imagePath = imagePath
        this.like = like
        this.category = category
    }

    constructor(name: String?, matn: String?, imagePath: String?, like: Int, category: Int) {
        this.name = name
        this.matn = matn
        this.imagePath = imagePath
        this.like = like
        this.category = category
    }

    constructor()

    override fun toString(): String {
        return "Belgi(id=$id, name=$name, matn=$matn, imagePath=$imagePath, like=$like, category=$category)"
    }


}