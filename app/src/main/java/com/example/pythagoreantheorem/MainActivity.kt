package com.example.pythagoreantheorem

import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pythagoreantheorem.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClick(view: View) {
        if (!isTextFieldEmpty()) {
            val text = getString(R.string.result)  + getResult()
            binding.resultTextView.text = text
        }
    }

    private fun isTextFieldEmpty(): Boolean {
        binding.apply {
            if (inputA.text.isNullOrEmpty()) inputA.error = getString(R.string.input_error)
            if (inputB.text.isNullOrEmpty()) inputB.error = getString(R.string.input_error)
            return inputA.text.isNullOrEmpty() || inputB.text.isNullOrEmpty()
        }
    }

    private fun getResult(): String {
        val a: Double
        val b: Double
        binding.apply {
            a = inputA.text.toString().toDouble()
            b = inputB.text.toString().toDouble()
            val c = sqrt((a.pow(2) + b.pow(2))).toString()
            val formatC = String.format("%.2f", c.toFloat())
            return formatC
        }
    }
}