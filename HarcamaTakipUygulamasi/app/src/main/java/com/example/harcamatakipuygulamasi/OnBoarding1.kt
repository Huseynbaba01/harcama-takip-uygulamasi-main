package com.example.harcamatakipuygulamasi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.harcamatakipuygulamasi.databinding.FragmentOnBoarding1Binding

class OnBoarding1 : Fragment() {
    private lateinit var binding:FragmentOnBoarding1Binding
    private lateinit var button: Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.i("test", "OnBoarding1 created successfully!")
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_on_boarding1, container, false)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_on_boarding1,container,false)
        button = view.findViewById(R.id.buttonSkip)
        button.setOnClickListener{
              view?.findNavController()?.navigate(R.id.action_onBoarding1_to_onBoarding2)
        }
        return view
    }

}