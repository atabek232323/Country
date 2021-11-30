package com.example.myapplication.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.recyclerViev.Adapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private  val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private  val adapter by lazy { Adapter(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        getCountryFromApi()
        initRecycler()

    }
     private fun initRecycler() {
        binding.resV.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun getCountryFromApi() {
        mainViewModel.getCountry()
        mainViewModel.myRespomce.observe(this, Observer {
            adapter.setData(it)
           binding.resV.adapter = adapter
        })
    }

    private fun initViewModel() {
        val repository=Repository()
        val viewModelFactory=MainViewModelFactory(repository)
        mainViewModel=ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
    }
}