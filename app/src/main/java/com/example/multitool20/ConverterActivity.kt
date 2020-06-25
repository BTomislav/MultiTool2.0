package com.example.multitool20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_converter.*

lateinit var a: Spinner
lateinit var b: Spinner
lateinit var c: Spinner


class ConverterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)

        val spinner: Spinner = findViewById(R.id.spinner)
        val spinner2: Spinner = findViewById(R.id.spinner2)
        val spinnerCategory: Spinner = findViewById(R.id.spinner_category)
        val buttonSwap: Button = findViewById(R.id.button3)
        a=spinner
        b=spinner2

        buttonSwap.setOnClickListener {
            if (motionLayout.progress==0.0f){
                motionLayout.transitionToEnd()
                spinner.setBackgroundResource(R.drawable.custom_spinner2)
                spinner2.setBackgroundResource(R.drawable.custom_spinner)
                SwapSpinners()
                //Toast.makeText(this, ""+a.selectedItem.toString()+" je prvi, a "+b.selectedItem.toString()+" je drugi", Toast.LENGTH_SHORT).show()
            }

            if (motionLayout.progress==1.0f){
                motionLayout.transitionToStart()
                spinner.setBackgroundResource(R.drawable.custom_spinner)
                spinner2.setBackgroundResource(R.drawable.custom_spinner2)
                SwapSpinners()
                //Toast.makeText(this, ""+a.selectedItem.toString()+" je prvi, a "+b.selectedItem.toString()+" je drugi", Toast.LENGTH_SHORT).show()
            }

        }

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter2 ->
            // Specify the layout to use when the list of choices appears
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner2.adapter = adapter2
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.category,
            android.R.layout.simple_spinner_item
        ).also { adapter3 ->
            // Specify the layout to use when the list of choices appears
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerCategory.adapter = adapter3
        }
    }

    private fun SwapSpinners() {
        c= a
        a= b
        b=c
    }
}