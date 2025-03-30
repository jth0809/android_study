package com.example.basic2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var button1: Button
    lateinit var radioGroup: RadioGroup
    lateinit var checkBox: CheckBox
    lateinit var radioButton1: RadioButton
    lateinit var radioButton2: RadioButton
    lateinit var radioButton3: RadioButton
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.button1)
        radioGroup = findViewById(R.id.rgroup)
        checkBox = findViewById(R.id.check)
        radioButton1 = findViewById(R.id.radio1)
        radioButton2 = findViewById(R.id.radio2)
        radioButton3 = findViewById(R.id.radio3)
        imageView = findViewById(R.id.image1)
        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if(checkBox.isChecked){
                radioGroup.visibility = android.view.View.VISIBLE
            }else{
                radioGroup.visibility = android.view.View.INVISIBLE
            }
        }
        button1.setOnClickListener {
            when(radioGroup.checkedRadioButtonId){
                R.id.radio1 -> imageView.setImageResource(R.drawable.dog)
                R.id.radio2 -> imageView.setImageResource(R.drawable.cat)
                R.id.radio3 -> imageView.setImageResource(R.drawable.rabbit)
                else -> Toast.makeText(applicationContext, "동물 먼저 선택하세요", Toast.LENGTH_SHORT).show()
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}