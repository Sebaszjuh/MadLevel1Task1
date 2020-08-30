package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1
    private var resourceName : String = "dice$currentThrow"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }


    private fun updateUI() {
        binding.imageView.setImageResource(resources.getIdentifier(resourceName,"drawable", resourceName))
        binding.viewlastThrow.text = getString(R.string.lastThrow, lastThrow)

    }

    private fun initView(){
        binding.button
        updateUI()
    }

    private fun rollDice(){
        lastThrow = currentThrow
        currentThrow=(Math.random()*6+1).toInt();
        updateUI()
    }



}