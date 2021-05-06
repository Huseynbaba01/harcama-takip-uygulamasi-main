package com.example.harcamatakipuygulamasi

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavGraph
import androidx.navigation.findNavController

class SplashFragment : Fragment() {
//    var navGraph : NavGraph
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
//        navGraph = view.findViewById(R.id.nav_graph)
//        navGraph.getAction(R.id.action_splashFragment_to_onBoarding1).
        Handler(Looper.getMainLooper()).postDelayed({
            view.findNavController().navigate(R.id.action_splashFragment_to_onBoarding1)

        }, 2000)
        // Inflate the layout for this fragment
          return view
    }
}