package com.example.harcamatakipuygulamasi

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainFragmentSecond : Fragment() {
    private lateinit var userName: TextView
    private lateinit var overAll: TextView
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonTL: Button
    private lateinit var buttonEuro: Button
    private lateinit var buttonDollar: Button
    private lateinit var buttonSterling: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_second, container, false)
        userName = view.findViewById(R.id.user)
        overAll = view.findViewById(R.id.toplam)
        floatingActionButton = view.findViewById(R.id.floatingActionButton)
        recyclerView = view.findViewById(R.id.recyclerView)
        buttonTL = view.findViewById(R.id.btnTL)
        buttonEuro = view.findViewById(R.id.btnEuro)
        buttonDollar = view.findViewById(R.id.btnDolar)
        buttonSterling = view.findViewById(R.id.btnSterling)
        buttonTL.setOnClickListener {
            buttonTL.setTextColor(Color.CYAN)
            buttonSterling.setTextColor(Color.WHITE)
            buttonDollar.setTextColor(Color.WHITE)
            buttonEuro.setTextColor(Color.WHITE)
        }
        buttonEuro.setOnClickListener {
            buttonEuro.setTextColor(Color.CYAN)
            buttonSterling.setTextColor(Color.WHITE)
            buttonDollar.setTextColor(Color.WHITE)
            buttonTL.setTextColor(Color.WHITE)
        }
        buttonDollar.setOnClickListener {
            buttonDollar.setTextColor(Color.CYAN)
            buttonSterling.setTextColor(Color.WHITE)
            buttonTL.setTextColor(Color.WHITE)
            buttonEuro.setTextColor(Color.WHITE)
        }
        buttonSterling.setOnClickListener {
            buttonSterling.setTextColor(Color.CYAN)
            buttonTL.setTextColor(Color.WHITE)
            buttonDollar.setTextColor(Color.WHITE)
            buttonEuro.setTextColor(Color.WHITE)
        }
        userName.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragmentSecond_to_mainFragmentFirst)
        }
        floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragmentSecond_to_mainFragmentThird)
        }
        return view
    }

}