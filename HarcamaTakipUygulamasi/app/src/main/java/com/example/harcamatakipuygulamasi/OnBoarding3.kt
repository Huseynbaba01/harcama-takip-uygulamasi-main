package com.example.harcamatakipuygulamasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.harcamatakipuygulamasi.databinding.FragmentOnBoarding1Binding
import com.example.harcamatakipuygulamasi.databinding.FragmentOnBoarding3Binding

class OnBoarding3 : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var button: Button
    private lateinit var binding: FragmentOnBoarding3Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_on_boarding3, container, false)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_on_boarding3,container,false)
        button = view.findViewById(R.id.buttonSkip)
        button.setOnClickListener{
           view?.findNavController()?.navigate(R.id.action_onBoarding3_to_mainFragmentFirst)
        }
        return view
    }

}