package com.example.harcamatakipuygulamasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class MainFragmentFourth : Fragment() {
    private lateinit var imageView: View
    private lateinit var textAciklama: TextView
    private lateinit var textHarcama: TextView
    private lateinit var buttonGeri: Button
    private lateinit var buttonSil: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_fourth, container, false)
        imageView = view.findViewById(R.id.imageView)
        textAciklama = view.findViewById(R.id.textView1)
        textHarcama = view.findViewById(R.id.textView2)
        buttonGeri = view.findViewById(R.id.buttongeri)
        buttonSil = view.findViewById(R.id.buttonsil)
        buttonSil.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragmentFourth_to_mainFragmentSecond)
        }
        buttonGeri.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragmentFourth_to_mainFragmentSecond)
        }

        return view
    }

}