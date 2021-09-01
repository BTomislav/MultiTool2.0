package com.example.multitool20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_converter.*

lateinit var a: Spinner
lateinit var b: Spinner
lateinit var c: Spinner

class ConverterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)

        val spinner= findViewById<Spinner>(R.id.spinner)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val spinnerCategory= findViewById<Spinner>(R.id.spinner_category)
        val buttonSwap: Button = findViewById(R.id.button3)

        a=spinner
        b=spinner2

        ArrayAdapter.createFromResource(
            this,
            R.array.category,
            android.R.layout.simple_spinner_item
        ).also { adapter3 ->
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCategory.adapter = adapter3
        }

        buttonSwap.setOnClickListener {
            if (motionLayout.progress==0.0f){
                motionLayout.transitionToEnd()
                spinner.setBackgroundResource(R.drawable.custom_spinner2)
                spinner2.setBackgroundResource(R.drawable.custom_spinner)
                SwapSpinners()
            }

            if (motionLayout.progress==1.0f){
                motionLayout.transitionToStart()
                spinner.setBackgroundResource(R.drawable.custom_spinner)
                spinner2.setBackgroundResource(R.drawable.custom_spinner2)
                SwapSpinners()
            }
        }

        spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when(position){
                    0 -> {
                        ArrayAdapter.createFromResource(
                        this@ConverterActivity,
                        R.array.temperature,
                        android.R.layout.simple_spinner_item
                    ).also { spinnerAdapter ->
                        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinner.adapter = spinnerAdapter
                        spinner2.adapter= spinnerAdapter
                    }
                    }
                    1 -> {
                        ArrayAdapter.createFromResource(
                            this@ConverterActivity,
                            R.array.length,
                            android.R.layout.simple_spinner_item
                        ).also { spinnerAdapter ->
                            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            spinner.adapter = spinnerAdapter
                            spinner2.adapter= spinnerAdapter
                        }
                    }
                    2 -> {
                        ArrayAdapter.createFromResource(
                            this@ConverterActivity,
                            R.array.currency,
                            android.R.layout.simple_spinner_item
                        ).also { spinnerAdapter ->
                            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            spinner.adapter = spinnerAdapter
                            spinner2.adapter= spinnerAdapter
                        }
                    }
                    3 -> {
                        ArrayAdapter.createFromResource(
                            this@ConverterActivity,
                            R.array.weight,
                            android.R.layout.simple_spinner_item
                        ).also { spinnerAdapter ->
                            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            spinner.adapter = spinnerAdapter
                            spinner2.adapter= spinnerAdapter
                        }
                    }
                    4 -> {
                        ArrayAdapter.createFromResource(
                            this@ConverterActivity,
                            R.array.speed,
                            android.R.layout.simple_spinner_item
                        ).also { spinnerAdapter ->
                            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            spinner.adapter = spinnerAdapter
                            spinner2.adapter= spinnerAdapter
                        }
                    }
                    5-> {
                        ArrayAdapter.createFromResource(
                            this@ConverterActivity,
                            R.array.time,
                            android.R.layout.simple_spinner_item
                        ).also { spinnerAdapter ->
                            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                            spinner.adapter = spinnerAdapter
                            spinner2.adapter= spinnerAdapter
                        }
                    }
                }
            }
        }




    }

    private fun SwapSpinners() {
        c= a
        a= b
        b=c
    }
}