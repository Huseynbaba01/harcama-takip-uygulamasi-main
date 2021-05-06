package com.example.harcamatakipuygulamasi.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.harcamatakipuygulamasi.R
import com.example.harcamatakipuygulamasi.databinding.FragmentSecondOnBoardingBinding

class SecondOnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentSecondOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val viewPager2 = view?.findViewById<ViewPager2>(R.id.viewPager)
        binding.buttonSkip.setOnClickListener{
            viewPager2?.currentItem = 2
        }
        return inflater.inflate(R.layout.fragment_second_on_boarding, container, false)
    }
}