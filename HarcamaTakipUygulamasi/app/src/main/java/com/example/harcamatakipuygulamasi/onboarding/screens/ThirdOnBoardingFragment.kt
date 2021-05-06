package com.example.harcamatakipuygulamasi.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.harcamatakipuygulamasi.R
import com.example.harcamatakipuygulamasi.databinding.FragmentThirdOnBoardingBinding

class ThirdOnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentThirdOnBoardingBinding
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val viewPager2 = view?.findViewById<ViewPager2>(R.id.viewPager)
         binding.buttonSkip.setOnClickListener{
             viewPager2?.currentItem = 3
         }
        return inflater.inflate(R.layout.fragment_third_on_boarding, container, false)
    }
}