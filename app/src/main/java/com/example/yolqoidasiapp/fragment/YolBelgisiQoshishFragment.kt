package com.example.yolqoidasiapp.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.yolqoidasiapp.adapter.RvAdapter
import com.example.yolqoidasiapp.databinding.FragmentYolBelgisiQoshishBinding
import com.example.yolqoidasiapp.db.Data
import com.example.yolqoidasiapp.db.DbHelper
import com.example.yolqoidasiapp.models.Belgi
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class YolBelgisiQoshishFragment : Fragment() {
    private lateinit var binding: FragmentYolBelgisiQoshishBinding
    private lateinit var spinnerList: ArrayList<String>
    private lateinit var list: ArrayList<Belgi>
    private lateinit var dbHelper: DbHelper
    private lateinit var uriPath: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYolBelgisiQoshishBinding.inflate(layoutInflater)
        binding.imageGalery.setOnClickListener {
            getImageContent.launch("image/*")

        }


        spinnerList = ArrayList()
        spinnerList.add("Ogohlanturuvchi")
        spinnerList.add("Imtiyoz")
        spinnerList.add("Ta'qiqlovchi")
        spinnerList.add("Buyuruvchi")
        binding.spiner.adapter =
            ArrayAdapter(binding.root.context, android.R.layout.simple_list_item_1, spinnerList)

        binding.qaytish.setOnClickListener {
            findNavController().popBackStack()
        }

        dbHelper = DbHelper(context)

        list = ArrayList()

        binding.saqlash.setOnClickListener {

            var belgi = Belgi(
                name = binding.edtGuruhNomi.text.toString(),
                matn = binding.edtGuruhNomi2.text.toString(),
                imagePath = uriPath,
                like = 0,
                category = spinnerList.indexOf(spinnerList[binding.spiner.selectedItemPosition])
            )



            dbHelper.addQoida(belgi)

            Toast.makeText(context, "Save",  Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
             uriPath=""
        // Inflate the layout for this fragment
        Data.belgi.name=binding.edtGuruhNomi.text.toString()
        Data.belgi.imagePath=uriPath
        Data.belgi.matn=binding.edtGuruhNomi2.text.toString()
        Data.belgi.category=binding.spiner.selectedItemPosition
        return binding.root
    }

    private val getImageContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) {
            it ?: return@registerForActivityResult
            binding.imageGalery.setImageURI(it)
            val inputStream = requireActivity().contentResolver.openInputStream(it)
            val title = SimpleDateFormat("yyyyMMdd_hhmmss").format(Date())
            val file = File(requireActivity().filesDir, "$title.jpg")
            val fileOutputStream = FileOutputStream(file)
            inputStream?.copyTo(fileOutputStream)
            inputStream?.close()
            fileOutputStream.close()
            uriPath = file.absolutePath
        }

}

