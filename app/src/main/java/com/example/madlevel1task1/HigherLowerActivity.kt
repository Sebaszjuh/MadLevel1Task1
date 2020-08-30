package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1
    private var resourceName: String = "dice$currentThrow"
    private var score: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun updateUI() {
        binding.imageView.setImageResource(resources.getIdentifier(resourceName, "drawable", packageName))
        binding.viewlastThrow.text = getString(R.string.lastDiceThrow, currentThrow)
        binding.viewScore.text = getString(R.string.viewScore, score)
    }

    private fun initView() {
        binding.btnHigher.setOnClickListener { guessHigher() }
        binding.btnEqual.setOnClickListener { guessEqual() }
        binding.btnLower.setOnClickListener { guessLower() }
        binding.btnReset.setOnClickListener { onReset() }
        updateUI()
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (Math.random() * 6 + 1).toInt();
        updateUI()
    }

    private fun onReset() {
        lastThrow = 1;
        score = 0;
        updateUI()
    }

    private fun guessHigher() {
        rollDice()
        if (currentThrow > lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun guessEqual() {
        rollDice()
        if (currentThrow == lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }

    }

    private fun guessLower() {
        rollDice()
        if (currentThrow < lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onAnswerCorrect() {
        score++
        resourceName = "dice$currentThrow"
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
        updateUI()
    }


    private fun onAnswerIncorrect() {
        score--
        resourceName = "dice$currentThrow"
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
        updateUI()
    }

}