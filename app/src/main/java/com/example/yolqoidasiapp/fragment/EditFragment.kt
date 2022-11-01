package com.example.yolqoidasiapp.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.yolqoidasiapp.adapter.PagerAdapter
import com.example.yolqoidasiapp.adapter.RvAdapter
import com.example.yolqoidasiapp.databinding.FragmentEditBinding
import com.example.yolqoidasiapp.db.Data
import com.example.yolqoidasiapp.db.DbHelper
import com.example.yolqoidasiapp.models.Belgi
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class EditFragment : Fragment() {
    private lateinit var binding: FragmentEditBinding
    private lateinit var dbHelper: DbHelper
    private lateinit var path: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(layoutInflater)
        path = ""

        dbHelper = DbHelper(binding.root.context)

        binding.imageGalery.setOnClickListener {
            getImageContent.launch("image/*")
        }

        binding = FragmentEditBinding.inflate(layoutInflater)
        binding.imageGalery.setImageURI(Uri.parse(Data.belgi.imagePath))
        binding.edtGuruhNomi.setText(Data.belgi.name)
        binding.edtGuruhNomi2.setText(Data.belgi.matn)
//        binding.spiner2.setSelection(Data.belgi.category)
        path = Data.belgi.imagePath.toString()
        binding.saqlash.setOnClickListener {

            Data.belgi.name = binding.edtGuruhNomi.text.toString().trim()
            Data.belgi.matn = binding.edtGuruhNomi2.text.toString().trim()
            Data.belgi.imagePath = path
//             Data.belgi.category=binding.spiner2.selectedItemPosition
            dbHelper.editBelgi(Data.belgi)

            Toast.makeText(context, "save", Toast.LENGTH_SHORT).show()
         findNavController().popBackStack()


        }





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
            path = file.absolutePath
        }

}