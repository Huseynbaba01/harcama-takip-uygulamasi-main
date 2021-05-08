package com.example.harcamatakipuygulamasi.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.harcamatakipuygulamasi.MainFragmentSecond
import com.example.harcamatakipuygulamasi.R

class RecyclerViewAdapter(val listener: MainFragmentSecond): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    var items = ArrayList<HarcamaEntity>()
    fun setListData(data: ArrayList<HarcamaEntity>){
        this.items = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_element,parent,false)

        return MyViewHolder(inflater,listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            listener.onItemClickListener(items[position])
        }
        holder.bind(items[position])
    }
    class MyViewHolder(view: View, val listener:RecyclerViewElementClickListener):RecyclerView.ViewHolder(view){
        val aciklama = view.findViewById<TextView>(R.id.recyclerText)
        val image = view.findViewById<ImageView>(R.id.recyclerImage)
        val price = view.findViewById<TextView>(R.id.recyclerPriceText)
        val currency = view.findViewById<TextView>(R.id.recyclerPriceCurrency)
        val deleteHarcama = view.findViewById<ImageView>(R.id.deleteButton)
        fun bind(data:HarcamaEntity){
            var temp = data.type
            when (temp) {
                1 -> image.setImageResource(R.drawable.ic_fatura)
                2 -> image.setImageResource(R.drawable.ic_home)
                else -> image.setImageResource(R.drawable.ic_diger)
            }
            aciklama.text = data.aciklama
            price.text = data.kiymet.toString()
            temp = data.currency
            when (temp) {
                1 -> currency.text = R.string.currencyTL.toString()
                2 -> currency.text = R.string.euro.toString()
                3 -> currency.text = R.string.dolar.toString()
                else -> currency.text = R.string.sterling.toString()
            }
            deleteHarcama.setOnClickListener{
                listener.onDeleteHarcamaClickListener(data)
            }
        }
    }
    interface RecyclerViewElementClickListener{
        fun onDeleteHarcamaClickListener(harcama:HarcamaEntity)
        fun onItemClickListener(harcama:HarcamaEntity)
    }

}