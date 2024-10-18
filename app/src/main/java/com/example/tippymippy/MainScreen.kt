package com.example.tippymippy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainScreen : AppCompatActivity() {


    private lateinit var tvTipAmountButton: Button
    private lateinit var tvSplitAmountButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)


        tvTipAmountButton = findViewById(R.id.tvTipAmountButton)
        tvTipAmountButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        tvSplitAmountButton = findViewById(R.id.tvSplitAmountButton)
        tvSplitAmountButton.setOnClickListener {
            val intent = Intent(this,  splitAmount::class.java)
            startActivity(intent)
        }


    }
}