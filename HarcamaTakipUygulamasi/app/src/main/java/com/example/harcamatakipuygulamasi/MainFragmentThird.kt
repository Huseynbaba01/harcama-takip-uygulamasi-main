package com.example.harcamatakipuygulamasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController

class MainFragmentThird : Fragment() {
    private lateinit var buttonGeri: Button
    private lateinit var buttonEkle:Button
    private lateinit var textAciklama: EditText
    private lateinit var textHarcama: EditText
    private lateinit var radioGroup1: RadioGroup
    private lateinit var radioGroup2: RadioGroup
    private lateinit var radioTL: RadioButton
    private lateinit var radioEuro: RadioButton
    private lateinit var radioDollar: RadioButton
    private lateinit var radioSterling: RadioButton
    private lateinit var radioFatura:RadioButton
    private lateinit var radioKira:RadioButton
    private lateinit var radioDiger:RadioButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_third, container, false)
        buttonGeri = view.findViewById(R.id.buttongeri)
        buttonEkle = view.findViewById(R.id.buttonekle)
        textAciklama = view.findViewById(R.id.aciklama)
        textHarcama = view.findViewById(R.id.harcama)
        radioTL = view.findViewById(R.id.radioTL)
        radioEuro = view.findViewById(R.id.radioEuro)
        radioDollar = view.findViewById(R.id.radioDollar)
        radioSterling = view.findViewById(R.id.radioSterling)
        radioFatura = view.findViewById(R.id.radioFatura)
        radioKira = view.findViewById(R.id.radioKira)
        radioDiger = view.findViewById(R.id.radioDiger)
        radioGroup1 = view.findViewById(R.id.radiogroup1)
        radioGroup2 = view.findViewById(R.id.radiogroup2)
        buttonGeri.setOnClickListener{
                navigateForButtons()
        }
        buttonEkle.setOnClickListener{
            if(radioGroup1.isEnabled
                    && (
                            radioFatura.isChecked
                            ||radioKira.isChecked
                            || radioDiger.isChecked)
                    &&(
                            radioTL.isChecked
                                    || radioEuro.isChecked
                                    || radioDollar.isChecked
                                    || radioSterling.isChecked
                            )
                    && textAciklama.text.toString() != ""
                    && textHarcama.text.toString() !=""
            ){
                navigateForButtons()}
            else{
                Toast.makeText(context,"Tüm gereksimleri doldurmanız gerekir!",Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
    private fun navigateForButtons(){
        findNavController().navigate(R.id.action_mainFragmentThird_to_mainFragmentSecond)
    }

}