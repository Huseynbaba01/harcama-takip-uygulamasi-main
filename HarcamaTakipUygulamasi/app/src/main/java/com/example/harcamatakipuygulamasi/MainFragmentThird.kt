package com.example.harcamatakipuygulamasi

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.example.harcamatakipuygulamasi.data.HarcamaEntity
import com.example.harcamatakipuygulamasi.data.MainFragmentThirdViewModel
import com.example.harcamatakipuygulamasi.data.RecyclerViewAdapter

class MainFragmentThird : Fragment(),RecyclerViewAdapter.RecyclerViewElementClickListener{
    private lateinit var buttonGeri: Button
    private lateinit var buttonEkle: Button
    private lateinit var textAciklama: EditText
    private lateinit var textHarcama: EditText
    private lateinit var radioGroup1: RadioGroup
    private lateinit var radioGroup2: RadioGroup
    private lateinit var radioTL: RadioButton
    private lateinit var radioEuro: RadioButton
    private lateinit var radioDollar: RadioButton
    private lateinit var radioSterling: RadioButton
    private lateinit var radioFatura: RadioButton
    private lateinit var radioKira: RadioButton
    private lateinit var radioDiger: RadioButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MainFragmentThirdViewModel
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(MainFragmentThirdViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_main_third, container, false)
        val view2 = inflater.inflate(R.layout.fragment_main_second, container, false)
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
        recyclerViewAdapter = RecyclerViewAdapter(MainFragmentSecond())
        buttonGeri.setOnClickListener{

            navigateForButtons()
        }
        buttonEkle.setOnClickListener{
            var harcama:HarcamaEntity

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
                operate()
                navigateForButtons()}
            else{
                Toast.makeText(context,"Tüm gereksimleri doldurmanız gerekir!",Toast.LENGTH_SHORT).show()
            }
        }
       /* recyclerView = view2.findViewById(R.id.recyclerView)
        recyclerView.apply{
            val thisContext = container?.context
            layoutManager = LinearLayoutManager(thisContext)
            recyclerViewAdapter = RecyclerViewAdapter(this@MainFragmentThird)
            recyclerView.adapter = recyclerViewAdapter
            val divider = DividerItemDecoration(thisContext,VERTICAL)
            addItemDecoration(divider)
        }
        viewModel = ViewModelProviders.of(this).get(MainFragmentThirdViewModel::class.java)
        viewModel.getAllHarcamaObservers().observe(viewLifecycleOwner, Observer {
            recyclerViewAdapter.setListData(ArrayList(it))
        })*/
        return view
    }

    private fun operate() {
        val harcamaPrice = textHarcama.text.toString().toDouble()
        val aciklama = textAciklama.text.toString()
        val currency: Int
        val type: Int
        when {
            radioTL.isChecked ->     currency = 1
            radioEuro.isChecked ->   currency = 2
            radioDollar.isChecked -> currency = 3
            else -> currency = 4
        }
        when{
            radioFatura.isChecked -> type = 1
            radioKira.isChecked ->   type = 2
            else ->                  type = 3
        }
        val harcama = HarcamaEntity(0,aciklama,harcamaPrice,type, currency)
//        viewModel.insertAllHarcamaInfoEntity(harcama)
        viewModel.getAllHarcamaObservers().observe(viewLifecycleOwner, Observer {
            recyclerViewAdapter.setListData(ArrayList(it))
            recyclerViewAdapter.notifyDataSetChanged()
        })
        onItemClickListener(harcama)
        viewModel.insertAllHarcamaInfoEntity(harcama)

    }

    private fun navigateForButtons(){
        findNavController().navigate(R.id.action_mainFragmentThird_to_mainFragmentSecond)
    }

    override fun onDeleteHarcamaClickListener(harcama: HarcamaEntity) {

    }
/*
    override fun onDeleteHarcamaClickListener(harcama: HarcamaEntity) {
        viewModel.deleteAllHarcamaInfoEntity(harcama)
    }*/

    override fun onItemClickListener(harcama: HarcamaEntity) {
        textHarcama.setText(harcama.kiymet.toString())
        textAciklama.setText(harcama.aciklama.toString())
        when{
            harcama.type == 1 -> radioFatura.setChecked(true)
            harcama.type == 2 -> radioKira.setChecked(true)
            else -> radioDiger.setChecked(true)
        }
        when{
            harcama.currency == 1 -> radioTL.setChecked(true)
            harcama.currency == 2 -> radioEuro.setChecked(true)
            harcama.currency == 3 -> radioDollar.setChecked(true)
            else -> radioSterling.setChecked(true)
        }
    }

}