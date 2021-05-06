package com.example.harcamatakipuygulamasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText

class MainFragmentFirst : Fragment() {
    private lateinit var buttonGeri: Button
    private lateinit var buttonKaydet: Button
    private lateinit var radioGroup: RadioGroup
    private lateinit var userTextInput:TextInputEditText
    private lateinit var radioMan: RadioButton
    private lateinit var radioWoman: RadioButton
    private lateinit var radioNoSex: RadioButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_main_first, container, false)
        buttonGeri = view.findViewById(R.id.buttongeri)
        buttonKaydet = view.findViewById(R.id.buttonkaydet)
        radioGroup = view.findViewById(R.id.radiogroup)
        userTextInput = view.findViewById(R.id.Name)
        radioMan = view.findViewById(R.id.radio_man)
        radioWoman = view.findViewById(R.id.radio_woman)
        radioNoSex = view.findViewById(R.id.radio_no_sex)
        buttonKaydet.setOnClickListener{
            if(userTextInput.text.toString()!="" && (radioMan.isChecked || radioWoman.isChecked || radioNoSex.isChecked)){
            navigateForButtons()}
            else{
                Toast.makeText(context,"Tüm gereksimleri doldurmanız gerekir!",Toast.LENGTH_SHORT).show()
            }
        }
        buttonGeri.setOnClickListener{
            navigateForButtons()
        }
        return view
    }
    private fun navigateForButtons(){
        findNavController().navigate(R.id.action_mainFragmentFirst_to_mainFragmentSecond)
    }
}