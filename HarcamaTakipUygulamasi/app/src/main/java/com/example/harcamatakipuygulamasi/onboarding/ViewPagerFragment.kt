package com.example.harcamatakipuygulamasi.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.harcamatakipuygulamasi.R
import com.example.harcamatakipuygulamasi.databinding.FragmentViewPagerBinding
import com.example.harcamatakipuygulamasi.screens.FirstOnBoardingFragment
import com.example.harcamatakipuygulamasi.screens.SecondOnBoardingFragment
import com.example.harcamatakipuygulamasi.onboarding.screens.ThirdOnBoardingFragment

class ViewPagerFragment : androidx.fragment.app.Fragment() {
    private lateinit var binding:FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val fragmentList = arrayListOf<Fragment>(
            FirstOnBoardingFragment(),
            SecondOnBoardingFragment(),
            ThirdOnBoardingFragment()
        )
        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_view_pager,container,false)
        binding.viewPager.adapter = adapter
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }
}