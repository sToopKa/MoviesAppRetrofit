package com.sto_opka91.mymoviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.sto_opka91.mymoviesapp.databinding.ActivityMainBinding
import com.sto_opka91.mymoviesapp.databinding.FragmentMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding?= null
    private val binding get() = mBinding!!
    lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAIN = this
        navController = Navigation.findNavController(this, R.id.nav_host)
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}