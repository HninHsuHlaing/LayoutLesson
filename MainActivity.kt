package com.padcx.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculate_button.setOnClickListener { calculateTip() }
    }
    private fun calculateTip() {
        val stringInTextField = cost_of_service.text.toString()
        val cost1 : Double = stringInTextField.toDouble()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost1 == null) {
            tip_result.text = ""
           // return
        }

        val tipPercentage = when (tip_options.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost1
        if (round_up_switch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }else{
          //  tip = tip

        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        tip_result.text =  "tip amount "+formattedTip as String
    }
}
