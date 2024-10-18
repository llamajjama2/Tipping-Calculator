package com.example.tippymippy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class splitAmount : AppCompatActivity() {
    private lateinit var spTotalPeopleInput: EditText
    private lateinit var spCostInput: EditText
    private lateinit var spSplitAmount: TextView
    private lateinit var backButton2: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_split_amount)

        spTotalPeopleInput = findViewById(R.id.spTotalPeopleInput)
        spCostInput = findViewById(R.id.spCostInput)
        spSplitAmount = findViewById(R.id.spSplitAmount)
        backButton2 = findViewById(R.id.backButton2)

        backButton2.setOnClickListener {
            val intent = Intent(this, MainScreen::class.java)
            startActivity(intent)
        }

        spTotalPeopleInput.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                computeSplitAmount()
            }


        })

        spCostInput.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                computeSplitAmount()
            }
        })


    }
    private fun computeSplitAmount() {
        if(spCostInput.text.isEmpty() || spTotalPeopleInput.text.isEmpty()) {
            spSplitAmount.text = ""
            return
        }
        val numberPeople = spTotalPeopleInput.text.toString().toInt()
        val baseAmount = spCostInput.text.toString().toDouble()
        val splitAmount = baseAmount / numberPeople
        spSplitAmount.text = "%.2f".format(splitAmount)
    }
}