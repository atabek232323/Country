package com.example.myapplication.recyclerViev

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ListCounBinding
import com.example.myapplication.model.CountryModel
import java.util.Date.from

class Adapter(val context : Context) : RecyclerView.Adapter<Adapter.MyVievHolger>() {
    private lateinit var binding : ListCounBinding
    var list : List<CountryModel> = emptyList()


    class MyVievHolger( private val binding : ListCounBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(countryModel : CountryModel ,context : Context) {
           binding.tvName.text = countryModel.name
            binding.tvCapital.text = countryModel.capital
            binding.tvRegion.text = countryModel.region
            binding.tvCurrency.text = countryModel.currency
            binding.tvLanguage.text = countryModel.language

            Glide.with(context).load(countryModel.flag).into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : MyVievHolger {
        binding = ListCounBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyVievHolger(binding)
    }

    override fun onBindViewHolder(holder : MyVievHolger, position : Int) {
        holder.bind(list[position],context)
    }

    override fun getItemCount() : Int {
        return list.size
    }

    fun setData(list : List<CountryModel>) {
        this.list = list
        notifyDataSetChanged()
    }
}